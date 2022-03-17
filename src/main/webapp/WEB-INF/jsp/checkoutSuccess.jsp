<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>Checkout success | Ecommerce demo</title>
<%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <p>Success! Your order is being processed</p>

  <a href="${pageContext.request.contextPath}">Continue shopping</a>

</body>
</html>
