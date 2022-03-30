<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <c:url value="/checkout" var="checkoutUrl" />
    <form:form action="${checkoutUrl}" method="POST" modelAttribute="shippingDetail"
      cssClass="row g-3"
    >
      <div class="col-12">
        <label for="form-full-name" class="form-label">Full name</label>
        <form:input path="fullName" id="form-full-name" cssClass="form-control" type="text" />
      </div>
      <div class="col-12">
        <label for="form-phone-number" class="form-label">Phone number</label>
        <form:input path="phoneNumber" id="form-phone-number" cssClass="form-control" type="text" />
      </div>
      <div class="col-12">
        <label for="form-address" class="form-label">Address</label>
        <form:input path="address" id="form-address" cssClass="form-control" type="text" />
      </div>
      <div class="col-md-4">
        <label for="form-ward" class="form-label">Ward</label>
        <form:input path="ward" id="form-ward" cssClass="form-control" type="text" />
      </div>
      <div class="col-md-4">
        <label for="form-district" class="form-label">District</label>
        <form:input path="district" id="form-district" cssClass="form-control" type="text" />
      </div>
      <div class="col-md-4">
        <label for="form-city" class="form-label">City</label>
        <form:input path="city" id="form-city" cssClass="form-control" type="text" />
      </div>
      <div class="col-12">
        <button type="submit">Submit</button>
      </div>
    </form:form>

    <table class="table table-striped">
      <thead>
        <tr>
          <th scope="col">No.
          <th scope="col">Name
          <th scope="col">Quantity
          <th scope="col">Total
        </tr>
      </thead>
      <tbody>
        <c:forEach var="i" varStatus="s" items="${cart.cartItems}">
          <tr>
            <th scope="row"><c:out value="${s.count}" />
            <td><c:out value="${i.product.name}" />
            <td><c:out value="${i.quantity}" />
            <td><c:out value="${i.quantity * i.product.price}" />
          </tr>
        </c:forEach>
      </tbody>
      <tfoot>
        <tr>
          <td colspan="3">Grand total:
          <td><c:out value="${cart.grandTotal}" />
        </tr>
      </tfoot>
    </table>
  </div>

</body>
</html>
