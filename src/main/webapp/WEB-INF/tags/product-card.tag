<%@tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@attribute name="url" required="true" description="The absolute (to the webapp) path (without 'page' request parameter)"%>
<%@attribute name="imgSrc" required="true" description="URL of thumbnail image"%>
<%@attribute name="name" required="true" description="Product name"%>
<%@attribute name="price" required="true" type="java.lang.Integer" description="Product price"%>
<%@attribute name="description" required="true" type="java.lang.String[]" description="Product description"%>

<c:url var="encUrl" value="${url}" />
<c:url var="encImgSrc" value="${imgSrc}" />

<div class="card h-100">
  <a href="${encUrl}">
    <img src="${encImgSrc}" class="card-img-top" alt="${name}'s thumbnail">
  </a>
  <div class="card-body">
    <a class="d-block text-decoration-none text-dark" href="${encUrl}">
      <h5 class="card-text fs-6 fw-normal"><c:out value="${name}" /></h5>
      <div class="card-title fs-5" style="font-weight: 600"><fmt:formatNumber type="number" value="${price}" /> đ</div>
    </a>
    <div class="card-text">
      <ul>
        <c:forEach var="d" items="${description}">
          <li><c:out value="${d}" /></li>
        </c:forEach>
      </ul>
    </div>
  </div>
</div>
