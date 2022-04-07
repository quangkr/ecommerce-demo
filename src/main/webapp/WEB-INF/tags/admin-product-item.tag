<%@tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@attribute name="url" required="true" description="The absolute (to the webapp) path (without 'page' request parameter)"%>
<%@attribute name="imgSrc" required="true" description="URL of thumbnail image"%>
<%@attribute name="name" required="true" description="Product name"%>
<%@attribute name="price" required="true" type="java.lang.Integer" description="Product price"%>
<%@attribute name="category" required="true" description="Product category"%>
<%@attribute name="brand" required="true" description="Product brand"%>

<c:url var="encUrl" value="${url}" />
<c:url var="encImgSrc" value="${imgSrc}" />

<div class="row mx-1 py-3 checkout-item border-bottom">
  <div class="col-3 col-md-2 row gx-1 justify-content-center pt-3">
    <a class="col-12 col-md-6" href="${encUrl}">
      <img src="${encImgSrc}" class="w-100" alt="${name}'s thumbnail">
    </a>
  </div>
  <div class="col row gy-2 justify-content-end text-end">
    <h5 class="col-12 col-md-5 fs-6 text-md-start">
      <a href="${encUrl}"><c:out value="${name}" /></a>
    </h5>
    <div class="col-12 col-md"><fmt:formatNumber type="number" value="${price}" /> đ</div>
    <div class="col-12 col-md"><c:out value="${category}" /></div>
    <div class="col-12 col-md"><c:out value="${brand}" /></div>
  </div>
</div>
