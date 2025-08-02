<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Books Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 50px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }
        .nav-links {
            text-align: center;
            margin-bottom: 40px;
        }
        .nav-links a {
            color: #4a90e2;
            text-decoration: underline;
            font-size: 18px;
            margin: 0 20px;
            font-weight: bold;
        }
        .nav-links a:hover {
            color: #357abd;
        }
        .form-section {
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 5px;
            border: 2px solid #ddd;
        }
        .form-section h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: inline-block;
            width: 80px;
            font-weight: bold;
            color: #333;
        }
        .form-group input[type="text"], .form-group input[type="number"] {
            width: 300px;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-group input[type="submit"] {
            background-color: #4a90e2;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }
        .form-group input[type="submit"]:hover {
            background-color: #357abd;
        }
        .button-container {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Books Management</h1>
        
        <div class="nav-links">
            <a href="new">Add New Book</a>
            <a href="list">List All Books</a>
        </div>
        
        <div class="form-section">
            <h2>Add New Book</h2>
            <form action="insert" method="post">
                <div class="form-group">
                    <label for="title">Title:</label>
                    <input type="text" id="title" name="title" required>
                </div>
                
                <div class="form-group">
                    <label for="author">Author:</label>
                    <input type="text" id="author" name="author" required>
                </div>
                
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="number" id="price" name="price" step="0.01" required>
                </div>
                
                <div class="button-container">
                    <input type="submit" value="Save">
                </div>
            </form>
        </div>
    </div>
</body>
</html>