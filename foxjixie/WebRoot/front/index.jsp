<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
   String path= request.getContextPath();
   String basePath=request.getScheme()+"://"
                 +request.getServerName()+":"+request.getServerPort()
                 +path;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>计协首页</title>
<link href="./CSS/main.css" rel="stylesheet" type="text/css" media="all"> 
</head>
<body>
 <%@ include file="./common_header.jsp" %>
  <!--轮播 -->
<div id="fwslider" style="height: 554px;">

			<div class="slider_container">
			<c:forEach var="ig" items="${imges }">
				<div class="slide" style=" opacity: 1; z-index: 0; display: none;">
					<img style="height:450px;width:100%;" id="img1" src="..${ig.img01}">
				</div>
				<div class="slide" style="opacity: 1; z-index: 1; display: block;">
					<img style="height:450px;width:100%;" id="img2" src="../${ig.img02 }">
				</div>
				<div class="slide" style="opacity: 1; z-index: 1; display: block;">
					<img style="height:450px;width:100%;" id="img3" src="../${ig.img03}">
				</div>
				<div class="slide" style=" opacity: 1;z-index: 0; display: none;">
					<img style="height:450px;width:100%;" id="img4" src="../${ig.img04}">
				</div>
				<div class="slide" style=" opacity: 1;z-index: 0; display: none;">
					<img style="height:450px;width:100%;" id="img5" src="../${ig.img05}">
				</div>
			</c:forEach>
			</div>
		<div class="cssmenu">
						<ul>
							<li>
								<a href="Index">首页</a>
							</li>
							<li>
								<a href="NewsTest.jsp">新闻动态</a>
							</li>
							<li>
								<a href="technology.jsp">技术研究</a>
							</li>
							<li>
								<a href="culture.jsp">社团文化</a>
							</li>
							<li>
								<a href="content.jsp">社团资源</a>
							</li>
							<li>
								您好！<%=session.getAttribute("userCount") %>
							</li>
							
							<li class="last">
								<a href="contact.jsp">关于我们</a>
							</li>
							
							
						</ul>
					</div>
   <div class="timers" style="width:180px;">
   </div>
   <div class="slidePrev" style="left:0px;top:252px;">
   </div>
  <div class="slideNext" style="right:0px;top:252px;opacity:0.5;">
   </div>
</div>
<!--轮播 -->
<!-- start main-->
		<div class="main_bg">
			<div class="business">
				技术领域 TECHNOlOGY
			</div>
			<div class="wrap w_72">
				<div class="grids_1_of_3">
					<div class="grid_1_of_3  images_1_of_3">
					<a target="_blank" href="tencent://message/?uin=1109439088&Site=qq&Menu=yes"><img src="./img/pic1-1.png" ></a>
					</div>
					
					<div class="grid_1_of_3  images_1_of_3">
					<a target="_blank" href="http://120.79.216.201/zz/WC.html"><img src="./img/pic2-1.png" ></a>	

					</div>
					<div class="grid_1_of_3  images_1_of_3">
						<a target="_blank" href="http://120.79.216.201/zz/OC.html"><img src="./img/pic3-1.png" ></a>

					</div>
					<div class="grid_1_of_3  images_1_of_3">
						<a target="_blank" href="http://120.79.216.201/zz/CM.html"><img src="./img/pic4-1.png" ></a>

					</div>
					<div class="grid_1_of_3  images_1_of_3"  style="background: none">
						<a target="_blank" href="http://120.79.216.201/zz//TT.html"><img src="./img/pic5-1.png" ></a>

					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
<!-- start  main-->
   <%@ include file="common_footer.jsp" %>

</body>
<script src="./js/jquery.min.js">
</script>
<script src="./js/jquery-ui.min.js">
</script>
<script src="./js/fwslider.js">
</script>
</html>