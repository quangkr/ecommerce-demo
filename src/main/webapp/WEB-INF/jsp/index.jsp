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
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-5 g-4">
      <c:forEach var="p" items="${cellphones}">
        <div class="col">
          <my:product-card
            url="/product/show?id=${p.id}"
            name="${p.name}"
            imgSrc="${p.thumbnailUrl}"
            description="${p.description}"
            price="${p.price}"
          ></my:product-card>
        </div>
      </c:forEach>
    </div>
  </section>

  <section>
    <h2>Top Laptops</h2>
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-5 g-4">
      <c:forEach var="p" items="${laptops}">
        <div class="col">
          <my:product-card
            url="/product/show?id=${p.id}"
            name="${p.name}"
            imgSrc="${p.thumbnailUrl}"
            description="${p.description}"
            price="${p.price}"
          ></my:product-card>
        </div>
      </c:forEach>
    </div>
  </section>

</body>
</html>
