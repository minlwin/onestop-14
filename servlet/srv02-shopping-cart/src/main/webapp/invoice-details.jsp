<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:template title="Invoice">
	
	<h5><i class="bi-bag-check"></i> Invoice ID : ${details.invoiceId}</h5>
	
	<div class="row">
		<div class="col-4">
			<div class="list-group">
				<div class="list-group-item d-flex justify-content-between">
					<span>Customer</span>
					<span>${details.account.name}</span>
				</div>
				<div class="list-group-item d-flex justify-content-between">
					<span>Invoice Amount</span>
					<span>${details.totalAmount}</span>
				</div>
				<div class="list-group-item d-flex justify-content-between">
					<span>Invoice At</span>
					<span>${details.invoiceDateTime}</span>
				</div>
			</div>
		</div>
	</div>
	
	<section>
		<app:cart-items items="${details.items}" readonly="true"
			totalAmount="${details.totalAmount}" totalCount="${details.totalCount}" />
	</section>

</app:template>