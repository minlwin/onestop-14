<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<%@ attribute name="title" type="java.lang.String" required="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Shop | ${title}</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">

</head>
<body>

	<nav class="navbar navbar-expand bg-primary navbar-dark">
		<div class="container">
			<c:url var="homeUrl" value="/" />
			<a href="${homeUrl}" class="navbar-brand">
				<i class="bi-shop"></i> My Shop
			</a>
			
			
			<div class="d-flex">
			
				<c:if test="${cart ne null and cart.totalItems gt 0}">
					<ul class="navbar-nav me-4">
						<li class="nav-item">
							<c:url value="/cart" var="cartUrl" />
							<a href="${cartUrl}" class="nav-link">
								<i class="bi-cart"></i>
								<span>${cart.totalItems}</span>
							</a>
						</li>
					</ul>
				</c:if>
				
				<c:url var="productUrl" value="/products" />
				<form action="${productUrl}">
					<div class="input-group">
						<input name="keyword" type="text" placeholder="Search Keyword" class="form-control" value="${param.keyword}" />
						<button class="input-group-text">
							<i class="bi-search"></i>
						</button>
					</div>
				</form>
			</div>
		</div>
	</nav>

	<main class="container mt-4">
		<jsp:doBody></jsp:doBody>
	</main>
</body>
</html>