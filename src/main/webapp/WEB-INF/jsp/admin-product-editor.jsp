<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
  <title><c:out value="${title}" /> | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>

  <script src="${root}/js/admin-product-editor.js" type="module"></script>
</head>

<body>
  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <div class="container-xxl py-5 px-4">
    <div class="fs-2 text-dark">
      <my:link url="/admin/products?mode=edit" cssClass="text-muted">
        <i class="bi bi-arrow-left-short"></i>
      </my:link>
    </div>
    <div class="row justify-content-center">
      <div class="col-12 col-md-8">
        <c:url value="/admin/product/${productId}" var="formUrl" />
        <form:form action="${formUrl}" method="POST" modelAttribute="product" id="form-product">
          <div class="row mb-3">
            <form:label path="name" for="form-name" cssClass="col-sm-3 col-form-label">Product name</form:label>
            <div class="col-sm-9">
              <form:input
                path="name"
                id="form-name"
                cssClass="form-control"
                cssErrorClass="form-control is-invalid"
                type="text"
                placeholder="Product name"
              />
              <form:errors path="name" cssClass="invalid-feedback" element="div" />
            </div>
          </div>
          <div class="row mb-3">
            <form:label path="description" for="form-description" cssClass="col-sm-3 col-form-label">Product description</form:label>
            <div id="form-description-group" class="col-sm-9">
              <c:forEach var="d" varStatus="s" items="${product.description}">
                <div class="input-group mb-2">
                  <form:input
                    path="description[${s.count - 1}]"
                    cssClass="form-control"
                    cssErrorClass="form-control is-invalid"
                    type="text"
                  />
                  <button type="button" class="btn btn-sm btn-outline-primary btn-add-description"><i class="bi bi-plus"></i></button>
                  <button type="button" class="btn btn-sm btn-outline-danger btn-remove-description"><i class="bi bi-x"></i></button>
                </div>
                <form:errors path="description[${s.count - 1}]" cssClass="invalid-feedback" element="div" />
              </c:forEach>
            </div>
          </div>
          <div class="row mb-3">
            <form:label path="thumbnailUrl" for="form-thumbnail-url" cssClass="col-sm-3 col-form-label">Product thumbnail url</form:label>
            <div class="col-sm-9">
              <form:input
                path="thumbnailUrl"
                id="form-thumbnail-url"
                cssClass="form-control"
                cssErrorClass="form-control is-invalid"
                type="text"
                placeholder="Product thumbnail url"
              />
              <form:errors path="thumbnailUrl" cssClass="invalid-feedback" element="div" />
            </div>
          </div>
          <div class="row mb-3">
            <form:label path="price" for="form-price" cssClass="col-sm-3 col-form-label">Product price</form:label>
            <div class="col-sm-9">
              <form:input
                path="price"
                id="form-price"
                cssClass="form-control"
                cssErrorClass="form-control is-invalid"
                type="text"
                placeholder="Product price"
              />
              <form:errors path="price" cssClass="invalid-feedback" element="div" />
            </div>
          </div>
          <div class="row mb-3">
            <form:label path="brand" for="form-brand" cssClass="col-sm-3 col-form-label">Product brand</form:label>
            <div class="col-sm-9">
              <form:input
                path="brand"
                id="form-brand"
                cssClass="form-control"
                cssErrorClass="form-control is-invalid"
                type="text"
                placeholder="Product brand"
              />
              <form:errors path="brand" cssClass="invalid-feedback" element="div" />
            </div>
          </div>
          <div class="row mb-3">
            <form:label path="category" for="form-category" cssClass="col-sm-3 col-form-label">Product category</form:label>
            <div class="col-sm-9">
              <form:input
                path="category"
                id="form-category"
                cssClass="form-control"
                cssErrorClass="form-control is-invalid"
                type="text"
                placeholder="Product category"
              />
              <form:errors path="category" cssClass="invalid-feedback" element="div" />
            </div>
          </div>
          <div class="col d-flex justify-content-center">
          <form:button class="btn btn-secondary px-5 py-2" type="submit">
            <c:out value="${productId == 'new' ? 'Add' : 'Modify'}" />
          </form:button>
        </div>
      </form:form>
    </div>
  </div>
</div>

</body>
</html>
