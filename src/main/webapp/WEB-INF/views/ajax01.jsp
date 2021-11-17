<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function ajax(){
		var n = $("#name").val();
		var a = document.getElementById("age").value;
		var addr = $("#addr").val();
		var form = { age:a, name:n , addr:addr }
		console.log(form)
		$.ajax({
			url : "ajax_result01", type : "post",
			//data : 서버로 보낼 데이터 { age : 20, name : 홍길동}
			data : JSON.stringify(form),
			dataType : "json",// 서버로 돌려받는 값의 타입 지정
			// 서버로 보낼 데이터 설정
			contentType : "application/json; charset=utf-8",
			success : function(result){
				$("#label").text(result.name+":"+result.age)
			}, error : function(){ alert("문제 발생") }
		})
	}
</script>
</head>
<body>
	<input type="text" id="name" placeholder="이름"><br>
	<input type="text" id="age" placeholder="나이"><br>
	<input type="text" id="addr" placeholder="주소"><br>
	<input type="button" onclick="ajax()" value="저장">
	<hr> 결과 : <label id="label"></label>
</body>
</html>






