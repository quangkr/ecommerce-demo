<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<title>Confirm checkout | Ecommerce demo</title>
<%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <div>
    <ul>
      <li>Full name: <c:out value="${shippingDetail.fullName}" />
      <li>Phone number: <c:out value="${shippingDetail.phoneNumber}" />
      <li>Address: <c:out value="${shippingDetail.address}" />
      <li>Ward: <c:out value="${shippingDetail.ward}" />
      <li>District: <c:out value="${shippingDetail.district}" />
      <li>City: <c:out value="${shippingDetail.city}" />
    </ul>
  </div>

  <div>
    <a href="${pageContext.request.contextPath}/cart/checkout">Back</a>
    <form:form action="${pageContext.request.contextPath}/cart/checkoutConfirm" method="POST">
      <button type="submit">Checkout</button>
    </form:form>
  </div>

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
  </table>

</body>
</html>