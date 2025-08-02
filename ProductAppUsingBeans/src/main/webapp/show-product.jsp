<%@ page import="com.product.bean.Product" %>
<jsp:useBean id="p" class="com.product.bean.Product" scope="request" />
<jsp:setProperty name="p" property="*" />

<!DOCTYPE html>
<html>
<head><title>Product Info</title></head>
<body>
    <h2>Product Details</h2>
    ID: <jsp:getProperty name="p" property="id" /><br>
    Name: <jsp:getProperty name="p" property="name" /><br>
    Price: <jsp:getProperty name="p" property="price" /><br>
    Quantity: <jsp:getProperty name="p" property="qty" /><br>
</body>
</html>
