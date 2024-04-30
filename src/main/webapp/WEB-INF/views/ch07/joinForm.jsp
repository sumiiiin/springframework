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
							<div class="card-header">wrteBoardForm</div>
							<div class="card-body">
								<form id="joinForm" method="post" action="request2">
								   <div class="input-group">
								      <div class="input-group-prepend"><span class="input-group-text">mid</span></div>
								      <input id="mid" type="text" name="mid" class="form-control" value="${joinForm.mid}">
								   </div>
								   
								   <div class="input-group">
								      <div class="input-group-prepend"><span class="input-group-text">mname</span></div>
								      <input id="mname" name="mname" class="form-control"value="${joinForm.mname}">
								   </div>
								   
								   <div class="input-group">
								      <div class="input-group-prepend"><span class="input-group-text">mpassword</span></div>
								      <input id="mpassword" type="password" name="mpassword" class="form-control" value="${joinForm.mpassword}">
								   </div>
								   
								   <div class="input-group">
								      <div class="input-group-prepend"><span class="input-group-text">mjob</span></div>
								      <select id="mjob" name="mjob" class="form-control">
								      <c:forEach var="job" items="${jobList}"><!-- c:forEach는 for문이고 items에서 하나씩 담는 var는 변수명이다. -->
								      	<option value="${job}" ${job==joinForm.mjob?'selected':''}>${job}</option>
								      	<!-- 원래 옵션에 selected를 넣으면 기본값으로 선택이 되는데 객체를 사용해서 쓸 수 있다. -->
								      	<!-- (삼항연산자)job이랑  defaultJob랑 같으면 selected를 반환하고 아니면 빈값을 반환해라-->
								      	<!-- 근데 이정도는 그냥 속성에 리터럴로 작성하는게 더 낫지 않나... -->
								      </c:forEach>
								      	
								  
								      </select>
								   </div>
								   
								   <div class="input-group">
								      <div class="input-group-prepend"><span class="input-group-text">mcity</span></div>
								      <select id="mcity" name="mcity" class="form-control">
								      	<c:forEach var="city" items="${cityList}"><!-- c:forEach는 for문이고 items에서 하나씩 담는 var는 변수명이다.(향상된 for문 생각하면 될듯) -->
								      		<option value="${city}" ${city==joinForm.mcity?'selected':''}>${city}</option>
								      	</c:forEach>
								      </select>
								   </div>

								      
								   <div class="mt-3">
								      <button class="btn btn-info btn-sm mr-2">가입</button>
								   </div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>