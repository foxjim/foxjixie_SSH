<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="header-main">
					<div style="width:100%;background-color:rgb(137, 207, 240);" class="logo-w3-agile">
								<h2><a href="index.jsp">社团网站后台管理系统<br><h4>计算机协会</h4></a></h2>
					</div>
					
<%
									String getloginmessage=(String)session.getAttribute("getloginmessage");
									if(getloginmessage==null){
										getloginmessage="0";
									}
									if(getloginmessage.equals("1")){
										
									}else{
										%>
											<script type="text/javascript">
												window.location.href="./login.jsp";
											</script>
											
										
										<%
										
									}
								%>
						
							
				     <div class="clearfix"> </div>	
