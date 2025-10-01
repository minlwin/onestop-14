<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:template title="Sign In">
	
	<h5><i class="bi-unlock"></i> Sign In</h5>
	
	<div class="row">
		<div class="col-4">
			<form method="post">
				
				<app:form-group label="Login Id">
					<input value="${param.email}" class="form-control" type="email" name="email" placeholder="Please enter email for login." required="required" />
				</app:form-group>
				
				<app:form-group label="Password">
					<input value="${param.password}" class="form-control" type="password" name="password" placeholder="Please enter Password." required="required" />
				</app:form-group>
				
				<div>
					<button type="submit" class="btn btn-primary">
						<i class="bi-unlock"></i> Sign In 
					</button>
					
					<c:url value="/signup" var="signUp"></c:url>
					<a href="${signUp}" class="btn btn-outline-primary">
						<i class="bi-user-plus"></i> Sign Up
					</a>
				</div>
			
			</form>		
		</div>
	</div>

</app:template>