<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>Cart | Ecommerce demo</title>
<%@ include file="/WEB-INF/jspf/meta.jspf"%>

<script src="${pageContext.request.contextPath}/js/cart.js" defer></script>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <table class="table table-striped">
    <thead>
      <tr>
        <th scope="col">No.
        <th scope="col">Name
        <th scope="col">Quantity
        <th scope="col">Remove
        <th scope="col">Price
      </tr>
    </thead>
    <tbody>
      <c:forEach var="i" varStatus="s" items="${cart.cartItems}">
        <tr class="cart-row" data-product-id="${i.product.id}">
          <th scope="row"><c:out value="${s.count}" />
          <td><c:out value="${i.product.name}" />
          <td>
            <button class="btn btn-primary btn-substract">-</button>
            <input type="text" class="input input-quantity" name="quantity" value="${i.quantity}" required>
            <button class="btn btn-primary btn-add">+</button>
          <td><button class="btn btn-primary btn-remove">Remove</button>
          <td><c:out value="${i.product.price}" />
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

  <a href="${pageContext.request.contextPath}/cart/checkout">Proceed to checkout</a>

</body>
</html>
