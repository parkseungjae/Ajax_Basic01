<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function ajaxTest(){
		$.ajax({
			url : "ajax_result", //"ajax",
			type : "GET",
			success : function(data){ 
				$("#count").text(data)
				console.log("성공") 
			},
			error : function(){ alert('통신 실패') }
		})
	}
</script>
</head>
<body>ajax.jsp<br>
	<h1>일</h1> <h1>일</h1> <h1>일</h1> <h1>일</h1>
	<h1>일</h1> <h1>일</h1> <h1>일</h1> <h1>일</h1>
	<button type="button" onclick="ajaxTest()">클릭</button>
	<label id="count">0</label>
</body>
</html>



