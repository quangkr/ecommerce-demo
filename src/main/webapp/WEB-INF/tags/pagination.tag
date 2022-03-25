<%@tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="url" required="true" description="The absolute (to the webapp) path (without 'page' request parameter)"%>
<%@attribute name="total" required="true" type="java.lang.Long" description="Total number of pages"%>
<%@attribute name="current" required="true" type="java.lang.Long" description="Current page number"%>
<%@attribute name="align" required="false" description="Pagination alignment"%>

<c:if test='${empty align || (align != "start" && align != "end")}'>
  <c:set var="align" value="center" />
</c:if>

<c:if test="${total <= 6}">
  <c:set var="begin" value="2" />
  <c:set var="end" value="${total - 1}" />
</c:if>
<c:if test="${total > 6}">
  <c:if test="${current > 3 && current < (total - 2)}">
    <c:set var="begin" value="${current - 1}" />
    <c:set var="end" value="${current + 1}" />
  </c:if>
  <c:if test="${current <= 3}">
    <c:set var="begin" value="2" />
    <c:set var="end" value="4" />
  </c:if>
  <c:if test="${current >= (total - 2)}">
    <c:set var="begin" value="${total - 3}" />
    <c:set var="end" value="${total - 1}" />
  </c:if>
</c:if>

<c:if test="${total > 1}">
  <nav aria-label="Page navigation">
    <ul class="pagination justify-content-${align}">
      <c:if test="${current > 1}">
        <my:page-item url="${url}" page="${current - 1}" current="-1" ariaLabel="Previous">&laquo;</my:page-item>
      </c:if>
      <my:page-item url="${url}" page="1" current="${current}">1</my:page-item>
      <c:if test="${begin > 2}">
        <li class="page-item disabled">
          <a href="#" class="page-link">...</a>
        </li>
      </c:if>
      <c:forEach var="i" begin="${begin}" end="${end}">
        <my:page-item url="${url}" page="${i}" current="${current}">${i}</my:page-item>
      </c:forEach>
      <c:if test="${end < (total - 1)}">
        <li class="page-item disabled">
          <a href="#" class="page-link">...</a>
        </li>
      </c:if>
      <my:page-item url="${url}" page="${total}" current="${current}">${total}</my:page-item>
      <c:if test="${current < total}">
        <my:page-item url="${url}" page="${current + 1}" current="-1" ariaLabel="Next">&raquo;</my:page-item>
      </c:if>
    </ul>
  </nav>
</c:if>
