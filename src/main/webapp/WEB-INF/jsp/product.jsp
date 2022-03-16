<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<title><c:out value="${product.name}" /> | Ecommerce demo</title>
<%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <img src="${product.thumbnailUrl}" alt="${product.name} thumbnail">
  <h1>${product.name}</h1>
  <p>
  <ul>
    <c:forEach var="description" items="${product.description}">
      <li><c:out value="${description}" /></li>
    </c:forEach>
  </ul>
  </p>

  <p>Brand: ${product.brand.name}</p>
  <p>Category: ${product.category.name}</p>

  <form:form action="${pageContext.request.contextPath}/cart/${product.id}" method="POST">
    <button id="btn-add-to-cart" type="submit">Add to cart</button>
  </form:form>

</body>
</html>
