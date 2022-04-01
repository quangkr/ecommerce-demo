<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>

<head>
  <title>Login | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <div class="container-xxl py-5 px-4 d-flex justify-content-center flex-grow-0">

    <div class="card" style="min-width: min(100%, 350px)">
      <div class="card-body">
        <h1 class="card-title my-3 fs-3 text-center">Login</h1>

        <my:form url="/login" method="POST" cssClass="my-3">
          <div class="form-floating mb-3">
            <input
              id="form-username"
              class="form-control ${param.error != null ? 'is-invalid' : '' }"
              type="text"
              name="username"
              placeholder="Email"
            />
            <label for="form-username" class="form-label">Email</label>
          </div>
          <div class="form-floating mb-3">
            <input
              id="form-password"
              class="form-control ${param.error != null ? 'is-invalid' : '' }"
              type="password"
              name="password"
              placeholder="Password"
            />
            <label for="form-password" class="form-label">Password</label>
            <div class="mb-3 invalid-feedback">Invalid username or password</div>
          </div>
          <div class="mt-3 d-flex justify-content-between">
            <label class="form-check-label">
              <input class="form-check-input" type="checkbox" name="remember-me" />
              Remember me
            </label>
            <button class="btn btn-primary" type="submit">Submit</button>
          </div>
        </my:form>
      </div>
    </div>

  </div>

</body>
</html>
