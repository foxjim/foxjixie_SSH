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
   <div class="page-container">
   <!--/content-inner-->
<div class="left-content">
	   <div class="mother-grid-inner">
               <!--header start here-->
				<%@ include file="./head_common.jsp" %>
<!--heder end here-->
<ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="queryAllUser">计协会员管理</a><i class="fa fa-angle-right"></i>编辑计协会员</li>
            </ol>
<!--grid-->
 	<div class="validation-system">
 		
 		<div class="validation-form">
 
 		<span style="color:red;">${loginError }</span>
  	   
        <form action="editUser" method="post">
        	
        	<input type="hidden" name="temp" value="1">
        	<input type="hidden" name="userid" value="${user.userid }">
        	<input type="hidden" name="userPassword" value="${user.userPassword }">
        	
             
            <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">学号</label>
              <input type="text" placeholder="学号" required="required" name="userNo" value="${user.userNo }">
            </div>
             <div class="clearfix"> </div>
             
             <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">用户名</label>
              <input type="text" placeholder="用户名" required="required" value="${user.userCount}" name="userCount" >
            </div>
             <div class="clearfix"> </div>
             
             <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">姓名</label>
              <input type="text" placeholder="姓名" required="required" value="${user.userName}" name="userName" >
            </div>
             <div class="clearfix"> </div>
             
             <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">院系</label>
              <input type="text" placeholder="院系" required="required" value="${user.userCollege}" name="userCollege" >
            </div>
             <div class="clearfix"> </div>
             
             
             
             <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">电话号码</label>
              <input type="text" placeholder="电话号码" required="required" value="${user.telPhone}" name="telPhone" >
            </div>
             <div class="clearfix"> </div>
             
              <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">邮箱</label>
              <input type="text" placeholder="邮箱" required="required" value="${user.email}" name="email" >
            </div>
             <div class="clearfix"> </div>
             

	
            <div class="col-md-12 form-group">
              <button type="submit" class="btn btn-primary">提交</button>
              <button type="reset" class="btn btn-default">重置</button>
            </div>
         	 <div class="clearfix"> </div>
          
        </form>
    	
 	
 </div>

</div>
 	<!--//grid-->

<!-- script-for sticky-nav -->
		<script>
		$(document).ready(function() {
			 var navoffeset=$(".header-main").offset().top;
			 $(window).scroll(function(){
				var scrollpos=$(window).scrollTop(); 
				if(scrollpos >=navoffeset){
					$(".header-main").addClass("fixed");
				}else{
					$(".header-main").removeClass("fixed");
				}
			 });
			 
		});
		</script>
		<!-- /script-for sticky-nav -->
<!--inner block start here-->
<div class="inner-block">

</div>
<!--inner block end here-->
<!--copy rights start here-->
<%@ include file="./footer_common.jsp" %>	
<!--COPY rights end here-->
</div>
</div>
  <!--//content-inner-->
			<!--/sidebar-menu-->
				<%@ include file="./left.jsp" %>
							  <div class="clearfix"></div>		
							</div>
							<script>
							var toggle = true;
										
							$(".sidebar-icon").click(function() {                
							  if (toggle)
							  {
								$(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
								$("#menu span").css({"position":"absolute"});
							  }
							  else
							  {
								$(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
								setTimeout(function() {
								  $("#menu span").css({"position":"relative"});
								}, 400);
							  }
											
											toggle = !toggle;
										});
							</script>
<!--js -->
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.min.js"></script>
   <!-- /Bootstrap Core JavaScript -->	   

</body>
</html>
