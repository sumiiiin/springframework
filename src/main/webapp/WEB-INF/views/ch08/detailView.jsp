<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><!-- 날짜 형식 태그 사용 -->
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
		
		<script>
			function addCartItem(){
				var pno = ${product.pno}; // EL은 서버에서 값 준거 사용, 자바스크립트는 클라이언트 쪽...?
				var amount = $("#amount").val();// 이건 클라이언트에서 실행하는 제이쿼리, 위 코드와 실행위치가 완전 다름
				document.location.href= "addCartItem?pno=" + pno + "&amount=" + amount; // get방식 
			}
		</script>
		
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
							<div class="card-header">상품 상세</div>
							<div class="card-body">
								 <p>상품 번호: ${product.pno}</p>
			                     <p>상품 이름: ${product.pname}</p>
			                     <p>상품 가격: ${product.pprice}</p>

								<hr/>
								<div>
									수량:<input type="number" id="amount" value="1"/>
								</div>
								<button onclick="addCartItem()" class="mt-3 btn btn-info btn-sm">장바구니 넣기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
