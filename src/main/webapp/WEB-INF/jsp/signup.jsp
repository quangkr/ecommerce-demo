<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
  <title>Sign up | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <h1>Signup page</h1>

  <c:url value="/signup" var="signupUrl" />
  <form:form action="${signupUrl}" method="POST" modelAttribute="user" novalidate="true">
    <spring:bind path="email">
      <div class="form-floating mt-3">
        <form:input
          path="email"
          type="email"
          id="form-email"
          placeholder="Email"
          cssClass="form-control ${status.error ? 'is-invalid' : ''}"
        />
        <form:label path="email" for="form-email">Email</form:label>
        <form:errors path="email" cssClass="invalid-feedback" element="div" />
      </div>
    </spring:bind>
    <spring:bind path="password">
      <div class="form-floating mt-3">
        <form:password
          path="password"
          id="form-password"
          placeholder="Password"
          cssClass="form-control ${status.error ? 'is-invalid' : ''}"
        />
        <form:label path="password" for="form-password">Password</form:label>
        <form:errors path="password" cssClass="invalid-feedback" element="div" />
      </div>
    </spring:bind>
    <spring:bind path="displayName">
      <div class="form-floating mt-3">
        <form:input
          path="displayName"
          type="text"
          id="form-display-name"
          placeholder="Display name"
          cssClass="form-control ${status.error ? 'is-invalid' : ''}"
        />
        <form:label path="displayName" for="form-display-name">Display name</form:label>
        <form:errors path="displayName" cssClass="invalid-feedback" element="div" />
      </div>
    </spring:bind>
    <form:button type="submit">Submit</form:button>
  </form:form>

</body>
</html>
