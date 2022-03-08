<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <sec:authorize access="!isAuthenticated()">
    <h1>Welcome to Ecommerce Demo app.</h1>
  </sec:authorize>
  <sec:authorize access="isAuthenticated()">
    <h1>
      Welcome back to Ecommerce Demo app,
      <sec:authentication property="name" />
      !
    </h1>
  </sec:authorize>

</body>
</html>