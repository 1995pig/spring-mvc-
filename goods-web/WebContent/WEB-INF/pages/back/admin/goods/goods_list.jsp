<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<%
	String basePath = request.getScheme() + "://" + 
		request.getServerName() + ":" + request.getServerPort() + 
		request.getContextPath() + "/" ;
%>
<%!
	public static final String GOODS_ADD_URL = "pages/back/admin/goods/goods_add.jsp" ;
	public static final String GOODS_DELETE_URL = "pages/back/admin/goods/delete.action" ;
	public static final String GOODS_EDIT_URL = "pages/back/admin/goods/editpre.action";
%>
<base href="<%=basePath%>"/>
<title>商品管理</title>


<meta name="viewport" content="width=device-width,initial-scale=1">
<script type="text/javascript" src="jquery/jquery.min.js"></script>
<script type="text/javascript" src="jquery/jquery.validate.min.js"></script>
<script type="text/javascript" src="jquery/additional-methods.min.js"></script>
<script type="text/javascript" src="jquery/Message_zh_CN.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/common/mldn_util.js"></script>
<script type="text/javascript" src="js/back/admin/goods/goods_list.js"></script>


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
			<jsp:include page="/WEB-INF/pages/plugins/split_plugin_search_bar.jsp"/>
		</div>
		<div class="row">
			<table class="table table-striped table-bordered table-hover">
				<tr>
					<td style="width:5%"><input type="checkbox" id="selectall"/></td>
					<td>商品名称</td>
					<td>商品单价</td>
 					<td>商品分类</td>
					<td>操作</td>
				</tr> 
				<c:forEach items="${allGoods }"  var="goods">
					<tr id="goods-${goods.gid }">
					<td><input type="checkbox" id="gid" name="gid" value="${goods.gid }"/></td>
					<td>${goods.title }</td>
					<td>${goods.price }</td>
					<td>${allItems[goods.iid]}</td>
 					<td><a href="<%=GOODS_EDIT_URL%>?gid=${goods.gid}" class="btn btn-warning btn-xs">
						<span class="glyphicon glyphicon-pencil"></span>&nbsp;编辑</a></td>
						
				</tr>
				</c:forEach>
			</table>
			 
  				<jsp:include page="/WEB-INF/pages/plugins/split_plugin_page_bar.jsp"/>
			 
			<button id="deleteBtn" class="btn btn-danger btn-lg">
				<span class="glyphicon glyphicon-trash"></span>&nbsp;删除选中部信息
			</button>
			<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
		</div>
	</div>
</body>
</html>