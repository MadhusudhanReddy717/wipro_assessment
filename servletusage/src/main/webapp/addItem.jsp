<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Item to Cart</title>
</head>
<body>
    <h2>Add Item to Cart</h2>

    <!-- Form to add item -->
    <form action="cart" method="post">
        Item name: <input type="text" name="itemName" required /><br><br>
        Quantity: <input type="number" name="quantity" min="1" required /><br><br>
        <input type="submit" name="action" value="Add Item" />
    </form>

    <br>

    <!-- Separate form to view cart (no required fields) -->
    <form action="cart" method="post">
        <input type="submit" name="action" value="View Cart" />
    </form>
</body>
</html>
