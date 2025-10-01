<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:template title="My Cart">
	
	<h5><i class="bi-cart"></i> My Cart</h5>
	
	<app:cart-items totalCount="${cart.totalItems}" items="${cart.items}" totalAmount="${cart.totalAmount}" />
	
	<c:url value="/checkout" var="checkOut"></c:url>
	<form method="post" action="${checkOut}" class="text-end">
		<c:url value="/cart/clear" var="clear" />
		<a href="${clear}" class="btn btn-outline-primary">
			<i class="bi-trash"></i> Clear
		</a>
		
		<button type="submit" class="btn btn-primary">
			<i class="bi-check"></i> Check Out
		</button>
	</form>

</app:template>