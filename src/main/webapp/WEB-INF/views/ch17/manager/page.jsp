<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Insert title here</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>sign_up_form</title>
		
		<!-- 부트스트랩5를 위한 외부라이브러리 설정 -->
		<!-- Bootstrap 5를 위한 외부 라이브러리 설정 -->
		<link href="${pageContext.request.contextPath}/resources/bootstrap-5.3.3-dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath}/resources/bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
		
		<!-- jQuery 외부 라이브러리 설정 -->
		<script src="${pageContext.request.contextPath}/resources/jQuery/jquery-3.7.1.min.js"></script>
		<!--사용자정의-->
		<script>
		
		</script>
	</head>
	<body>
		<div class="d-flex flex-column "><!-- viewport height -->
	      <%@include file="/WEB-INF/views/common/header.jsp"%>
	      <div class="flex-grow-1 m-2">
	         <div class="d-flex row">
	            <div class="col-md-4">
	               <%@include file="/WEB-INF/views/common/menu.jsp"%>            
	            </div>
	            
	            <div class="col-md-8">
	               <!-- #################################### -->
	               <div class="card">
	                  <div class="card-header">manager만 볼 수 있는 내용입니다.</div>
	                 
	                  <div class="card-body">
					   	manager이다.
	                  </div>
	               </div>
	              
	               <!-- #################################### -->
	            </div>
	         </div>
	      </div> 
	   </div>
	</body>
</html>