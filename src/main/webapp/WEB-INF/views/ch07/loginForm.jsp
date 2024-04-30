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
		<!-- Latest compiled and minified CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Latest compiled JavaScript -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
		
		<!-- jQuery 외부 라이브러리 설정 -->
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
	</head>
	<body>
		<div class="d-flex flex-column vh-100">
			
			<%-- include 지시자는 소스 복사 개념 --%>
			<%@ include file="/WEB-INF/views/common/header.jsp"%>
			
			<div class="flex-grow-1 m-2">
				<div class="d-flex row">
					<div class="col-md-4">
						<%-- <%@ include file="/WEB-INF/views/common/menu.jsp"%> --%>
						
						<%-- include 액션은 외부에서 실행하고 결과만 삽입 --%>
						<jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>
					</div>
					
					<div class="col-md-8">
						<div class="card">
							<div class="card-header">로그인 양식</div>
							<div class="card-body">
								<c:if test="${login=='success'}"><!-- jstl문법? 큰따옴표는 겉에서 사용하고 있어서 작은 따옴표 사용 if가 true면 c태그 안의 내용을 실행-->
								<!-- session의 이름인 login 사용 -->
									<a href="sessionLogout" class="btn btn-danger btn-sm">로그아웃</a>
								</c:if>
								<c:if test="${login!='success'}"><!-- 큰따옴표는 겉에서 사용하고 있어서 작은 따옴표 사용 if가 false면 c태그 안의 내용을 실행-->
									<form class="m-2" method="post" action="sessionLogin"><!-- 컨트롤러에 post매핑해서 post해야함 -->
								
										<div class="form-group mb-3">
											<label for="mid">아이디</label>
											<input type="text" class="form-control" id="mid" name="mid" value="${ch04LoginForm.mid}"> <!-- 컨트롤러가 넘긴 객체를 사용하겠다. -->
											
											
										</div>
										   
										<div class="form-group mb-2">
											<label for="mpassword">패스워드</label>
											<input type="password" class="form-control" id="mpassword" name="mpassword" value="${ch04LoginForm.mid}"><!-- 로그인 실패해도 틀린 값 남아있음 -->
											
										</div>
										<button type="submit" class="btn btn-info btn-sm">로그인</button>
									
									</form>
								</c:if>

							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>