<%@ page contentType="text/html;charset=UTF-8" language="java" %%> 
<jsp:useBean id="account" class="beans.Account" scope="request"/> 
 
<!DOCTYPE html> 
<html lang="en"> 
<head> 
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <title>Account Information - JSP Bank App</title> 
    <style> 
        * { margin: 0; padding: 0; box-sizing: border-box; } 
        body { 
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
            background: linear-gradient(135deg, #667eea 0%%, #764ba2 100%%); 
            min-height: 100vh; 
            padding: 20px; 
        } 
        .container { 
            max-width: 800px; 
            margin: 0 auto; 
            background: white; 
            border-radius: 20px; 
            overflow: hidden; 
            box-shadow: 0 20px 40px rgba(0,0,0,0.1); 
        } 
        .header { 
            background: linear-gradient(135deg, #2c3e50 0%%, #34495e 100%%); 
            color: white; 
            padding: 30px; 
            text-align: center; 
        } 
        .header h1 { font-size: 32px; margin-bottom: 10px; } 
        .header p { opacity: 0.9; font-size: 16px; } 
        .content { padding: 40px; } 
        .account-card { 
            background: linear-gradient(135deg, #f8f9fa 0%%, #e9ecef 100%%); 
            border-radius: 15px; 
            padding: 30px; 
            margin-bottom: 30px; 
            border-left: 5px solid #667eea; 
        } 
        .info-grid { 
            display: grid; 
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr)); 
            gap: 20px; 
            margin-bottom: 30px; 
        } 
        .info-item { 
            background: white; 
            padding: 20px; 
            border-radius: 10px; 
            box-shadow: 0 5px 15px rgba(0,0,0,0.08); 
            border-left: 4px solid #667eea; 
        } 
        .info-label { 
            font-size: 14px; 
            color: #6c757d; 
            font-weight: 600; 
            text-transform: uppercase; 
            letter-spacing: 0.5px; 
            margin-bottom: 8px; 
        } 
        .info-value { 
            font-size: 20px; 
            color: #2c3e50; 
            font-weight: 700; 
        } 
        .balance-status { 
            padding: 20px; 
            border-radius: 10px; 
            margin: 20px 0; 
            text-align: center; 
            font-weight: 600; 
            font-size: 16px; 
        } 
        .sufficient { 
            background: linear-gradient(135deg, #d4edda 0%%, #c3e6cb 100%%); 
            color: #155724; 
            border: 2px solid #28a745; 
        } 
        .insufficient { 
            background: linear-gradient(135deg, #f8d7da 0%%, #f5c6cb 100%%); 
            color: #721c24; 
            border: 2px solid #dc3545; 
        } 
        .premium { border-left-color: #9b59b6; } 
        .gold { border-left-color: #f39c12; } 
        .regular { border-left-color: #3498db; } 
        .el-demo { 
            background: #2c3e50; 
            color: white; 
            padding: 25px; 
            border-radius: 10px; 
            margin: 20px 0; 
        } 
        .el-demo h3 { 
            margin-bottom: 15px; 
            color: #ecf0f1; 
        } 
        .el-code { 
            background: #34495e; 
            padding: 10px 15px; 
            border-radius: 5px; 
            margin: 10px 0; 
            font-family: 'Courier New', monospace; 
            border-left: 3px solid #3498db; 
        } 
        .actions { 
            display: flex; 
            gap: 15px; 
            justify-content: center; 
            margin-top: 30px; 
        } 
        .btn { 
            padding: 12px 25px; 
            border: none; 
            border-radius: 8px; 
            text-decoration: none; 
            font-weight: 600; 
            cursor: pointer; 
            transition: all 0.3s ease; 
            display: inline-block; 
        } 
        .btn-primary { 
            background: linear-gradient(135deg, #667eea 0%%, #764ba2 100%%); 
            color: white; 
        } 
        .btn-secondary { 
            background: #6c757d; 
            color: white; 
        } 
        .btn:hover { 
            transform: translateY(-2px); 
            box-shadow: 0 8px 25px rgba(0,0,0,0.2); 
        } 
        .stats { 
            display: grid; 
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr)); 
            gap: 15px; 
            margin: 20px 0; 
        } 
        .stat-card { 
            background: white; 
            padding: 20px; 
            border-radius: 10px; 
            text-align: center; 
            box-shadow: 0 5px 15px rgba(0,0,0,0.08); 
        } 
        .stat-value { 
            font-size: 24px; 
            font-weight: bold; 
            color: #667eea; 
        } 
        .stat-label { 
            color: #6c757d; 
            font-size: 14px; 
            margin-top: 5px; 
        } 
    </style> 
</head> 
<body> 
    <div class="container"> 
        <div class="header"> 
            <h1>[BANK] Account Dashboard</h1> 
            <p>Your banking information processed successfully</p> 
        </div> 
        <div class="content"> 
            <div class="account-card"> 
                <h2 style="color: #2c3e50; margin-bottom: 20px;">[FILE] Account Details</h2> 
                <div class="info-grid"> 
                    <div class="info-item"> 
                        <div class="info-label">Account Number</div> 
                        <div class="info-value">${account.accountNo}</div> 
                    </div> 
                    <div class="info-item"> 
                        <div class="info-label">Account Holder</div> 
                        <div class="info-value">${account.name}</div> 
                    </div> 
                    <div class="info-item"> 
                        <div class="info-label">Current Balance</div> 
                        <div class="info-value">Rs.${account.balance}</div> 
                    </div> 
                    <div class="info-item ${sessionScope.accountIcon}"> 
                        <div class="info-label">Account Type</div> 
                        <div class="info-value">${sessionScope.accountType}</div> 
                    </div> 
                </div> 
            </div> 
            <div class="balance-status ${account.balance ^>= 1000 ? 'sufficient' : 'insufficient'}"> 
                <%% if (account.getBalance() >= 50000) { %%> 
                    [STAR] <strong>PREMIUM ACCOUNT STATUS</strong><br> 
                    Excellent! Your balance qualifies for all premium banking services. 
                <%% } else if (account.getBalance() >= 10000) { %%> 
                    [TROPHY] <strong>GOLD ACCOUNT STATUS</strong><br> 
                    Great! Your account has sufficient funds for most transactions. 
                <%% } else if (account.getBalance() >= 1000) { %%> 
                    [CHECK] <strong>SUFFICIENT BALANCE</strong><br> 
                    Good! Your account balance meets the minimum requirements. 
                <%% } else { %%> 
                    [WARNING] <strong>LOW BALANCE WARNING</strong><br> 
                    Please consider adding funds to avoid service limitations. 
                <%% } %%> 
            </div> 
            <div class="stats"> 
                <div class="stat-card"> 
                    <div class="stat-value">${account.balance >= 10000 ? 'Premium' : 'Standard'}</div> 
                    <div class="stat-label">Service Level</div> 
                </div> 
                <div class="stat-card"> 
                    <div class="stat-value">${account.balance >= 1000 ? 'Active' : 'Limited'}</div> 
                    <div class="stat-label">Account Status</div> 
                </div> 
                <div class="stat-card"> 
                    <div class="stat-value">${account.balance >= 50000 ? '0%%' : account.balance >= 10000 ? '2%%' : '5%%'}</div> 
                    <div class="stat-label">Service Fee</div> 
                </div> 
            </div> 
            <div class="el-demo"> 
                <h3>[TOOL] Expression Language (EL) Features Demo</h3> 
                <div class="el-code"> 
                    <strong>Property Access:</strong> \${account.accountNo} = ${account.accountNo} 
                </div> 
                <div class="el-code"> 
                    <strong>Session Scope:</strong> \${sessionScope.accountType} = ${sessionScope.accountType} 
                </div> 
                <div class="el-code"> 
                    <strong>Conditional Operator:</strong> \${account.balance >= 1000 ? 'Sufficient' : 'Insufficient'} = ${account.balance >= 1000 ? 'Sufficient' : 'Insufficient'} 
                </div> 
                <div class="el-code"> 
                    <strong>Nested Conditional:</strong> Balance Category = ${account.balance >= 50000 ? 'Premium' : account.balance >= 10000 ? 'Gold' : 'Regular'} 
                </div> 
            </div> 
            <div class="actions"> 
                <a href="index.html" class="btn btn-primary">[HOME] Add New Account</a> 
                <button onclick="window.print()" class="btn btn-secondary">[PRINT] Print Details</button> 
            </div> 
            <div style="text-align: center; margin-top: 30px; color: #6c757d; font-size: 12px;"> 
                <p>Session processed at: ${sessionScope.processingTime}</p> 
                <p>JSP Bank Application - Demonstrating EL & JavaBeans</p> 
            </div> 
        </div> 
    </div> 
</body> 
</html> 
