<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

  <section>
    <c:forEach var="p" items="${products}">
      <p>
        <a href="${pageContext.request.contextPath}/product/${p.id}">Item <c:out value="${p.name}" /></a>
      </p>
    </c:forEach>
  </section>

</body>
</html>
