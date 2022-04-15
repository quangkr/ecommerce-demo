<%@tag body-content="scriptless" dynamic-attributes="attrs" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="url" required="true" description="The absolute (to the webapp) path"%>
<%@attribute name="cssClass" required="false" description="Css classes to be included"%>
<%@attribute name="names" required="false" description="Parameter names"%>
<%@attribute name="values" required="false" description="Parameter values"%>

<c:set var="currentUrl" value='${requestScope["javax.servlet.forward.servlet_path"]}' />
<c:set var="isParamMatch" value="${true}"/>
<c:if test="${!empty names}">
  <c:forTokens items="${names}" delims="," var="pName" varStatus="nStatus">
    <c:forTokens items="${values}" delims="," var="pValue" varStatus="vStatus">
      <c:if test="${nStatus.count == vStatus.count && pValue != param[pName]}">
        <c:set var="isParamMatch" value="${false}"/>
      </c:if>
    </c:forTokens>
  </c:forTokens>
</c:if>

<c:url var="encUrl" value='${url}' />
<c:set var="classList" value='${cssClass} ${isParamMatch && (currentUrl == url) ? "active" : ""}' />
<c:set var="ariaCurrent" value='${isParamMatch && (currentUrl == url) ? "page" : ""}' />

<c:set var="finalUrl" value="${encUrl}" />
<c:if test="${!empty names}">
  <c:set var="finalUrl" value="${finalUrl}?" />
  <c:forTokens items="${names}" delims="," var="pName" varStatus="nStatus">
    <c:forTokens items="${values}" delims="," var="pValue" varStatus="vStatus">
      <c:if test="${nStatus.count == vStatus.count}">
        <c:set var="finalUrl" value="${finalUrl}${pName}=${pValue}"/>
      </c:if>
    </c:forTokens>
  </c:forTokens>
</c:if>

<a
  href="${finalUrl}"
  <c:if test="${!empty classList}">
    class="${classList}"
  </c:if>
  <c:if test="${!empty ariaCurrent}">
    aria-current="${ariaCurrent}"
  </c:if>
  <c:forEach var="attr" items="${attrs}">
    <c:if test='${(attr.key != "class") && (attr.key != "href")}'>
      ${attr.key}="${attr.value}"
    </c:if>
  </c:forEach>
><jsp:doBody/></a>
