<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<%@ include file="/WEB-INF/jspf/meta.jspf"%>

<style>
form label {
  display: block;
}
</style>
</head>
<body>

  <h1>Signup page</h1>

  <form:form action="signup" method="POST" modelAttribute="user">
    <div class="form-floating mt-3">
      <form:input path="email" id="form-email" cssClass="form-control"
        type="text" />
      <form:label for="form-email" path="email">Email</form:label>
      <form:password path="password" id="form-password"
        cssClass="form-control" />
      <form:label for="form-password" path="password">Password</form:label>
      <form:input path="displayName" id="form-display-name"
        cssClass="form-control" type="text" />
      <form:label for="form-display-name" path="displayName">Display name</form:label>
      <form:errors path="*" />
      <form:button type="submit">Submit</form:button>
    </div>
  </form:form>

</body>
</html>