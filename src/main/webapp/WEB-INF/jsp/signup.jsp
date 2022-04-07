<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
  <title>Sign up | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <div class="container-xxl py-5 px-4 d-flex justify-content-center flex-grow-0">

    <c:url value="/signup" var="signupUrl" />
    <div class="card" style="min-width: min(100%, 400px); max-width: 400px">
      <div class="card-body">
        <h1 class="card-title my-3 fs-3 text-center">Sign up</h1>
        <form:form action="${signupUrl}" method="POST" modelAttribute="user" novalidate="true" cssClass="my-3">
          <div class="form-floating mt-3">
            <form:input
              path="email"
              type="email"
              id="form-email"
              placeholder="Email"
              cssClass="form-control"
              cssErrorClass="form-control is-invalid"
            />
            <form:label path="email" for="form-email">Email</form:label>
            <form:errors path="email" cssClass="invalid-feedback" element="div" />
          </div>
          <div class="form-floating mt-3">
            <form:password
              path="password"
              id="form-password"
              placeholder="Password"
              cssClass="form-control"
              cssErrorClass="form-control is-invalid"
            />
            <form:label path="password" for="form-password">Password</form:label>
            <form:errors path="password" cssClass="invalid-feedback" element="div" />
          </div>
          <div class="form-floating mt-3">
            <form:input
              path="displayName"
              type="text"
              id="form-display-name"
              placeholder="Display name"
              cssClass="form-control"
              cssErrorClass="form-control is-invalid"
            />
            <form:label path="displayName" for="form-display-name">Display name</form:label>
            <form:errors path="displayName" cssClass="invalid-feedback" element="div" />
          </div>
          <div class="mt-3 d-flex justify-content-end">
            <form:button class="btn btn-primary" type="submit">Submit</form:button>
          </div>
        </form:form>
      </div>
    </div>

  </div>

</body>
</html>
