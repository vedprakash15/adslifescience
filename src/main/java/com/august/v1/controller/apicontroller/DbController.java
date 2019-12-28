package com.august.v1.controller.apicontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.august.v1.domain.entity.GuestEntityBean;
import com.august.v1.domain.request.dto.RequestData;
import com.august.v1.domain.request.dto.UserBean;
import com.august.v1.service.SelectDbColumn;

@Controller
@RequestMapping("/api/db/")
public class DbController {

	@Autowired
	private SelectDbColumn selectDbColumn;

	@GetMapping("get-column")
	public ResponseEntity<?> getAllDbRow(HttpServletRequest req, @RequestBody RequestData data) {
		System.out.println("inside DbController");
		System.out.println("Data : " + data);
		List<GuestEntityBean> guestList = selectDbColumn.selectAllColumn();
		System.out.println("guestList " + guestList);
		return new ResponseEntity<List<GuestEntityBean>>(guestList, HttpStatus.OK);
	}

	@PostMapping("post-api")
	public ResponseEntity<UserBean> postApi(HttpServletRequest req,@RequestBody UserBean userBean) {
		
		System.out.println("*************" + userBean);
		try {
		
			return new ResponseEntity<UserBean>(userBean,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
