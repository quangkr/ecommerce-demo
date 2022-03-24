<%@tag body-content="scriptless" dynamic-attributes="attrs" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@attribute name="url" required="true" description="The absolute (to the webapp) path"%>

<c:url var="encUrl" value='${url}' />

<form
  action="${encUrl}"
  <c:if test='${attr.key != "action"}'>
    <c:forEach var="attr" items="${attrs}">
      ${attr.key}="${attr.value}"
    </c:forEach>
  </c:if>
>
  <sec:csrfInput/>
  <jsp:doBody/>
</form>
