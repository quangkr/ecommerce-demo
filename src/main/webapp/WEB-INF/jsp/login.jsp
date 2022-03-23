<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>

<head>
  <title>Login | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <h1>Login page</h1>

  <form action="${root}/login" method="POST">
    <sec:csrfInput />
    <div>
      <label>Username <input type="text" name="username" /></label>
    </div>
    <div>
      <label>Password <input type="password" name="password" /></label>
    </div>
    <button type="submit">Submit</button>
  </form>

</body>
</html>
