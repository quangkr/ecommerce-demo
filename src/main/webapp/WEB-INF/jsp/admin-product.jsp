<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
  <title>Product editor | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>
  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <div class="container-xxl py-5 px-4">
    <h2 class="mb-4">Product editor</h2>

    <div class="mt-4">
      <my:pagination
        url="/admin/products"
        total="${products.totalPages}"
        current="${products.number + 1}"
        align="end"
      ></my:pagination>
    </div>

    <c:forEach var="p" items="${products.content}">
      <my:admin-product-item
        url="/admin/product/${p.id}"
        name="${p.name}"
        imgSrc="${p.thumbnailUrl}"
        price="${p.price}"
        category="${p.category.name}"
        brand="${p.brand.name}"
      ></my:admin-product-item>
    </c:forEach>

    <div class="mt-4">
      <my:pagination
        url="/admin/products"
        total="${products.totalPages}"
        current="${products.number + 1}"
        align="end"
      ></my:pagination>
    </div>
  </div>

</body>
</html>
