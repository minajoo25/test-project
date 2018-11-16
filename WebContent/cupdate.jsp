<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$('#cupdatebutton').click(function(){
			var c = confirm('Are You Update ?');
			if(c == true){
				$('#cupdate').attr('action','cupdate');
				$('#cupdate').attr('method','post');
				$('#cupdate').submit();
			}
		});
	});
</script>
</head>
<body>
	<h1>Cust Update page</h1>
	<form id="cupdate">
		ID:${uc.id }<br>
		<input type="hidden" name="id" value="${uc.id }"><br>
		PWD<input type="password" name="pwd" value="${uc.pwd }"><br> 
		NAME<input type="text"name="name" value="${uc.name }"><br> 
		AGE<input type="number"name="age" value="${uc.age }"><br> 
		    <input id="cupdatebutton" type="button" value="UPDATE"><br>
	</form>
</body>
</html>