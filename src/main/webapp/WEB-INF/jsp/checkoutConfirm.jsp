<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <a href="${root}/cart/checkout">Back</a>
    <my:form url="/cart/checkoutConfirm" method="POST">
      <button type="submit">Checkout</button>
    </my:form>
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
    <tfoot>
      <tr>
        <td colspan="3">Grand total:
        <td><c:out value="${cart.grandTotal}" />
      </tr>
    </tfoot>
  </table>

</body>
</html>
