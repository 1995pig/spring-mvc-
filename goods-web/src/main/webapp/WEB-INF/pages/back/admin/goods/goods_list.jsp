<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<%
	String basePath = request.getScheme() + "://" + 
		request.getServerName() + ":" + request.getServerPort() + 
		request.getContextPath() + "/" ;
%>
<%!
	public static final String GOODS_ADD_URL = "pages/back/admin/goods/goods_add.jsp" ;
	public static final String GOODS_DELETE_URL = "pages/back/admin/goods/goods_delete_do.jsp" ;
	public static final String GOODS_EDIT_URL = "pages/back/admin/goods/goods_edit.jsp" ;
%>
<base href="<%=basePath%>"/>
<title>商品管理</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<script type="text/javascript" src="js/common/mldn_util.js"></script>
<script type="text/javascript" src="js/back/admin/goods/goods_list.js"></script>
<script type="text/javascript" src="jquery/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	jsDeleteUrl = "<%=basePath + GOODS_DELETE_URL%>"
</script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="h1"><strong><span class="glyphicon glyphicon-th-list"></span>&nbsp;商品信息列表</strong></div>
		</div>
		<div class="row">
			<table class="table table-striped table-bordered table-hover">
				<tr>
					<td style="width:5%"><input type="checkbox" id="selectall"/></td>
					<td>商品名称</td>
					<td>商品单价</td>
					<td>上架日期</td>
					<td>商品分类</td>
					<td>操作</td>
				</tr>
				<tr>
					<td><input type="checkbox" id="gid" value="10"/></td>
					<td>Java开发实战经典</td>
					<td>79.8</td>
					<td>2019-10-10</td>
					<td>图书/音响</td>
					<td><a href="<%=GOODS_EDIT_URL%>?gid=10" class="btn btn-warning btn-xs">
						<span class="glyphicon glyphicon-pencil"></span>&nbsp;编辑</a></td>
				</tr>
			</table>
			<button id="deleteBtn" class="btn btn-danger btn-lg">
				<span class="glyphicon glyphicon-trash"></span>&nbsp;删除选中部信息
			</button>
		</div>
	</div>
</body>
</html>