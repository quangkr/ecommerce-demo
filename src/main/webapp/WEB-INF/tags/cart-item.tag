<%@tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@attribute name="url" required="true" description="The absolute (to the webapp) path (without 'page' request parameter)"%>
<%@attribute name="imgSrc" required="true" description="URL of thumbnail image"%>
<%@attribute name="id" required="true" type="java.lang.Integer" description="Product id"%>
<%@attribute name="name" required="true" description="Product name"%>
<%@attribute name="price" required="true" type="java.lang.Integer" description="Product price"%>
<%@attribute name="quantity" required="true" type="java.lang.Integer" description="Product quantity"%>

<c:url var="encUrl" value="${url}" />
<c:url var="encImgSrc" value="${imgSrc}" />

<div class="row py-3 cart-item border-bottom" data-product-id="${id}">
  <div class="col-3 col-md-2 row gx-1 justify-content-center pt-3">
    <a class="col-12 col-md-6" href="${encUrl}">
      <img src="${encImgSrc}" class="w-100" alt="${name}'s thumbnail">
    </a>
  </div>
  <div class="col-9 col-md-10 row gy-2 justify-content-end text-end">
    <h5 class="col-12 col-md-6 fs-6 text-md-start"><c:out value="${name}" /></h5>
    <div class="col-12 col-md-3"><fmt:formatNumber type="number" value="${price}" /> đ</div>
    <div class="col-9 col-md-3">
      <div class="row flex-nowrap">
        <div class="col input-group input-group-sm w-auto">
          <button class="btn btn-secondary btn-substract" type="button">-</button>
          <input type="text" class="form-control text-center input-quantity" name="quantity" value="${quantity}" required />
          <button class="btn btn-secondary btn-add" type="button">+</button>
        </div>
        <div class="col p-0 flex-grow-0" >
          <button class="btn btn-sm m-0 btn-danger btn-remove"><i class="bi bi-trash3"></i></button>
        </div>
      </div>
    </div>
  </div>
</div>
