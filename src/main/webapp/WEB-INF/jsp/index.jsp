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

  <div class="container-xxl py-5 px-4">
    <h1 class="my-3">Welcome to Ecommerce Demo app.</h1>

    <section>
      <h2 class="mb-3 mt-5">Top Cellphones</h2>
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4">
        <c:forEach var="p" items="${cellphones}">
          <div class="col">
            <my:product-card
              url="/product/${p.id}"
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
      <h2 class="mb-3 mt-5">Top Laptops</h2>
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4">
        <c:forEach var="p" items="${laptops}">
          <div class="col">
            <my:product-card
              url="/product/${p.id}"
              name="${p.name}"
              imgSrc="${p.thumbnailUrl}"
              description="${p.description}"
              price="${p.price}"
            ></my:product-card>
          </div>
        </c:forEach>
      </div>
    </section>
   </div>

</body>
</html>
