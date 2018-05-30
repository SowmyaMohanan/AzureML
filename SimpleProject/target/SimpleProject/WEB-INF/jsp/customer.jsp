<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" href = "<s:url value='/resources/css/style.css' />">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<body ng-app = "mainApp">

<h2>Customer Details</h2>

<a href="#viewCustomer">View Customer</a>
<a href="#report">Report</a>
<br>
<div ng-view></div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular-route.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<%-- <script src="<s:url value='/app/app.js' />"></script>
<script src="<s:url value='/app/add/AddStudentController.js' />"></script>
<script src="<s:url value='/app/add/AddStudentService.js' />"></script>
<script src="<s:url value='/app/modify/ModifyStudentController.js' />"></script>
<script src="<s:url value='/app/modify/ModifyStudentService.js' />"></script>
<script src="<s:url value='/app/view/ViewStudentController.js' />"></script>
<script src="<s:url value='/app/view/ViewStudentService.js' />"></script>
<script src="<s:url value='/app/slider/SliderController.js' />"></script> --%>



</body>
</html>