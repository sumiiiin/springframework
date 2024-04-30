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
                  <div class="card-header">파일 다운로드</div>
                  <div class="card-body">
					<ul>
						<c:forEach var="fileName" items="${fileNames}"><!-- 상품의 이미지는 원래 데이터베이스에서 가져와야 한다. -->
							<li class="mb-2">
								<a href="downloadFile?fileName=${fileName}">${fileName}</a><!-- 링크로 들어가면 다운 -->
								<img src="downloadFile?fileName=${fileName}" width="50" height="50"/><!-- src로 들어가면 보여주기 -->
							</li><!-- get방식 -->
						</c:forEach>
						
					</ul>
                  </div>
               </div>
               <!-- #################################### -->
            </div>
         </div>
      </div> 
   </div>

   
</body>
</html>