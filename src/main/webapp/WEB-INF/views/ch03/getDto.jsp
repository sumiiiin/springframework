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
							<div class="card-header">getDto</div>
							<div class="card-body">
								<P>Param1: ${dto.param1}</P> <!-- 컨트롤러에 modleAttribute("dto")설정 했더니 dto로 해도 된 -->
								<P>Param2: ${dto.param2}</P>
								<P>Param3: ${ch03Dto.param3}</P> <!-- dto 설정하니 이건 안나오는데? -->
								<P>Param4: ${ch03Dto.param4}</P> <!-- getter 호출, 클래스의 첫글자를 소문자로하고 호출 -->
								<P>Param5: ${ch03Dto.param5}</P>
								
							</div>
							
						</div>
						<!-- ########################################## -->
					</div>
				</div>
			</div>
		</div>
	</body>
</html>