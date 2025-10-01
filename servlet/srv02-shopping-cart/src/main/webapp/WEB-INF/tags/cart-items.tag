<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<%@ attribute name="items" required="true" type="java.util.List" %>
<%@ attribute name="totalAmount" required="true" type="java.lang.Integer" %>
<%@ attribute name="totalCount" required="true" type="java.lang.Integer" %>
<%@ attribute name="readonly" type="java.lang.Boolean" %>

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
		<c:forEach var="item" varStatus="sts" items="${items}">
		<tr>
			<td>${sts.index + 1}</td>
			<td>${item.name}</td>
			<td class="text-end">
				<fmt:formatNumber value="${item.price}" /> MMK 
			</td>
			<td class="text-center">
				<div class="d-flex justify-content-around">
					<c:if test="${readonly eq null or readonly eq false}">
						<c:url var="remove" value="/cart/remove">
							<c:param name="productId" value="${item.productId}" />
						</c:url>
						<a href="${remove}" class="icon-link">
							<i class="bi-dash-lg"></i>
						</a>
					</c:if>
					<span>${item.quantity}</span>
					<c:if test="${readonly eq null or readonly eq false}">
						<c:url var="add" value="/cart/add">
							<c:param name="productId" value="${item.productId}" />
						</c:url>
						<a href="${add}" class="icon-link">
							<i class="bi-plus-lg"></i>
						</a>
					</c:if>
				</div>
			</td>
			<td class="text-end">
				<fmt:formatNumber value="${item.total}" /> MMK 
			</td>
		</tr>
		</c:forEach>
		
		<tr>
			<td colspan="3" class="text-end">Total</td>
			<td class="text-center">${totalCount}</td>
			<td class="text-end">
				<fmt:formatNumber value="${totalAmount}" /> MMK 
			</td>
		</tr>
	</tbody>
</table>