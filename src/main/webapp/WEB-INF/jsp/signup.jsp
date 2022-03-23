<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
  <title>Sign up | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <h1>Signup page</h1>

  <form:form action="${root}/signup" method="POST" modelAttribute="user">
    <div class="form-floating mt-3">
      <form:input path="email" type="email" id="form-email" placeholder="Email" cssClass="form-control" />
      <form:label path="email" for="form-email">Email</form:label>
    </div>
    <div class="form-floating mt-3">
      <form:password path="password" id="form-password" placeholder="Password" cssClass="form-control" />
      <form:label path="password" for="form-password">Password</form:label>
    </div>
    <div class="form-floating mt-3">
      <form:input path="displayName" type="text" id="form-display-name" placeholder="Display name" cssClass="form-control" />
      <form:label path="displayName" for="form-display-name">Display name</form:label>
    </div>
    <form:errors path="*" />
    <form:button type="submit">Submit</form:button>
  </form:form>

</body>
</html>
