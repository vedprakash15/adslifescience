<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resources/javascript/jquery.js"></script>
<script src="resources/javascript/controller.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADS Home</title>
</head>
<body>
<h4><%=request.getContextPath()%></h4>
<h1>${csrfPreventionSalt}</h1>
<input type="hidden" name="csrfPreventionSalt" value=${csrfPreventionSalt}>
<form method = "get" onsubmit="getFormData()" id ="form2">
Id :<input type ="text" name = "id" id ="id"/><br><br>
Name :<input type ="text" name = "name" id ="name"/><br><br>
Password :<input type ="password" name = "pwd" id ="pwd"/><br><br>
Email <input type ="text" name = "email" id ="email"/><br><br>

<input type ="Submit" name = "Submit" id ="submit1"/><br><br>
</form>

<form method="POST" id="form1">
        <label>username</lable>
            <input id="username" name="username" type="text">
            <label>emailid</lable>
                <input id="emailid" name="emailid" type="text">
                <button id="enter" type="submit" id="submit">submit</button>
 </form>
</body>
</html>