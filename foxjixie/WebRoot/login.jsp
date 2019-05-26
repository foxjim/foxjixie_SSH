<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>登录-计协会员</title>
<link rel="stylesheet" href="./front/CSS/mr-01.css" type="text/css">
</head>

<body style="text-align: center;background-image: url(./front/img/login_bases10.jpg); background-repeat: no-repeat;background-size: cover;">
	<div id="mr-mainbody" class="container mr-mainbody">
		<div class="row">
			<!-- 主体内容 -->
			<div id="mr-content" class="mr-content col-xs-12">
				<div class="login-wrap" style="margin-bottom: 60px; margin-top: 50px">
					<div style="max-width: 540px; margin: 0 auto;">
						<a href="index.jsp" title="点击返回首页"><img src=""></a>
					</div>
					<div style=" background-color: rgba(236, 234, 234, 0.819);" class="login">
						<div class="page-header" style="pause: 0px;"> <h1 class="login_h1">会员登录</h1> </div>
						<!-- 会员登录表单 -->
						<form action="loginUser" method="post" class="form-horizontal">
							<fieldset>
							&nbsp;<p style="color:red;">${loginError}</p>
								<div class="form-group">
								
									<div class="col-sm-4 control-label">
										<label id="username-lbl" for="username" class="required">账户 ：</label>
									</div>
									<div class="col-sm-8">
										<!-- 账户文本框 -->
										<input type="text" name="userCount" id="username" value="" size="38"
											class="validate-username required" required="required" autofocus="">
									</div>
								</div>
								<br>
								<div class="form-group">
									<div class="col-sm-4 control-label">
										<label id="password-lbl" for="userPassword" class="required">密码 ：</label>
									</div>
									<div class="col-sm-8">
										<!-- 密码文本框 -->
										<input type="password" name="userPassword" id="password" value=""
											class="validate-password required" size="38" maxlength="99"
											required="required" aria-required="true">
									</div>
								</div>
								<br>
								<div class="form-group">
								
									<div class="col-sm-offset-4 col-sm-8">
										<button type="submit" class="btn btn-primary login">登录</button>
									</div>
								</div>
								<div class="form-group" style="border-top: 1px solid #D9D9D9; margin: 20px;">
									
									<label
										style="clear:both; float: right; color: #858585; margin-right: 40px; margin-top: 5px; font-size: 14px;">忘记密码？
										<a href="forgetPassword.jsp">密码重置</a>
									</label>
									
									<label
										style="clear:both; float: right; color: #858585; margin-right: 40px; margin-top: 5px; font-size: 14px;">懒得注册？
										<a href="./front/Index">游客登录</a>
									</label>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
			<!-- //主体内容 -->
		</div>
	</div>
	<script language="javascript">
		//刷新验证码
		function myReload() {
			document.getElementById("img_checkCode").src = document
					.getElementById("img_checkCode").src + "?nocache=" + new Date().getTime();
		}
	</script>
</body>
</html>