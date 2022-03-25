<%@tag body-content="scriptless" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@attribute name="url" required="true" description="The absolute (to the webapp) path (without 'page' request parameter)"%>
<%@attribute name="page" required="true" description="The page number to be displayed"%>
<%@attribute name="current" required="true" description="Current page number"%>
<%@attribute name="ariaLabel" required="false" description="Aria labed used if this item is an icon"%>

<c:url var="encUrl" value='${url}${fn:contains(url, "?") ? "&" : "?"}page=${page}' />
<c:set var="classList" value='page-item ${page == current ? "active" : ""}' />
<c:set var="ariaCurrent" value='${page == current ? "page" : ""}' />

<li
  <c:if test="${!empty classList}">
    class="${classList}"
  </c:if>
  <c:if test="${!empty ariaCurrent}">
    aria-current="${ariaCurrent}"
  </c:if>
><a
    href="${encUrl}"
    class="page-link"
    <c:if test="${!empty ariaLabel}">
      aria-label="${ariaLabel}"
    </c:if>
  ><span
      <c:if test="${!empty ariaLabel}">
        aria-hidden="true"
      </c:if>
    ><jsp:doBody/></span
  ></a
></li>
