<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文档编辑</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="./Ueditor/editor_api.js"></script>
	<script type="text/javascript" src="./Ueditor/ueditor.config.js"></script>
	
	<script type="text/javascript" charset="utf-8" src="./Ueditor/lang/zh-cn/zh-cn.js"></script>

	<style>
		#id{
		width:1024px;height:500px;
		}
	</style>

  </head>
  
  <body>
  
  <div>
    <h1>完整demo</h1>
    	<script id="editor" type="text/plain"></script>
    	<a href="javascript:void(0)" onclick="sentShow()">提交</a>
	</div>
    
  </body>
  <script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
  </script>
</html>
