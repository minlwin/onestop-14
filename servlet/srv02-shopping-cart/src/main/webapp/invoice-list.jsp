<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:template title="Invoice">
	
	<h5><i class="bi-list"></i> Invoice List</h5>
	
	<table class="table table-striped">
		
		<thead>
			<tr>
				<th>ID</th>
				<th>Customer</th>
				<th>Email</th>
				<th>Invoice At</th>
				<th class="text-end">Invoice Amount</th>
				<th></th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.invoiceId}</td>
					<td>${item.account.name}</td>
					<td>${item.account.email}</td>
					<td>${item.invoiceDateTime}</td>
					<td class="text-end">
						<fmt:formatNumber value="${item.totalAmount}" /> MMK
					</td>
					<td class="text-center">
						<c:url value="/invoice" var="details">
							<c:param name="id" value="${item.id}" />
						</c:url>
						<a href="${details}" class="icon-link">
							<i class="bi-arrow-right"></i>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
	

</app:template>