<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="ba" class="com.bank.BankAccount" scope="session" />

<html>
<head><title>Account Info</title></head>
<body>
  <h2>Account Details</h2>
  Account No: ${ba.accNo} <br><br>
  Name: ${ba.name} <br><br>
  Balance: ${ba.balance} <br><br>
  Account Type: ${sessionScope.type} <br><br>
</body>
</html>
