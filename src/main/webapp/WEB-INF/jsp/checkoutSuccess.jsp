<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>

<head>
  <title>Checkout success | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <div class="container-xxl py-5 px-4">
    <p>Success! Your order is being processed</p>

    <my:link url="/">Continue shopping</my:link>
  </div>

</body>
</html>
