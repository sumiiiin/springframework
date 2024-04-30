<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
      <!-- Bootstrap 5를 위한 외부 라이브러리 설정 -->
      <!-- Latest compiled and minified CSS -->
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
      <!-- Latest compiled JavaScript -->
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
      
      <!-- jQuery -->
      <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
      
      <!-- 사용자 정의 자바스크립트 -->
		<script>
			function updateCartItem(pno){
				var amount = $("#amount"+pno).val(); //제이쿼리
				$.ajax({
					url: "updateCartItem", // 요청경로(컨트롤러에 json리턴하는 메소드 있는데 그거 요청하는 거다.)
					method: "post",
					data: {pno:pno, amount:amount},
					success: function(data){ 
						// 요청이 성공적으로 완료되면 서버로부터 받은 데이터는 이 함수의 매개변수인 data에 저장
						console.log(data);
					}
				});
			}
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
                  <div class="card-header">장바구니 보기</div>
                  <div class="card-body">
                     <table class="table table-striped border">
                         <thead class="table-info">
                           <tr class="table-warning">
                             <th>번호</th>
                             <th>상품명</th>
                             <th>가격</th>
                             <th>수량</th>
                             <th>수정 및 제거</th>
                           </tr>
                         </thead>
                         <tbody>
                            <c:forEach var="cartItem" items="${cart}">
                              <tr>
                                 <!-- product에 연결하여 얻어냄 -->
                                 <!-- cartItem은 dto의 카트아이템 -->
                                <td>${cartItem.product.pno}</td>
                                <td>${cartItem.product.pname}</td>
                                <td>${cartItem.product.pprice}</td>
                                <td><input type="number" id="amount${cartItem.product.pno}" value="${cartItem.amount}" style="width:50px"/></td>
                                <!-- 아이디값을 고유값이어야 하기 때문에 이렇게 만든다. -->
                                <td>
                                   <button onclick="updateCartItem(${cartItem.product.pno})" class="btn btn-info btn-sm">수정</button>
                                   <a href="removeCartItem?pno=${cartItem.product.pno}" class="btn btn-danger btn-sm">삭제</a>
                              </td>
                              </tr>                            
                            </c:forEach>
                         </tbody>
                       </table>
                  </div>
               </div>
               <!-- #################################### -->
            </div>
         </div>
      </div> 
   </div>
</body>
</html>