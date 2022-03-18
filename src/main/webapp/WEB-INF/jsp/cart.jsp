<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<title>Cart | Ecommerce demo</title>
<%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <table class="table table-striped">
    <thead>
      <tr>
        <th scope="col">No.
        <th scope="col">Name
        <th scope="col">Quantity
        <th scope="col">Price
      </tr>
    </thead>
    <tbody>
      <c:forEach var="i" varStatus="s" items="${cart.cartItems}">
        <tr>
          <th scope="row"><c:out value="${s.count}" />
          <td><c:out value="${i.product.name}" />
          <td><form:form action="${pageContext.request.contextPath}/cart/${i.product.id}" method="POST">
              <input type="hidden" name="action" value="update">
              <input type="text" name="quantity" value="${i.quantity}">
              <button type="submit">Update</button>
            </form:form>
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
