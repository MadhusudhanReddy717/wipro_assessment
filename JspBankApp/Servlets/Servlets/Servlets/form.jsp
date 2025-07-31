<%@ page contentType="text/html;charset=UTF-8" language="java" %%> 
<jsp:useBean id="account" class="beans.Account" scope="request"/> 
 
<%% 
    try { 
        String accNo = request.getParameter("accNo"); 
        String name = request.getParameter("name"); 
        String balanceStr = request.getParameter("balance"); 
 
        double balance = 0.0; 
        if (balanceStr != null && !balanceStr.trim().isEmpty()) { 
            balance = Double.parseDouble(balanceStr); 
        } 
 
        account.setAccountNo(accNo); 
        account.setName(name); 
        account.setBalance(balance); 
 
        String accountType; 
        String accountIcon; 
        if (balance >= 50000) { 
            accountType = "[DIAMOND] Premium Savings"; 
            accountIcon = "premium"; 
        } else if (balance >= 10000) { 
            accountType = "[GOLD] Gold Savings"; 
            accountIcon = "gold"; 
        } else { 
            accountType = "[STAR] Regular Savings"; 
            accountIcon = "regular"; 
        } 
 
        session.setAttribute("accountType", accountType); 
        session.setAttribute("accountIcon", accountIcon); 
        session.setAttribute("processingTime", new java.util.Date().toString()); 
 
        request.getRequestDispatcher("display.jsp").forward(request, response); 
 
    } catch (Exception e) { 
        out.println("^<h2^>Error processing form: " + e.getMessage() + "^</h2^>"); 
        out.println("^<a href='index.html'^>Go Back^</a^>"); 
    } 
%%> 
