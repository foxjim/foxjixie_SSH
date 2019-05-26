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
                <li class="breadcrumb-item"><a href="queryAllPictures">首页</a><i class="fa fa-angle-right"></i>插入轮播图片 </li>
            </ol>
<!-- faq -->
				
				
				<div class="agile-tables">
					
	
				<div class="w3l-table-info">
					  <div class="form-group">
					  
					   <div class="col-md-12 form-group1 group-mail">
             				<h2>请选择合适的图片进行上传<span style="font-size:15px;">(上传文件将强制转换为jpg格式文件,建议大小：1069 x 450 像素)</span></h2>
              								
            						</div>
             						<div class="clearfix"> </div>
             	
					<form action="uploadImg" method="post" enctype="multipart/form-data">
						
						<input type="file" name="imge01"><br>
						<input type="file" name="imge02"><br>
						<input type="file" name="imge03"><br>
						<input type="file" name="imge04"><br>
						<input type="file" name="imge05"><br>
						
						
						<div class="col-md-12 form-group">
              							<button type="submit" class="btn btn-primary">上传</button>
              							<button type="reset" class="btn btn-default">重置</button>
            						</div>
					</form>
				   </div>
				   </div>
				   </div>
				</div>
				<div style="clear:both;">
				
				
				
				<!-- //faq -->
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