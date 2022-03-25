<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
  <title><c:out value="${displayedCategoryName}" /> | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>
  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <c:forEach var="p" items="${productPage.content}">
    <p>
      <my:link url="/product/show?id=${p.id}">Item <c:out value="${p.name}" /></my:link>
    </p>
  </c:forEach>

</body>
</html>
