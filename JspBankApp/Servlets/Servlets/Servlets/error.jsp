<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %%> 
<!DOCTYPE html> 
<html> 
<head> 
    <title>Error - JSP Bank App</title> 
    <style> 
        body { 
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
            background: linear-gradient(135deg, #ff6b6b 0%%, #ee5a24 100%%); 
            min-height: 100vh; 
            display: flex; 
            align-items: center; 
            justify-content: center; 
            margin: 0; 
        } 
        .error-container { 
            background: white; 
            padding: 40px; 
            border-radius: 15px; 
            text-align: center; 
            box-shadow: 0 15px 35px rgba(0,0,0,0.1); 
            max-width: 500px; 
        } 
        .error-icon { 
            font-size: 64px; 
            margin-bottom: 20px; 
        } 
        .error-title { 
            color: #e74c3c; 
            font-size: 28px; 
            margin-bottom: 15px; 
        } 
        .error-message { 
            color: #666; 
            margin-bottom: 30px; 
            line-height: 1.6; 
        } 
        .btn { 
            background: linear-gradient(135deg, #667eea 0%%, #764ba2 100%%); 
            color: white; 
            padding: 12px 25px; 
            text-decoration: none; 
            border-radius: 8px; 
            font-weight: 600; 
            transition: transform 0.2s ease; 
        } 
        .btn:hover { 
            transform: translateY(-2px); 
        } 
    </style> 
</head> 
<body> 
    <div class="error-container"> 
        <div class="error-icon">??</div> 
        <h1 class="error-title">Oops! Something went wrong</h1> 
        <div class="error-message"> 
            <p>We encountered an error while processing your request.</p> 
            <p><strong>Error Details:</strong> <%%= exception != null ? exception.getMessage() : "Unknown error" %%></p> 
        </div> 
        <a href="index.html" class="btn">?? Return to Home</a> 
    </div> 
</body> 
</html> 
