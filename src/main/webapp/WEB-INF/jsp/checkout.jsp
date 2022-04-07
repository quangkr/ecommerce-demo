<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
            <form:input
              path="fullName"
              id="form-full-name"
              cssClass="form-control"
              cssErrorClass="form-control is-invalid"
              type="text"
              placeholder="Recipient"
            />
            <form:label path="fullName" for="form-full-name" cssClass="form-label">Recipient</form:label>
            <form:errors path="fullName" cssClass="invalid-feedback" element="div" />
          </div>
          <div class="form-floating col-12">
            <form:input
              path="phoneNumber"
              id="form-phone-number"
              cssClass="form-control"
              cssErrorClass="form-control is-invalid"
              type="text"
              placeholder="Phone number"
            />
            <form:label path="phoneNumber" for="form-phone-number" cssClass="form-label">Phone number</form:label>
            <form:errors path="phoneNumber" cssClass="invalid-feedback" element="div" />
          </div>
          <div class="form-floating col-12">
            <form:input
              path="address"
              id="form-address"
              cssClass="form-control"
              cssErrorClass="form-control is-invalid"
              type="text"
              placeholder="Address"
            />
            <form:label path="address" for="form-address" cssClass="form-label">Address</form:label>
            <form:errors path="address" cssClass="invalid-feedback" element="div" />
          </div>
          <div class="form-floating col-4">
            <form:input
              path="ward"
              id="form-ward"
              cssClass="form-control"
              cssErrorClass="form-control is-invalid"
              type="text"
              placeholder="Ward"
            />
            <form:label path="ward" for="form-ward" cssClass="form-label">Ward</form:label>
            <form:errors path="ward" cssClass="invalid-feedback" element="div" />
          </div>
          <div class="form-floating col-4">
            <form:input
              path="district"
              id="form-district"
              cssClass="form-control"
              cssErrorClass="form-control is-invalid"
              type="text"
              placeholder="District"
            />
            <form:label path="district" for="form-district" cssClass="form-label">District</form:label>
            <form:errors path="district" cssClass="invalid-feedback" element="div" />
          </div>
          <div class="form-floating col-4">
            <form:input
              path="city"
              id="form-city"
              cssClass="form-control"
              cssErrorClass="form-control is-invalid"
              type="text"
              placeholder="City"
            />
            <form:label path="city" for="form-city" cssClass="form-label">City</form:label>
            <form:errors path="city" cssClass="invalid-feedback" element="div" />
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
