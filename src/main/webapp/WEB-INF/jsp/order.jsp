<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
  <title>Orders | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <div class="container-xxl py-5 px-4">
    <c:forEach var="o" varStatus="oStatus" items="${orders}">
      <h2>Order <c:out value="#${oStatus.count} (${o.createdAt})"/></h2>
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
          <c:forEach var="i" varStatus="iStatus" items="${o.orderItems}">
            <tr>
              <th scope="row"><c:out value="${iStatus.count}" />
              <td><c:out value="${i.product.name}" />
              <td><c:out value="${i.quantity}" />
              <td><c:out value="${i.quantity * i.product.price}" />
            </tr>
          </c:forEach>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="3">Grand total:
            <td><c:out value="${o.grandTotal}" />
          </tr>
        </tfoot>
      </table>
    </c:forEach>
  </div>

</body>
</html>
