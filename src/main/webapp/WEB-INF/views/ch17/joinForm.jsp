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
	                  <div class="card-header">회원가입</div>
	                       
	                  <div class="card-body">
					  	<form method="post" action="join"><!-- 상대경로 -->
					  	   
					  	   <%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%> 
					  	   <!-- csrf 토큰을 사용해서  폼의 유효성 검사를 할거라면 프로젝트의 모든 form에 이 input태그를 포함해야 한다. 
					  	   		기본적으로 필요하지만 개발 할때 너무 귀찮아 개발할 때는 안한다. -->
						   
						   <div class="form-group mb-2">
						       <label for="mid">Member ID</label>
						       <input type="text" class="form-control" id="mid" name="mid">
						   </div>
						   <div class="form-group mb-2">
						       <label for="mname">Member NAME</label>
						       <input type="text" class="form-control" id="mname" name="mname">
						   </div>
						   <div class="form-group mb-2">
						      <label for="mpassword">Member Password</label>
						      <input type="password" class="form-control" id="mpassword" name="mpassword">
						   </div>
						   <div class="form-group mb-2">
						       <label for="memail">Member EMAIL</label>
						       <input type="text" class="form-control" id="memail" name="memail">
						   </div>
							<div class="form-group">
							   <label for="mrole">Member Role</label>
							   <select class="form-control" id="mrole" name="mrole">
							      <option value="ROLE_ADMIN">Admin</option>
							      <option value="ROLE_MANAGER">Manager</option>
							      <option value="ROLE_USER" selected>User</option>
							   </select>
							</div>
						   <button type="submit" class="btn btn-info btn-sm mt-2">회원가입</button>
						</form>   
	                  </div>
	               </div>
	              
	               <!-- #################################### -->
	            </div>
	         </div>
	      </div> 
	   </div>
	</body>
</html>