<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<c:if test="${empty displayedCategoryName}">
  <c:set var="title" value="Products" />
</c:if>
<c:if test="${!empty displayedCategoryName}">
  <c:set var="title" value="${displayedCategoryName}" />
</c:if>
<c:if test="${!empty categoryName}">
  <c:set var="categoryParam" value="?category=" />
</c:if>

<head>
  <title><c:out value='${title}' /> | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>
  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4">
    <c:forEach var="p" items="${productPage.content}">
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

  <my:pagination
    url='/product${categoryParam}${categoryName}'
    total="${productPage.totalPages}"
    current="${productPage.number + 1}"
  ></my:pagination>

</body>
</html>
