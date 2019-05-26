<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>计协 社团文化</title>
<link href="CSS/main.css" style="text/css" rel="stylesheet" >
</head>
<body>
<%@ include file="common_header.jsp" %>
	  <div class="bodyer">
        <div class="videoer">
            <br><br>
           <p style="text-align: center;">
               <iframe src="img/计协明星社团评选材料_1.mp4" frameborder="0" style="height:600px;width:1100px"></iframe><br><br><br>
		<a target="_blank" href="https://v.youku.com/v_show/id_XMzYzNzUyODA4MA==.html?spm=a2hzp.8244740.0.0">播放卡顿请跳转至优酷播放 >></a><br>
            </p> 
	    
        </div>

		<c:forEach var="snt" items="${scllist}">
        <!--活动-->
		<div class="container">
			<div>
				<div class="location1">
					<span>当前位置：<a
						href="#">活动列表</a>
					</span>
					<div class="brief width_170">
						${snt.cultureClass}活动
					</div>
				</div>
				<div class="content_main">
					<c:forEach var="snl" items="${snt.cultureClassList}">
					<p>
						${snl.cultureTime}&nbsp; ${snl.cultureContent}
						<c:if test="${not empty snl.cultureLink}">
						 <a target="_blank" href="${snl.cultureLink}">[详情]</a>
						</c:if>
						<c:if test="${empty snl.cultureLink}">
						 <a>[暂无详情]</a>
						</c:if>
						
					</p>
					<br>
					
					</c:forEach>

				</div>
			</div>
		</div>
		<!--//活动-->
		</c:forEach>
		</div>
		
<%@ include file="common_footer.jsp" %>
</body>
</html>