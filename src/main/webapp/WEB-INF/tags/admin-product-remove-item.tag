<%@tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@attribute name="imgSrc" required="true" description="URL of thumbnail image"%>
<%@attribute name="id" required="true" type="java.lang.Long" description="Product id"%>
<%@attribute name="name" required="true" description="Product name"%>
<%@attribute name="price" required="true" type="java.lang.Integer" description="Product price"%>

<c:url var="encImgSrc" value="${imgSrc}" />

<div class="row mx-1 py-3 border-bottom admin-product-remove-item">
  <div class="col-3 col-md-2 row gx-1 justify-content-center align-items-center pt-3">
    <div class="col-2 col-md-4">
      <input type="checkbox" data-product-id="${id}">
    </div>
    <div class="col col-md-6">
      <img src="${encImgSrc}" class="w-100" alt="${name}'s thumbnail">
    </div>
  </div>
  <div class="col row gy-2 justify-content-end align-items-md-center text-end">
    <h5 class="col-12 col-md-7 fs-6 text-md-start">
      <c:out value="${name}" />
    </h5>
    <div class="col-12 col-md"><fmt:formatNumber type="number" value="${price}" /> đ</div>
  </div>
</div>
