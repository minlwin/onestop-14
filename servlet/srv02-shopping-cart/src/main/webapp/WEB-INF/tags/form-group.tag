<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="label" type="java.lang.String" required="true" %>

<div class="mb-3">
	<label class="mb-1">${label}</label>
	<jsp:doBody></jsp:doBody>
</div>