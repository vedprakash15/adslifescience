package com.august.security;

import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class CsrfSecurity extends HandlerInterceptorAdapter {
	List<String> urlList= new LinkedList<>();
	private static final String CSRF_TAG = "CSRF-CHECK";

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handleer)
			throws Exception {
		System.out.println("Inside Pre Handler");

		String reqUrl = request.getRequestURI().toString();
		System.out.println("Request URL : " + reqUrl);
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		//local host url http://localhost:8080/august/
		if (request.getRequestURI().contains("/august/")) {
			System.out.println("pre handler return true");
			//it will return and next executed postHandelr method
			//because of on above url my webApplication page working
			return true;
		}
		if (ignoreUrl().contains(request.getRequestURI())) {
			System.out.println("inside ignore uri");
			return true;
		} else {
			System.out.println("CSRF Security intercepter preHandle method started.......");
			String salt = request.getParameter("csrfPreventionSalt");
			HttpSession sessionAttribute = request.getSession();
			Cache<String, Boolean> csrfPreventionSalt = (Cache<String, Boolean>) sessionAttribute
					.getAttribute("csrfPreventionSalt");
			if (csrfPreventionSalt == null) {
				System.out.println("Salt not matched session expired..");
				parameterValuesPrint(request, "saltCacheNotFound");
				response.sendRedirect("error");
				return false;
			} else if (salt == null) {
				parameterValuesPrint(request, "noSaltValue");
				System.out.println("Potential CSRF detected !! inform ASAP");
				response.sendRedirect("error");
				return false;
			} else if (csrfPreventionSalt.getIfPresent(salt) == null) {
				System.out.println("saltValueMisMatch");
				System.out.println("Potential CSRF detected !! inform ASAP");
				response.sendRedirect("error");
			} else {
				request.setAttribute("csrfPreventionSalt", csrfPreventionSalt);
			}
			return true;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {
		System.out.println("Inside post Handler");
		System.out.println("CSRF Security key generator method started");
		try {
			//localhost url http://localhost:8080/august/
			//api is my controller path so no need to genrate token for api
			if (request.getRequestURI().contains("/august/api/")) {
				System.out.println("No need to genrate salt for api");
			} else {
				HttpSession sessionAttribute = request.getSession();
				Cache<String, Boolean> csrfPreventionSaltCache = (Cache<String, Boolean>) sessionAttribute
						.getAttribute("csrfPreventionSalt");
				System.out.println("csrfPreventionSaltCache ::: " + csrfPreventionSaltCache);
				if (csrfPreventionSaltCache == null) {
					csrfPreventionSaltCache = CacheBuilder.newBuilder().maximumSize(5000)
							.expireAfterWrite(20, TimeUnit.MINUTES).build();
					request.getSession().setAttribute("csrfPreventionSaltCache", csrfPreventionSaltCache);
				}

				String salt = RandomStringUtils.random(20, 0, 0, true, true, null, new SecureRandom());
				System.out.println("csrfPreventionSalt genrated ::: " + salt);
				csrfPreventionSaltCache.put(salt, Boolean.TRUE);
				if (modelAndView != null) {
					System.out.println("Model and view not null and salt is added in modelAndView");
					modelAndView.addObject("csrfPreventionSalt", salt);
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion : ");
		if (ex != null) {
			System.out.println("exception : " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private List<String> ignoreUrl() {
		if(urlList == null) {
			urlList.add("/august/error");
			//add here your ignored url.
		}
		return urlList;
	}

	private void parameterValuesPrint(HttpServletRequest request, String err) {
		StringBuilder reqParamAndValue = new StringBuilder();
		Enumeration<?> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			Object objOri = params.nextElement();
			String param = (String) objOri;
			String value = request.getParameter(param);
			reqParamAndValue = reqParamAndValue.append(param + "=" + value + ",");
		}
		System.out.println(CSRF_TAG + " " + err + "RequestedURL : " + request.getRequestURL());
	}
}
