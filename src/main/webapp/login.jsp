<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="model.Users"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%--
<%! %> : The dung de khai bao bien
<% %> : The dung de xu ly logic code( da nang)
<%= %>: Xuat gia tri cua bien ra man hinh
--%>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<%!
    int count = 0;
    Users users = new Users();
%>
<%
    //int kq=(int) request.getAttribute("kq");

    count++;
    users.setUsername("nguyenvana@gmail.com");
    users.setPassword("123456");
    String show = (count %2 ==0)?users.getUsername()+ " - " + users.getPassword() : "";

%>
<div class="container">
  <div class="row mt-5">
    <div class="col-md-5 m-auto mt-5">
      <h3 class="text-center">ĐĂNG NHẬP HỆ THỐNG</h3>
      <div class="p-4 border mt-4">
      <% String contextPath=request.getContextPath(); %>
     <%-- <% String msg=(String) request.getAttribute("msg");%>
      <%=msg%>
      --%>
      <h3>${msg}</h3>
      <b>${user.username}</b>
      <c:out value="${msg}"/>
      <c:if test="${user.password=='123'}">
      <!-- noi dung thoa dk if -->
      Mat khau cua ban là ${user.getPassword()}
      </c:if>
      <c:forEach var="item" items="${list}">
      ${item}
      </c:forEach>
        <form action="<%=contextPath%>/login" method="post">
            <div class="form-group">
              <label>Email</label>
              <input type="email" class="form-control" name="username" value="${username}">
            </div>
            <div class="form-group">
              <label>Mật khẩu</label>
              <input type="password" class="form-control" name="password" value="${password}">
            </div>
            <div class="form-group">
                         <label>
                           <input type="checkbox" id="rememberMe" name="remember">
                           Ghi nhớ mật khẩu
                         </label>
                         </div>
            <button type="submit" class="btn btn-primary">Đăng nhập</button>

          </form>
      </div>
      </div>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
