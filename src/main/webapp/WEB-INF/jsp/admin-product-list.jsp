<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
  <title>Product editor | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>

  <script src="${root}/js/admin-product-list.js" type="module"></script>
</head>

<body>
  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <c:set var="currentUrl" value='${requestScope["javax.servlet.forward.servlet_path"]}' />
  <div class="container-xxl py-5 px-4">
    <h2 class="mb-4">Product editor</h2>

    <div class="d-flex justify-content-end">
      <c:if test="${mode == 'edit'}">
        <my:link url="/admin/product/new" cssClass="btn btn-primary">
          <i class="bi bi-plus-lg"></i>
          New product
        </my:link>
      </c:if>
      <c:if test="${mode == 'remove'}">
        <button class="btn btn-danger btn-product-remove" disabled>
          <i class="bi bi-trash"></i>
          Remove
        </button>
      </c:if>
      <c:if test="${mode == 'restore'}">
        <button class="btn btn-success btn-product-restore" disabled>
          <i class="bi bi-box-arrow-up"></i>
          Restore
        </button>
      </c:if>
    </div>

    <div class="mt-4">
      <my:pagination
        url="${currentUrl}"
        total="${products.totalPages}"
        current="${products.number + 1}"
        align="end"
      ></my:pagination>
    </div>

    <ul class="nav nav-tabs">
      <li class="nav-item">
        <my:hlink-param
          url="/admin/products"
          cssClass="nav-link"
          names="mode"
          values="edit"
        >Edit</my:hlink-param>
      </li>
      <li class="nav-item">
        <my:hlink-param
          url="/admin/products"
          cssClass="nav-link"
          names="mode"
          values="remove"
        >Remove</my:hlink-param>
      </li>
      <li class="nav-item">
        <my:hlink-param
          url="/admin/products"
          cssClass="nav-link"
          names="mode"
          values="restore"
        >Restore</my:hlink-param>
      </li>
    </ul>

    <c:if test="${mode == 'edit'}">
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
    </c:if>
    <c:if test="${mode == 'remove' || mode == 'restore'}">
      <c:forEach var="p" items="${products.content}">
        <my:admin-product-remove-item
          id="${p.id}"
          name="${p.name}"
          imgSrc="${p.thumbnailUrl}"
          price="${p.price}"
        ></my:admin-product-remove-item>
      </c:forEach>
    </c:if>

    <div class="mt-4">
      <my:pagination
        url="${currentUrl}"
        total="${products.totalPages}"
        current="${products.number + 1}"
        align="end"
      ></my:pagination>
    </div>
  </div>

</body>
</html>
