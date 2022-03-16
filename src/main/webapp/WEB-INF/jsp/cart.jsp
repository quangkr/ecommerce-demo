<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>Insert title here</title>
<%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <table>
    <thead>
      <tr>
        <th>No.
        <th>Name
        <th>Quantity
      </tr>
    </thead>
    <tbody>
      <c:forEach var="i" varStatus="s" items="${cart.cartItems}">
        <tr>
          <td><c:out value="${s.count}" />
          <td><c:out value="${i.id.product.name}" />
          <td><c:out value="${i.quantity}" />
        </tr>
      </c:forEach>
    </tbody>
  </table>

</body>
</html>
