<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="">蛋糕店后台</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li ><a href="${pageContext.request.contextPath}/admin/order_list">订单管理</a></li>
                <li ><a href="${pageContext.request.contextPath}/admin/user_list">客户管理</a></li>
                <li ><a href="${pageContext.request.contextPath}/admin/goods_list">商品管理</a></li>
                <li ><a href="${pageContext.request.contextPath}/admin/type_list">类目管理</a></li>
                <li ><a href="adminRe.action">修改密码</a></li>
                <li><a href="logout.action">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
