<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="sidebar-menu">
					<header class="logo1">
						<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> 
					</header>
						<div style="border-top:1px ridge rgba(255, 255, 255, 0.15)"></div>
                           <div class="menu">
									<ul id="menu" >
										<li><a href="index.jsp"><i class="fa fa-tachometer"></i> <span>主菜单</span><div class="clearfix"></div></a></li>
										
										
									 <li id="menu-academico" ><a href="#"><i class="fa fa-list-ul" aria-hidden="true"></i><span>首页</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
										   <ul id="menu-academico-sub" >
										    <li id="menu-academico-avaliacoes" ><a href="queryAllPictures">图片轮播列表</a></li>
											<li id="menu-academico-avaliacoes" ><a href="lb.jsp">添加轮播图片</a></li>
										  </ul>
										</li>
							
									  <li id="menu-academico" ><a href="#"><i class="fa fa-list-alt" aria-hidden="true"></i><span>新闻管理</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
										   <ul id="menu-academico-sub" >
										   <li id="menu-academico-avaliacoes" ><a href="queryNewsHead">新闻列表</a></li>
											<li id="menu-academico-avaliacoes" ><a href="InsertNewsHead.jsp">添加新闻</a></li>
										  </ul>
										</li>
										
										  <li id="menu-academico" ><a href="#"><i class="fa fa-wrench" aria-hidden="true"></i><span>技术研究-开发ing</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
										   <ul id="menu-academico-sub" >
										   <li id="menu-academico-avaliacoes" ><a href="">话题列表</a></li>
											<li id="menu-academico-avaliacoes" ><a href="">添加话题</a></li>
										  </ul>
										</li>
										
										
										  <li id="menu-academico" ><a href="#"><i class="fa fa-desktop" aria-hidden="true"></i><span>社团文化</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
										   <ul id="menu-academico-sub" >
										    <li id="menu-academico-avaliacoes" ><a href="queryAllSocietyCulture">活动列表</a></li>
											<li id="menu-academico-avaliacoes" ><a href="InsertSocietyCulture.jsp?term=a">添加活动</a></li>	
										  </ul>
										</li>
										
										
										  <li id="menu-academico" ><a href="#"><i class="fa  fa-archive" aria-hidden="true"></i><span>社团资源</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
										   <ul id="menu-academico-sub" >
										    <li id="menu-academico-avaliacoes" ><a href="querySocietyContent">社团资源列表</a></li>
											<li id="menu-academico-avaliacoes" ><a href="InsertSocietyContent.jsp?term=a">添加资源</a></li>
										  </ul>
										</li>
										
										 <li id="menu-academico" ><a href="#"><i class="fa fa-fa (alias)" aria-hidden="true"></i><span>关于社团</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
										   <ul id="menu-academico-sub" >
										    <li id="menu-academico-avaliacoes" ><a href="queryAllDevhistory">社团简介——发展历史列表</a></li>
										    <li id="menu-academico-avaliacoes" ><a href="InsertDevhistory.jsp">社团简介——添加发展历史</a></li>
											<li id="menu-academico-avaliacoes" ><a href="queryAllSocietyNumber">成员介绍-社团成员列表</a></li>
											<li id="menu-academico-avaliacoes" ><a href="InsertSocietyNumber.jsp?term=a">成员介绍-添加领导班子</a></li>
											<li id="menu-academico-avaliacoes" ><a href="queryAllContactInformation">联系我们列表</a></li>
											<li id="menu-academico-avaliacoes" ><a href="InsertContactInformation.jsp">添加联系方式</a></li>
										  </ul>
										
								<li id="menu-academico" ><a href="#"><i class="fa fa-universal-access"></i>  <span>会员管理</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
										 <ul id="menu-academico-sub" >
											<li id="menu-academico-boletim" ><a href="queryAllUser?currentPage=1">会员总览</a></li>
											<li id="menu-academico-avaliacoes" ><a href="InsertUser.jsp">添加会员</a></li>
										  </ul>
									 </li>
								 
									<li><a href="#"><i class="fa fa-check-square-o nav_icon"></i><span>社团</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
									  <ul>
										<li><a href="queryAdminUser">管理员信息</a></li>
									</ul>
									</li>
								
								  </ul>
								</div>
							  </div>
