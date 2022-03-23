<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
  <title>Cart | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>

  <script src="${root}/js/cart.js" defer></script>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <table class="table table-striped">
    <thead>
      <tr>
        <th scope="col">No.</th>
        <th scope="col">Name</th>
        <th scope="col">Quantity</th>
        <th scope="col">Remove</th>
        <th scope="col">Price</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="i" varStatus="s" items="${cart.cartItems}">
        <tr class="cart-row" data-product-id="${i.product.id}">
          <th scope="row"><c:out value="${s.count}" /></th>
          <td><c:out value="${i.product.name}" /></td>
          <td>
            <button class="btn btn-primary btn-substract">-</button>
            <input type="text" class="input input-quantity" name="quantity" value="${i.quantity}" required />
            <button class="btn btn-primary btn-add">+</button>
          </td>

          <td><button class="btn btn-primary btn-remove">Remove</button></td>
          <td><c:out value="${i.product.price}" /></td>
        </tr>
      </c:forEach>
    </tbody>
    <tfoot>
      <tr>
        <td colspan="3">Grand total:</td>
        <td><c:out value="${cart.grandTotal}" />
      </tr>
    </tfoot>
  </table>

  <a href="${root}/cart/checkout">Proceed to checkout</a>

</body>
</html>
