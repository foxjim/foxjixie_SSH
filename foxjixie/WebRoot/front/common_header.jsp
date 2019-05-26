<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!--头部-->
		<div class="header_bg">
			<div class="wrap">
				<div class="header">
					<div class="logo">
						<a href="queryPictures"><img src="./img/logojx.png" alt=""> </a>
					</div>
					<div style="float:right">
								<%
									String userCount=(String)session.getAttribute("userCount");
								
									if(userCount==null){
								%>
									<a>您好，先</a><a href="../login.jsp">注册登录</a>
								<%
									}else{
								%>
								<a>您好！<%=userCount%></a>
								
								<%
									}
								%>
					</div>
					<div class="pull-icon">
						<a id="pull"></a>
					</div>
					<div class="cssmenu">
						<input type="checkbox" id="nav-toggle" class="nav-toggle"/>
            <label for="nav-toggle">
                <span class="menu-icon">
                    <svg viewBox="0 0 18 15" width="18px" height="15px">
                        <path fill="white" d="M18,1.484c0,0.82-0.665,1.484-1.484,1.484H1.484C0.665,2.969,0,2.304,0,1.484l0,0C0,0.665,0.665,0,1.484,0 h15.031C17.335,0,18,0.665,18,1.484L18,1.484z"/>
                        <path fill="white" d="M18,7.516C18,8.335,17.335,9,16.516,9H1.484C0.665,9,0,8.335,0,7.516l0,0c0-0.82,0.665-1.484,1.484-1.484 h15.031C17.335,6.031,18,6.696,18,7.516L18,7.516z"/>
                        <path fill="white" d="M18,13.516C18,14.335,17.335,15,16.516,15H1.484C0.665,15,0,14.335,0,13.516l0,0 c0-0.82,0.665-1.484,1.484-1.484h15.031C17.335,12.031,18,12.696,18,13.516L18,13.516z"/>
                   </svg>
              </span>
            </label>
            			
						<ul style="z-index:10;" class="nav-list">
							<li>
								<a href="Index">首页</a>
							</li>
							<li>
								<a href="News">新闻动态</a>
							</li>
							<li>
								<a href="technology.jsp">技术研究</a>
							</li>
							<li>
								<a href="culture">社团文化</a>
							</li>
							<li>
								<a href="SocietyContent">社团资源</a>
							</li>
							<li class="last">
								<a href="contact">关于我们</a>
							</li>
						</ul>
					</div>
					<!--清除浮动-->
					<div class="clear"></div>
					<script language="javascript">

					</script>
				</div>
			</div>
		</div>
<!--头部-->
