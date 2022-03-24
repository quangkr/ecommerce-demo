<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
  <title>Homepage | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>
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
    <h2>Top Cellphones</h2>
    <c:forEach var="p" items="${cellphones}">
      <p>
        <my:link url="/product/show?id=${p.id}">Item <c:out value="${p.name}" /></my:link>
      </p>
    </c:forEach>
  </section>

  <section>
    <h2>Top Laptops</h2>
    <c:forEach var="p" items="${laptops}">
      <p>
        <my:link url="/product/show?id=${p.id}">Item <c:out value="${p.name}" /></my:link>
      </p>
    </c:forEach>
  </section>

</body>
</html>
