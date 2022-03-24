<%@tag body-content="scriptless" dynamic-attributes="attrs" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="url" required="true" description="The absolute (to the webapp) path"%>
<%@attribute name="cssClass" required="false" description="Css classes to be included"%>

<c:url var="encUrl" value='${url}' />

<a
  href="${encUrl}"
  <c:if test="${!empty cssClass}">
    class="${cssClass}"
  </c:if>
  <c:forEach var="attr" items="${attrs}">
    <c:if test='${(attr.key != "class") && (attr.key != "href")}'>
      ${attr.key}="${attr.value}"
    </c:if>
  </c:forEach>
><jsp:doBody/></a>
