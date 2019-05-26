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
		<title>计算机协会</title>
		<link href="CSS/main.css" rel="stylesheet" type="text/css">
		<script src="js/jquery.min.js">
</script>
		<script src="js/tab.js">
</script>
	</head>

	<body>

		<%@ include file="common_header.jsp"%>
		<div class="container">
				<div class="left">
				<div class="menu">
					<div class="menu_title">
						计协介绍
						<br>
						<span>Society profiles</span>
					</div>
					<ul id="tab">
						<li class="active" onclick="changeValue(this)">
							<a href="javascript:void(0)">社团简介</a>
						</li>
						<li onclick="changeValue(this)">
							<a href="javascript:void(0)">成员介绍</a>
						</li>
						<li onclick="changeValue(this)">
							<a href="javascript:void(0)">联系我们</a>
						</li>
					</ul>
				</div>
			</div>
			    <div class="right">
				<div style="font-size: 14px; margin-top: 53px; line-height: 36px;">
					<div id="tab_con">
					<div id="tab_con_1" class="active">
					<div class="location">
					<span>当前位置：<a href="#">社团简介</a>
					</span>
					<div class="brief width_170">
						发展历史
					</div>
				</div>
					<c:forEach var="dhs" items="${devhistorys }">
					<br>
					<p>
					
						${dhs.dhTime}&nbsp;${dhs.dhContent}。
						
					</p>
					</c:forEach>
					<br>
					
					
					
					<!--重要资讯-->
		
				<div class="location">
					<span>当前位置：<a href="#">社团简介</a>
					</span>
					<div class="brief width_170">
						社团宗旨
					</div>
				</div>
				<div class="content_main">
					<br><br>
					<div style="padding-left:3%;">
					<h2 style="font-size:20px;color:blue;">1.1 湖南理工学院计算机协会简介</h2>
					<p style="text-indent:20px;">计算机协会是于1997年11月经校团委、教务处、计算机学院批准成立的全校性学生团体。一路走来已历时十几年风风雨雨，是一个真正面向全湖南理工学院的每一位学生的学术性协会，并以一种健康向上的姿态继续壮大着。
					</p>
					<br>
				
					<h2 style="font-size:20px;color:blue;">1.2 团队宗旨</h2>
					<p style="text-indent:20px;">“学以致用，共同发展”，立足于会员，面向全湖南理工学院，拓展会员计算机知识，丰富会员课外活动，让会员朝着“更快，更高，更好”的方向前进。

					</p>
					<br>
					
					<h2 style="font-size:20px;color:blue;">1.3 总则</h2>
					<p style="text-indent:20px;">第一条 本章程以《高等学校行为准则》、《国家教育委员会普通高等学校学生管理规定》及《湖南理工学院学生手册》、《湖南理工学院学生团体联合会章程》为基础。</p>
					<p style="text-indent:20px;">第二条 本学生团体全称为湖南理工学院计算机协会(简称计协)，是湖南理工学院学生团体联合会直接领导下的群众性课余学术组织。</p>
					<p style="text-indent:20px;">第三条 本协会的宗旨</p>
					    <p style="text-indent:20px;font-size:13px;">(一)在坚持四项基本原则的前提下，丰富大学生活，扩大学生视野，增长学生知识。协会本着"学以致用，共同发展"的宗旨，对会员负责为会员服务的十字方针开展活动</p>
						<p style="text-indent:20px;font-size:13px;">(二)对外宣传湖南理工学院，绝对服从校团委的领导。</p>
					<p style="text-indent:20px;">第四条 本协会一切活动必须遵守中华人民共和国法律法规和学校规章制度。</p><br>
					<p style="text-indent:20px;">第五条 凡爱好计算机，并承认本协会章程的师生，由本人提出申请，并填写个人简历，经协会审定，办理入会登记、注册手续后，成为本协会成员，协会给成员颁发会员证，作为会员资格的凭证。</p>
					<p style="text-indent:20px;">第六条 会员的基本权利</p>
						<p style="text-indent:20px;font-size:13px;">(一)有参与本协会各项活动的权利；</p>
						<p style="text-indent:20px;font-size:13px;">(二)对计协的工作有建议和批评的权利；</p>
						<p style="text-indent:20px;font-size:13px;">(三)有选举和被选举的权利；</p>
						<p style="text-indent:20px;font-size:13px;">(四)对协会的活动有咨询权；</p>
						<p style="text-indent:20px;font-size:13px;">(五)对协会的经费有查询权；</p>
						<p style="text-indent:20px;font-size:13px;">(六)有退出本协会的自由。</p>
					<p style="text-indent:20px;">第七条 会员的基本义务</p>
						<p style="text-indent:20px;font-size:13px;">(一)遵守本协会章程，执行本协会决议；</p>
						<p style="text-indent:20px;font-size:13px;">(二)认真完成协会交给的各项任务；</p>
						<p style="text-indent:20px;font-size:13px;">(三)按规定缴纳会费。团体实行年度收费，一年后继续留在该学生团体者，必须重新缴纳会费，所缴会费按校团委、湖南理工学院学生团体联合会的有关标准确定；</p>
						<p style="text-indent:20px;font-size:13px;">(四)维护本协会的利益和荣誉，不以本协会的名义从事违背协会性质，宗旨的活动；</p>
						<p style="text-indent:20px;font-size:13px;">(五)为协会提供各种资料及发展新会员。</p><br>
					<p style="text-indent:20px;">第八条 本协会以实事求是为工作的基本理论依据，以民主集中制为基本组织原则，实行会员个人服从组织，下级服从上级。</p>
					<p style="text-indent:20px;">第九条 本协会的最高权力机关是全体协会干部，干部全体会议一般每周举行一次，若进行活动的决策或决议则要求有三分之一的干部通过方才有效。</p>	
					<p style="text-indent:20px;">第十条 团体干部的职权</p>
						<p style="text-indent:20px;font-size:13px;">(一)修改本协会章程；</p>
						<p style="text-indent:20px;font-size:13px;">(二)审查、批准各种工作；</p>
						<p style="text-indent:20px;font-size:13px;">(三)讨论和决议协会的工作方针和任务；</p>
						<p style="text-indent:20px;font-size:13px;">(四)干部的决议。</p>
					<p style="text-indent:20px;">第十一条 设会长、副会长、团支书、会长助理，下设软件部、网络部、外联部、办公室、组织部、宣传部、文娱部共七个部门，部长一名副部三名以内，干事若干，其中团支书、会长、副会长、会长助理组成理事会，以团支书为首设团支部，以会长为首设主席团共同管理协会各种日常活动。</p>
					<p style="text-indent:20px;">第十二条 实行会长负责制，副会长及其他各部门协助会长工作。</p>
					<p style="text-indent:20px;">第十三条 会长的职权及职能</p>
						<p style="text-indent:20px;font-size:13px;">(一)作为本协会的全权代表，对与本协会有关的一切活动负主要责任；</p>
						<p style="text-indent:20px;font-size:13px;">(二)各部门认识安排，有权罢免不负责任的各级干部；</p>
						<p style="text-indent:20px;font-size:13px;">(三)各部门的工作安排及总结，并对各部门的工作进行评审；</p>
						<p style="text-indent:20px;font-size:13px;">(四)制定协会工作计划，并对任期工作认真总结；</p>
						<p style="text-indent:20px;font-size:13px;">(五)积极传达学生团体联合会及校团委的有关精神文件和指示，对会员的建议进行搜集、处理和反馈；</p>
						<p style="text-indent:20px;font-size:13px;">(六)审批经费并要求账务公开；</p>
						<p style="text-indent:20px;font-size:13px;">(七)考察会议及活动出勤情况及干部的工作手记；</p>
						<p style="text-indent:20px;font-size:13px;">(八)对外代表本协会参加各种会议及公关事宜；</p>
						<p style="text-indent:20px;font-size:13px;">(九)会员大会的发起者和主持人；</p>
						<p style="text-indent:20px;font-size:13px;">(十)负责带领全体人员，统筹规划本社团工作，具体领导实施较大规模的活动，向本团体成员传达上级管理部门的指示；</p>
						<p style="text-indent:20px;font-size:13px;">(十一)每月必须向指导老师汇报月工作情况，配合学校，学团联做好工作并协调社团各部门各干事之间的关系。</p>
					    <br>
					<p style="text-indent:20px;">第十四条 本协会的经费来源：</p>
						<p style="text-indent:20px;font-size:13px;">(一)按校团委、湖南理工学院学生团体联合会确定的标准，向会员收取会费；</p>
						<p style="text-indent:20px;font-size:13px;">(二)争取挂靠单位(即计算机学院)、学生团体联合会、校团委经费支持；</p>
						<p style="text-indent:20px;font-size:13px;">(三)在得到校团委、学生团体联合会批准后，以正当方式获取社会赞助；</p>
						<p style="text-indent:20px;font-size:13px;">(四)组织勤工俭学收入，如举办培训班；</p>
						<p style="text-indent:20px;font-size:13px;">(五)继承上一届遗留的经费。</p>
					<p style="text-indent:20px;">第十五条 本协会经费用途：</p>
						<p style="text-indent:20px;font-size:13px;">(一)日常工作；</p>
						<p style="text-indent:20px;font-size:13px;">(二)组织会员的各种活动及培训；</p>
						<p style="text-indent:20px;font-size:13px;">(三)其他经费支出。</p>
						<br>
					<p style="text-indent:20px;">第十六条 本章程的修改须经三分之二以上干部通过。</p>
					<p style="text-indent:20px;">第十七条 本章程的最终解释权归计算机协会。</p>
					<p style="text-indent:20px;">第十八条 本章程适用于所有协会会员。</p>
					<br>
					</div>
				</div>
		
		<!--//重要资讯-->

				</div>
	   				
	   				<div id="tab_con_2" class="dis-n" >

					
		
		<!--社团成员介绍-->
		<c:forEach var="snt" items="${societyNumberTerm}">
				<div class="location">
					<span>当前位置：
					<a href="#">成员介绍</a>
					</span>
					<div style="font-size:18px;" class="brief" id="b">
						<a href="#">${snt.societyTerm}届计协干部</a>
					</div>
				</div>
				<div style="font-size: 14px; margin-top: 53px; line-height: 36px;">
												
						<div id="tab_con_4" class="dis-n" style="display: block;">
							<table class="contact">
								<tbody>
									<c:forEach var="snl" items="${snt.snlist}">
									<tr>
										<td width="18%" class="ct_bg">
											${snl.department}
										</td>
										<td>
											${snl.oldMember}&nbsp;${snl.youngerMember}
										</td>
									</tr>
								
									
									</c:forEach>
								</tbody>
							</table>
						</div>
					
				</div>
			</c:forEach>
		<!--//社团成员介绍-->

		           </div>
				
		
		

					<div id="tab_con_3" class="dis-n" >
						<div class="location">
							<span>当前位置：
								<a href="#">联系我们</a>
							</span>
							<div class="brief" id="b">
								<a href="#">联系方式</a>
							</div>
						</div>
						
						<div style="font-size: 14px; margin-top: 53px; line-height: 36px;">
												
							<div id="tab_con_4" class="dis-n" style="display: block;">
								<table class="contact">
									<tbody>
									<c:forEach var="cif" items="${contactInformations}">
										<tr>
											<td width="18%" class="ct_bg">
												${cif.ciName}
											</td>
											<td>
												${cif.ciContant}
											</td>
										</tr>
									</c:forEach>	
									
								</tbody>
							</table>
						</div>
					</div>

		
 					</div>
					</div>
		
		 
				
		</div>
		</div>
		</div>
	

		
		
		<%@ include file="common_footer.jsp"%>
	</body>

	<!--//底部-->
	<script>
        tabs("#tab", "active", "#tab_con");
   </script>


</html>
