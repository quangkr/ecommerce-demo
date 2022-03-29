<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
  <title><c:out value="${product.name}" /> | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>

  <script src="${root}/js/product.js" type="module"></script>
</head>

<body>
  <%@ include file="/WEB-INF/jspf/header.jspf"%>
  <%@ include file="/WEB-INF/jspf/toasts.jspf"%>
  <%@ include file="/WEB-INF/jspf/loading-modal.jspf"%>

  <div class="container-xxl py-5 px-4">
    <div class="row">
      <div class="col-md-6 mb-3 mb-md-0 d-flex justify-content-center">
        <img src="${product.thumbnailUrl}" alt="${product.name} thumbnail" class="h-100" style="max-height: 400px"/>
      </div>
      <div class="col-md-6">
        <h2>${product.name}</h2>
        <ul>
          <c:forEach var="description" items="${product.description}">
            <li><c:out value="${description}" /></li>
          </c:forEach>
        </ul>

        <p>Brand: ${product.brand.name}</p>
        <p>Category: ${product.category.name}</p>

        <div class="row flex-nowrap ps-1 ps-md-0 pe-5 add-to-cart-container">
          <div class="col col-md-5 input-group input-group-sm w-auto">
            <button class="btn btn-secondary btn-decrease" type="button">-</button>
            <input
              type="text"
              class="form-control text-center input-quantity"
              name="quantity"
              value="1"
              data-quantity="1"
              required
            />
            <button class="btn btn-secondary btn-increase" type="button">+</button>
          </div>
          <div class="col col-md-7 p-0" >
            <button class="btn btn-primary px-4 py-2 btn-add-to-cart" data-product-id="${product.id}">Add to cart</button>
          </div>
        </div>

      </div>
    </div>
  </div>

</body>
</html>
