<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:template title="Home">
   <div class="row row-cols-3 g-4">
       <c:forEach var="p" items="${products}">
           <div class="col">
               <div class="card">
                   <div class="card-body">
                       
                       <h5 class="card-title">${p.name}</h5>
                       
                       <div class="d-flex justify-content-between">
                           <span>${p.category}</span>
                           <span>
                               <fmt:formatNumber value="${p.price}" /> MMK
                           </span>
                       </div>
                       
                       <div class="pt-2 text-end">             
                           <c:url value="/cart/add" var="addToCart">
                               <c:param name="productId" value="${p.id}" />
                               <c:param name="fromHome" value="true" />
                           </c:url>
                       
                           <a href="${addToCart}" class="btn btn-outline-primary">
                               <i class="bi-cart-plus"></i> Add To Cart
                           </a>
                       </div>

                   </div>
                   
               </div>
           </div>
       </c:forEach>
   </div>
</app:template>