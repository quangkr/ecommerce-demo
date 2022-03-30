<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
  <title>Cart | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>
  <%@ include file="/WEB-INF/jspf/loading-modal.jspf"%>

  <script src="${root}/js/cart.js" type="module"></script>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <div class="container-xxl mb-md-5 py-2 py-md-5 px-4" style="margin-bottom: 5rem">
    <c:if test="${empty cart.cartItems}">
      <div class="mt-4 text-center fs-4">Your cart is empty!</div>
    </c:if>
    <c:forEach var="i" varStatus="s" items="${cart.cartItems}">
      <my:cart-item
        name="${i.product.name}"
        url="/product/${i.product.id}"
        imgSrc="${i.product.thumbnailUrl}"
        price="${i.product.price}"
        quantity="${i.quantity}"
        id="${i.product.id}"
      />
    </c:forEach>
  </div>

  <c:if test="${!empty cart.cartItems}">
    <div class="d-flex justify-content-center align-items-center py-3 fixed-bottom border-top bg-white">
      <div class="container-xxl row align-items-center px-1 px-md-4">
        <div class="col">
          <span>Total:</span>
          <span id="cart-grand-total" class="fw-bold"><fmt:formatNumber type="number" value="${cart.grandTotal}" /> đ</span>
        </div>
        <div class="col flex-grow-0">
          <my:link url="/checkout" cssClass="btn btn-primary">Checkout</my:link>
        </div>
      </div>
    </div>
  </c:if>

</body>
</html>
