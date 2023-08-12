<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ page isELIgnored="false"%>
<%@ page import="model.Users"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<div class="container">
  <div class="row mt-5">
    <div class="col-md-5 m-auto mt-5">
      <h3 class="text-center">QUẢN LÝ SẢN PHẨM</h3>
      <div class="p-4 border mt-4">
      <% String contextPath=request.getContextPath(); %>

        <form action="<%=contextPath%>/product" method="post">
            <div class="form-group">
              <label>Tên sản phẩm:</label>
              <input type="text" class="form-control" name="productname">
            </div>
            <div class="form-group">
              <label>Số lượng:</label>
              <input type="number" min=1 class="form-control" name="soluong">
            </div>
            <div class="form-group">
              <label>Giá bán:</label>
              <input type="number" class="form-control" name="giaban">
            </div>
            <button type="submit" class="btn btn-primary">Lưu lại</button>

          </form>

      </div>
      </div>
  </div>
  <table border="1" style="width:100%">
                      <tr>
                          <th>STT</th>
                          <th>Tên sản phẩm</th>
                          <th>Số lượng</th>
                          <th>Giá bán</th>
                      </tr>
                      <c:forEach var = "item" items="${list}" varStatus="myIndex">
                          <tr>
                              <td>${myIndex.index+1}</td>
                              <td>${item.getProductName()}</td>
                              <td>${item.getSoluong()}</td>
                              <td>${item.getGiaban()}</td>
                          </tr>
                      </c:forEach>
                 </table>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
