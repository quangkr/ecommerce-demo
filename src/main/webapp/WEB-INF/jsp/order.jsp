<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
  <title>Orders | Ecommerce demo</title>
  <%@ include file="/WEB-INF/jspf/meta.jspf"%>
</head>

<body>

  <%@ include file="/WEB-INF/jspf/header.jspf"%>

  <div class="bg-light" style="min-height: calc(100vh - 3rem)">
    <div class="container-xxl py-5 px-0 px-md-4">
      <c:if test="${empty orders}">
        <div class="mt-4 text-center fs-4">You have no orders!</div>
      </c:if>
      <c:forEach var="o" varStatus="s" items="${orders}">
        <div class="mb-2 mb-md-5 px-3 pb-4 bg-white">
          <div class="d-flex flex-column py-4 border-bottom">
            <h2 class="fs-4">
              <c:set var="formattedDate"><fmt:formatDate pattern="dd-MM-yyyy" value="${o.createdAt}"/></c:set>
              <c:out value="#${s.count}: Ordered on ${formattedDate}"/>
            </h2>
          </div>
          <div class="d-flex flex-column">
            <c:forEach var="i" items="${o.orderItems}">
              <div>
                <my:checkout-item
                  name="${i.product.name}"
                  url="/product/${i.product.id}"
                  imgSrc="${i.product.thumbnailUrl}"
                  price="${i.product.price}"
                  quantity="${i.quantity}"
                />
              </div>
            </c:forEach>
          </div>
          <div class="d-flex flex-column">
            <div class="pt-3 d-flex justify-content-end">
              <span>
                Total:
                <span class="fw-bold"><fmt:formatNumber type="number" value="${o.grandTotal}" /> đ</span>
              </span>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>

</body>
</html>
