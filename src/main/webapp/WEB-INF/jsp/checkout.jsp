<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
  <title>Checkout | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <div class="container-xxl py-5 px-4">
    <div class="row">
      <div class="col-12 col-md-4 order-md-2">
        <c:url value="/checkout" var="checkoutUrl" />
        <form:form action="${checkoutUrl}" method="POST" modelAttribute="shippingDetail"
          cssClass="row g-3"
        >
          <div class="form-floating col-12">
            <spring:bind path="fullName">
              <form:input
                path="fullName"
                id="form-full-name"
                cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                type="text"
                placeholder="Recipient"
              />
              <label for="form-full-name" class="form-label">Recipient</label>
              <form:errors path="fullName" cssClass="invalid-feedback" element="div" />
            </spring:bind>
          </div>
          <div class="form-floating col-12">
            <spring:bind path="phoneNumber">
              <form:input
                path="phoneNumber"
                id="form-phone-number"
                cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                type="text"
                placeholder="Phone number"
              />
              <label for="form-phone-number" class="form-label">Phone number</label>
              <form:errors path="phoneNumber" cssClass="invalid-feedback" element="div" />
            </spring:bind>
          </div>
          <div class="form-floating col-12">
            <spring:bind path="address">
              <form:input
                path="address"
                id="form-address"
                cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                type="text"
                placeholder="Address"
              />
              <label for="form-address" class="form-label">Address</label>
              <form:errors path="address" cssClass="invalid-feedback" element="div" />
            </spring:bind>
          </div>
          <div class="form-floating col-4">
            <spring:bind path="ward">
              <form:input
                path="ward"
                id="form-ward"
                cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                type="text"
                placeholder="Ward"
              />
              <label for="form-ward" class="form-label">Ward</label>
              <form:errors path="ward" cssClass="invalid-feedback" element="div" />
            </spring:bind>
          </div>
          <div class="form-floating col-4">
            <spring:bind path="district">
              <form:input
                path="district"
                id="form-district"
                cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                type="text"
                placeholder="District"
              />
              <label for="form-district" class="form-label">District</label>
              <form:errors path="district" cssClass="invalid-feedback" element="div" />
            </spring:bind>
          </div>
          <div class="form-floating col-4">
            <spring:bind path="city">
              <form:input
                path="city"
                id="form-city"
                cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                type="text"
                placeholder="City"
              />
              <label for="form-city" class="form-label">City</label>
              <form:errors path="city" cssClass="invalid-feedback" element="div" />
            </spring:bind>
          </div>
          <hr />
          <div class="col-12 text-end">
            <span>Grand total:</span>
            <span class="fw-bold"><fmt:formatNumber type="number" value="${cart.grandTotal}" /> đ</span>
          </div>
          <div class="col d-flex justify-content-center">
            <form:button class="btn btn-secondary px-5 py-2" type="submit">Continue</form:button>
          </div>
        </form:form>
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
