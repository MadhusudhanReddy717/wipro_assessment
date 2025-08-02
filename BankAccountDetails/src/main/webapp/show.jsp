<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="ba" class="com.bank.BankAccount" scope="session" />
<jsp:setProperty name="ba" property="*" />

<%
  String accType = request.getParameter("accType");
  session.setAttribute("type", accType);
  response.sendRedirect("display.jsp");
%>
