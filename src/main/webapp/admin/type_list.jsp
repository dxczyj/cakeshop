<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>类目列表</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<jsp:include page="/admin/header.jsp"></jsp:include>
	
	<br>
	<c:if test="${!empty msg}"><div class="alert alert-success">${msg }</div></c:if>
	<c:if test="${!empty failMsg}"><div class="alert alert-danger">${failMsg }</div></c:if>
	<div>
		<form class="form-inline" method="post" action="${pageContext.request.contextPath}/admin/type_add">
			<input type="text" class="form-control" id="input_name" name="name" placeholder="请输入类目" required="required" style="width: 500px">
			<input type="submit" class="btn btn-warning" value="添加类目"/>
		</form>
	</div>
	
	<br>

	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ID</th>
		<th width="10%">名称</th>
		<th width="10%">操作</th>
	</tr>
	
	<c:forEach items="${list}" var="t">
		<tr>
			<td><p>${t.id}</p></td>
			<td><p>${t.name}</p></td>
			<td>
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/type_edit.jsp?id=${t.id}&name=${t.encodeName}">修改</a>
				<a class="btn btn-danger" href="${pageContext.request.contextPath}/admin/type_delete?id=${t.id}">删除</a>
			</td>
		</tr>
	</c:forEach>


</table>

</div>
</body>
</html>