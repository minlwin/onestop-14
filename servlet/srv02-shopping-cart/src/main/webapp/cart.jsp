<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:template title="My Cart">
	
	<h5><i class="bi-cart"></i> My Cart</h5>
	
	<table class="table table-striped table-bordered mt-3">
		<thead>
			<tr>
				<th>No.</th>
				<th>Name</th>
				<th class="text-end">Price</th>
				<th class="text-center">Qty</th>
				<th class="text-end">Total</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="item" varStatus="sts" items="${cart.items}">
			<tr>
				<td>${sts.index + 1}</td>
				<td>${item.name}</td>
				<td class="text-end">
					<fmt:formatNumber value="${item.price}" /> MMK 
				</td>
				<td class="text-center">
					<div class="d-flex justify-content-around">
						<c:url var="remove" value="/cart/remove">
							<c:param name="productId" value="${item.productId}" />
						</c:url>
						<a href="${remove}" class="icon-link">
							<i class="bi-dash-lg"></i>
						</a>
						<span>${item.quantity}</span>
						<c:url var="add" value="/cart/add">
							<c:param name="productId" value="${item.productId}" />
						</c:url>
						<a href="${add}" class="icon-link">
							<i class="bi-plus-lg"></i>
						</a>
					</div>
				</td>
				<td class="text-end">
					<fmt:formatNumber value="${item.total}" /> MMK 
				</td>
			</tr>
			</c:forEach>
			
			<tr>
				<td colspan="3" class="text-end">Total</td>
				<td class="text-center">${cart.totalItems}</td>
				<td class="text-end">
					<fmt:formatNumber value="${cart.totalAmount}" /> MMK 
				</td>
			</tr>
		</tbody>
	</table>
	
	<div class="text-end">
		<c:url value="/cart/clear" var="clear" />
		<a href="${clear}" class="btn btn-outline-primary">
			<i class="bi-trash"></i> Clear
		</a>
		
		<button class="btn btn-primary">
			<i class="bi-check"></i> Check Out
		</button>
	</div>

</app:template>