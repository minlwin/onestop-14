<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:template title="Sign Up">
	
	<h5><i class="bi-user-plus"></i> Sign Up</h5>
	
	<div class="row">
		<div class="col-4">
			<form method="post">
				
				<app:form-group label="Name">
					<input value="${param.name}" class="form-control" name="name" placeholder="Please enter your name." required="required" />
				</app:form-group>

				<app:form-group label="Email">
					<input value="${param.email}" class="form-control" type="email" name="email" placeholder="Please enter email for login." required="required" />
				</app:form-group>
				
				<app:form-group label="Password">
					<input value="${param.password}" class="form-control" type="password" name="password" placeholder="Please enter Password." required="required" />
				</app:form-group>
				
				<div>
					<button type="submit" class="btn btn-primary">
						<i class="bi-user-plus"></i> Sign Up
					</button>
					
					<c:url value="/signin" var="signIn"></c:url>
					<a href="${signIn}" class="btn btn-outline-primary">
						<i class="bi-unlock"></i> Sign In 
					</a>
				</div>
			
			</form>		
		</div>
	</div>
	
</app:template>