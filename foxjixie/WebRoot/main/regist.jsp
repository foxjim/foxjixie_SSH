<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>fox计协后台管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="css/morris.css" type="text/css"/>
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="css/jquery-ui.css"> 
<!-- jQuery -->
<script src="js/jquery-2.1.4.min.js"></script>
<!-- //jQuery -->
<link href='http://fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css'/>
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
</head> 
<body>
	<div class="main-wthree">
	<div class="container">
	<div class="sin-w3-agile">
		<h2>fox计协后台注册界面</h2>
		<form action="../regist" method="post" onsubmit="return regis();">
		
			<div class="username">
				<span class="username">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</span>
				<input type="text" name="adName" class="name" placeholder="" required="">
				<div class="clearfix"></div>
			</div>
			
			<div class="username">
				<span class="username">电话号码:</span>
				<input type="text" name="adPhoneNumber" class="name" placeholder="" required="">
				<div class="clearfix"></div>
			</div>
			
			<div class="username">
				<span class="username">所在部门:</span>
				<input type="text" name="adDepartment" class="name" placeholder="" required="">
				<div class="clearfix"></div>
			</div>
			
			<div class="username">
				<span class="username">所在职位:</span>
				<input type="text" name="adPosition" class="name" placeholder="" required="">
				<div class="clearfix"></div>
			</div>
			
			<div class="password-agileits">
				<span class="username">使用密码:</span>
				<input id="pwd" type="password" name="adPassword" class="password" placeholder="" required="">
				<div class="clearfix"></div>
			</div>
			
			<div class="password-agileits">
				<span class="username">确认密码:</span>
				<input id="pwd2" type="password" name="password" class="password" placeholder="" required="">
				<div class="clearfix"></div>
			</div>
			
			<div class="login-w3">
					<input type="submit" class="login" value="注   册 ">
			</div>
			
			<div class="clearfix"></div>
		</form>
		<div class="back">
						<a href="login.jsp">返回登陆</a>
				</div>
				<div class="footer">
					<p>Copyright &copy; 2018.Company name All rights .<a target="_blank" href="http://120.79.216.201">计算机协会</a></p>
				</div>
	</div>
	</div>
	</div>
</body>
<!-- 验证输入的注册信息是否合法 -->
<script>
	function regis() {
		/* ----------- 验证两次输入的密码是否一致 --------------------- */
		var pwd = document.getElementById("pwd").value;
		var pwd2 = document.getElementById("pwd2").value;
		if (pwd !== pwd2) {
			alert('密码前后不一致！');
			return false;
		}
		return true;
	}
</script>
<!-- //验证输入的信息是否合法 -->
</html>