<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
  <title>Confirm checkout | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <div class="container-xxl py-5 px-4">
    <div class="row">
      <div class="col-12 col-md-4 pt-4 order-md-2">
        <div class="row">
          <div class="col-auto">Recipient:</div>
          <div class="col fw-bold text-end"><c:out value="${shippingDetail.fullName}" /></div>
        </div>
        <div class="row">
          <div class="col-auto">Phone number:</div>
          <div class="col fw-bold text-end"><c:out value="${shippingDetail.phoneNumber}" /></div>
        </div>
        <div class="row">
          <div class="col-auto">Address</div>
          <div class="col fw-bold text-end"><c:out value="${shippingDetail.address}" /></div>
        </div>
        <div class="row">
          <div class="col-auto">Ward:</div>
          <div class="col fw-bold text-end"><c:out value="${shippingDetail.ward}" /></div>
        </div>
        <div class="row">
          <div class="col-auto">District:</div>
          <div class="col fw-bold text-end"><c:out value="${shippingDetail.district}" /></div>
        </div>
        <div class="row">
          <div class="col-auto">City:</div>
          <div class="col fw-bold text-end"><c:out value="${shippingDetail.city}" /></div>
        </div>
        <hr />
        <div class="mt-4 mb-3 text-end">
          <span>Grand total:</span>
          <span class="fw-bold"><fmt:formatNumber type="number" value="${cart.grandTotal}" /> đ</span>
        </div>
        <div class="col d-flex justify-content-center">
          <my:form url="/checkout/confirm" method="POST">
            <button class="btn btn-secondary px-5 py-2" type="submit">Checkout</button>
          </my:form>
        </div>
      </div>

      <div class="col-12 col-md-8 pe-md-5">
        <c:forEach var="i" items="${cart.cartItems}">
          <my:checkout-item
            name="${i.product.name}"
            url="/product/${i.product.id}"
            imgSrc="${i.product.thumbnailUrl}"
            price="${i.product.price}"
            quantity="${i.quantity}"
          />
        </c:forEach>
      </div>
    </div>

  </div>

</body>
</html>
