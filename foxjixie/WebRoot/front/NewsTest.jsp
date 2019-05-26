<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>计协 新闻动态</title>
		<link href="CSS/main.css" rel="stylesheet" type="text/css">
		<link href="CSS/container.css" rel="stylesheet" type="text/css">
		<link href="CSS/reset.css" rel="stylesheet" type="text/css">
		<link href="CSS/screen.css" rel="stylesheet" type="text/css">
		<script src="js/jquery.min.js">
</script>
		<script src="js/tab.js">
</script>
	</head>

	<body>
		<%@ include file="common_header.jsp"%>

		<!--banner-->
		<div class="second_banner">
			<img src="img/header-news.png" alt="">
		</div>
		<!--//banner-->
		<!--新闻-->
		<div class="container">
		
	
	<div class="left">
	
        <div class="menu_plan">
            <div class="menu_title">协会动态<br><span>news of foxjixie</span></div>
			 <ul id="tab">
			 <c:forEach var="snt" items="${newsHeadLists}">
                <li ><a href="#">${snt.ntTime}年度</a></li>
                </c:forEach>
            </ul>
        </div>
     
     </div>
     <div class="right">
            <div class="location">
                <span>当前位置：<a  id="a"> 协会新闻</a></span>
                <div class="brief" id="b"><a href="News">协会新闻</a></div>
            </div>
            <div style=" font-size:14px; margin-top:53px; line-height:36px;">
               <div id="tab_con">
              		<c:forEach var="snt" items="${newsHeadLists}">
                    <div id="tab_con_2" class="dis-n" style="display: none;">
							<table style="margin-top:70px">
								<tbody>
									<tr class="tt_bg">
										
										<td>
											新闻标题
										</td>
										<td>
											发布人
										</td>
										<td>
											发布时间
										</td>
										<td>
											详情
										</td>
										
									</tr>
									 <c:forEach var="snl" items="${snt.nhlist}">
									<tr>
										
										<td>
											${snl.nhTitle}
										</td>
										<td>
											${snl.nhPerson}
										</td>
										<td>
											${snl.nhTime}
										</td>
										<td>
										<c:if test="${snl.userLink=='0'}">
											<c:if test="${empty snl.onlionLink}">
												<a>暂无详情</a>
											</c:if>
											<c:if test="${not empty snl.onlionLink}">
												<a href="${snl.onlionLink }">详情</a>
											</c:if>
										</c:if>
										
										<c:if test="${snl.userLink=='1'}">
											<c:if test="${empty snl.otherLink}">
												<a>暂无详情</a>
											</c:if>
											<c:if test="${not empty snl.otherLink}">
												<a href="${snl.userLink }">详情</a>
											</c:if>
										</c:if>
										</td>
									</tr>
									
									 </c:forEach>
									
								
									
							</tbody>
							</table>
						</div>
               			</c:forEach>
				</div>
            </div>
    </div>
</div>
		<!--//新闻-->
		<!--底部-->
		<div style="height:350px;">
		 <p></p>
		</div>
		<%@ include file="common_footer.jsp"%>
		
	</body>

	<!--//底部-->
	<script>
tabs("#tab", "active", "#tab_con");
</script>


</html>
