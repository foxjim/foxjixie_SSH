<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>注册-计协会员</title>
<link rel="stylesheet" href="./front/CSS/mr-01.css" type="text/css">
</head>

<body style="text-align: center;background-image: url(img/login_bases10.jpg); background-repeat: no-repeat;background-size: cover;">
	<!-- 主体内容 -->
	<div id="mr-mainbody" class="container mr-mainbody">
		<div class="row">
			<div id="mr-content" class="mr-content col-xs-12">
				<div class="login-wrap" style="margin-bottom: 60px; margin-top: 50px">
					<div style="max-width: 540px; margin: 0 auto;">
						<a href="index.jsp" title="点击返回首页"><img src=""></a>
					</div>
					<div class="login" style=" background-color: rgba(236, 234, 234, 0.819);">
						<div class="page-header" style="pause: 0px;">
							<h1 class="login_h1">修改密码</h1>
						</div>
						<!-- 会员注册表单 -->
						<form id="member-registration" action="findNewPassword"
							onsubmit="return regis();" method="post" class="form-horizontal">
							<input type="hidden" name="temp" value="1"/>
							<input type="hidden" name="userCount" value="${loginError }">
							<fieldset>

								<div class="form-group">
									<div class="col-sm-4 control-label">
										<label id="password-lbl" for="password" class="required">
											密码 ：</label>
									</div>
									<div class="col-sm-8">
										<!-- 密码文本框 -->
										<input type="password" name="userPassword" id="pwd" value=""
											autocomplete="off" class="validate-password required"
											size="38" maxlength="99" required="required"
											aria-required="true"><span class="star">&nbsp;*</span>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4 control-label">
										<label id="password-lbl" for="password" class="required">
											确认密码 ：</label>
									</div>
									<div class="col-sm-8">
										<!-- 确认密码文本框 -->
										<input type="password" name="pwd2" id="pwd2" value=""
											autocomplete="off" class="validate-password required"
											size="38" maxlength="99" required="required"
											aria-required="true"><span class="star">&nbsp;*</span>
									</div>
								</div>
								<br>
								<div class="form-group">
								
									<div class="col-sm-offset-4 col-sm-8">
										<button type="submit" class="btn btn-primary login">开始重置</button>
									</div>
								</div>
			
								<div class="form-group" style="margin: 20px;">
									<label
										style="float: right; color: #858585; margin-right: 80px; margin-top: 10px; font-size: 14px;">想起密码！<a
										href="./login.jsp">去登录</a></label>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //主体内容 -->
</body>
<!-- 验证输入的注册信息是否合法 -->
<script src="./front/js2/jquery.1.3.2.js" type="text/javascript"></script>
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