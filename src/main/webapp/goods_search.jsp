<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
	<title>首页</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/simpleCart.min.js"></script>
	<script type="text/javascript" src="layer/layer.js"></script>
	<script type="text/javascript" src="js/cart.js"></script>
</head>
<body>
	<!--header-->
	<jsp:include page="header.jsp">
		<jsp:param name="flag" value="2"/>
	</jsp:include>
	<!--products-->
	<div class="products">
		<div class="container">
			<h2>搜索’${param.keyword}‘</h2>
			<div class="col-md-12 product-model-sec">
				<c:forEach items="${page.list }" var="g">
					<div class="product-grid">
						<a href="${pageContext.request.contextPath}/goods_detail?typeid=${g.id}">
							<div class="more-product"><span> </span></div>
							<div class="product-img b-link-stripe b-animate-go  thickbox">
								<img src="${pageContext.request.contextPath}${g.cover}" class="img-responsive" alt="${g.name}" width="240" height="240">
								<div class="b-wrapper">
									<h4 class="b-animate b-from-left  b-delay03">
										<button>查看详情</button>
									</h4>
								</div>
							</div>
						</a>
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust prt_name">
								<h4>${g.name}</h4>
								<span class="item_price">${g.price}</span>
								<input type="button" class="item_add items" value="加入购物车" onclick="buy(1)">
								<div class="clearfix"> </div>
							</div>
						</div>
					</div>
				</c:forEach>

				<div class="clearfix"> </div>
			</div>
			<jsp:include page="page.jsp">
				<jsp:param name="url" value="/goods_search"/>
				<jsp:param name="param" value="&keyword=${keyword}"/>
			</jsp:include>
</div>
		</div>
	</div>
	<!--//products-->
	<!--footer-->
<jsp:include page="footer.jsp"></jsp:include>
	<!--//footer-->


</body>
</html>