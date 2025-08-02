<%@ page contentType="text/htcml;charset=UTF-8" %>
<html>
<head><title>Bank Account Form</title></head>
<body>
  <h2>Enter Account Details</h2>
  <form action="show.jsp" method="post">
    Account No: <input type="text" name="accNo" /><br><br>
    Name: <input type="text" name="name" /><br><br>
    Balance: <input type="text" name="balance" /><br><br>
    Account Type:
    <select name="accType">
      <option value="Savings">Savings</option>
      <option value="Current">Current</option>
    </select><br><br>
    <input type="submit" value="Submit" />
  </form>
</body>
</html>
