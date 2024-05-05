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
	                  <div class="card-header">로그인</div>
	                       <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}"><!-- 시큐리티 에러가 있다면(로그인이 안됐다면) -->
					         <div class="alert alert-danger mb-2 mt-2" role="alert">
					            <c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message == 'Bad credentials'}">
					               	아이디 또는 비밀번호가 틀립니다.
					            </c:if>
					         </div>
					      </c:if>
	                  <div class="card-body">
					  	<form method="post" action="${pageContext.request.contextPath}/login"><!-- 절대경로 -->
					  	   
					  	   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
					  	   <!-- csrf 토큰을 사용해서  폼의 유효성 검사를 할거라면 프로젝트의 모든 form에 이 input태그를 포함해야 한다. 
					  	   		기본적으로 필요하지만 개발 할때 너무 귀찮아 개발할 때는 안한다. -->
						   
						   <div class="form-group mb-2">
						       <label for="mid">Member ID</label>
						       <input type="text" class="form-control" id="mid" name="mid">
						   </div>
						   <div class="form-group mb-2">
						      <label for="mpassword">Member Password</label>
						      <input type="password" class="form-control" id="mpassword" name="mpassword">
						   </div>
						   <button type="submit" class="btn btn-info btn-sm mt-2">로그인</button>
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