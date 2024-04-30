<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getMethodData</title>
      <!-- Bootstrap 5 외부 라이브러리 설정 -->
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>   
      
      <!-- jQuery 외부 라이브러리 설정 -->
      <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
</head>
	<body>
		<div class="d-flex flex-column vh-100">
			<%@ include file="/WEB-INF/views/common/header.jsp"%>
			<div class="flex-grow-1 m-2">
				<div class="d-flex row">
					<div class="col-md-4">
						<%@ include file="/WEB-INF/views/common/menu.jsp"%>
					</div>
					
					<div class="col-md-8">
						<!-- ############################################ -->
						<div class="card">
							<div class="card-header">getMethodData</div>
							<div class="card-body">
								<P>Param1: ${param1}</P>
								<P>Param2: ${param2}</P>
								<P>Param3: ${param3}</P>
								<P>Param4: ${param4}</P>
								<P>Param5: ${param5}</P>
								<P>Param6: ${param6}</P> <!-- 값이 없을 경우 브라우저에 아무것도뜨지 않는다. -->
							</div>
							
						</div>
						<!-- ########################################## -->
					</div>
				</div>
			</div>
		</div>
	</body>
</html>