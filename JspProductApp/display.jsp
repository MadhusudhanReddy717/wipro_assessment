<%@ page import="beans.Product" %>
<jsp:useBean id="product" class="beans.Product" scope="session" />
<jsp:setProperty name="product" property="*" />

<!DOCTYPE html>
<html>
<head><title>Product Details</title></head>
<body>
    <h2>Product Details Submitted:</h2>
    ID: <jsp:getProperty name="product" property="id" /><br>
    Name: <jsp:getProperty name="product" property="name" /><br>
    Price: <jsp:getProperty name="product" property="price" /><br>
    Quantity: <jsp:getProperty name="product" property="quantity" /><br>
</body>
</html>
