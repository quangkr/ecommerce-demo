<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>Insert title here</title>
<%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>

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

</body>
</html>