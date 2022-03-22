<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title><c:out value="${product.name}" /> | Ecommerce demo</title>
<%@ include file="/WEB-INF/jspf/meta.jspf"%>

<script src="${pageContext.request.contextPath}/js/product.js" defer></script>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <img src="${product.thumbnailUrl}" alt="${product.name} thumbnail">
  <h1>${product.name}</h1>
  <ul>
    <c:forEach var="description" items="${product.description}">
      <li><c:out value="${description}" /></li>
    </c:forEach>
  </ul>

  <p>Brand: ${product.brand.name}</p>
  <p>Category: ${product.category.name}</p>

  <div class="add-to-cart-container" data-product-id="${product.id}">
    <input type="text" name="quantity" value="1" required>
    <button class="btn btn-primary">Add to cart</button>
  </div>

  <div class="toast-container position-fixed top-0 end-0 p-3" role="alert" aria-live="polite" aria-atomic="true">
    <div id="toast-add-success" class="toast align-items-center text-white bg-success border-0">
      <div class="d-flex">
        <div class="toast-body">Product added to cart successfully!</div>
        <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
      </div>
    </div>

    <div id="toast-add-failed" class="toast align-items-center text-white bg-danger border-0">
      <div class="d-flex">
        <div class="toast-body">Product added to cart unsuccessfully!</div>
        <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
      </div>
    </div>
  </div>

</body>
</html>
