<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<html>
<head>
    <title>Books Store Application</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 20px;
        }
        
        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
            font-size: 32px;
        }
        
        .nav-links {
            text-align: center;
            margin-bottom: 30px;
        }
        
        .nav-links a {
            text-decoration: underline;
            color: #6f42c1;
            margin: 0 20px;
            font-size: 18px;
            font-weight: bold;
        }
        
        .nav-links a:hover {
            color: #5a32a3;
        }
        
        .content-container {
            max-width: 1200px;
            margin: 0 auto;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            overflow: hidden;
        }
        
        .section-title {
            text-align: center;
            color: #333;
            margin: 30px 0;
            font-size: 24px;
            font-weight: bold;
        }
        
        .table-wrapper {
            padding: 0 30px 30px 30px;
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
            font-size: 14px;
            margin: 0 auto;
        }
        
        table, th, td {
            border: 1px solid #333;
        }
        
        th {
            background-color: #f8f9fa;
            padding: 12px 8px;
            text-align: center;
            font-weight: bold;
            color: #333;
        }
        
        td {
            padding: 10px 8px;
            text-align: center;
        }
        
        tr:nth-child(even) {
            background-color: #f8f9fa;
        }
        
        tr:hover {
            background-color: #e9ecef;
        }
        
        .id-column {
            width: 8%;
        }
        
        .title-column {
            width: 35%;
            text-align: left !important;
            padding-left: 15px !important;
        }
        
        .author-column {
            width: 30%;
            text-align: left !important;
            padding-left: 15px !important;
        }
        
        .price-column {
            width: 12%;
        }
        
        .actions-column {
            width: 15%;
        }
        
        .action-link {
            text-decoration: underline;
            color: #6f42c1;
            margin: 0 5px;
            font-size: 13px;
        }
        
        .action-link:hover {
            color: #5a32a3;
        }
        
        .edit-link {
            color: #6f42c1;
        }
        
        .delete-link {
            color: #6f42c1;
        }
        
        .no-books {
            text-align: center;
            padding: 50px;
            color: #666;
            font-size: 18px;
        }
        
        /* Exact styling to match your screenshot */
        .nav-links a {
            color: #6f42c1;
            text-decoration: underline;
        }
        
        h1 {
            font-size: 28px;
            font-weight: bold;
        }
        
        .section-title {
            font-size: 22px;
            margin: 20px 0;
        }
    </style>
</head>
<body>
    <h1>Books Management</h1>
    
    <div class="nav-links">
        <a href="<c:url value='/' />">Add New Book</a>
        <a href="<c:url value='/list' />">List All Books</a>
    </div>

    <div class="content-container">
        <h2 class="section-title">List of Books</h2>
        
        <div class="table-wrapper">
            <c:if test="${not empty listBook}">
                <table>
                    <thead>
                        <tr>
                            <th class="id-column">ID</th>
                            <th class="title-column">Title</th>
                            <th class="author-column">Author</th>
                            <th class="price-column">Price</th>
                            <th class="actions-column">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="book" items="${listBook}">
                            <tr>
                                <td class="id-column"><c:out value="${book.id}" /></td>
                                <td class="title-column"><c:out value="${book.title}" /></td>
                                <td class="author-column"><c:out value="${book.author}" /></td>
                                <td class="price-column"><c:out value="${book.price}" /></td>
                                <td class="actions-column">
                                    <a href="edit?id=<c:out value='${book.id}' />" class="action-link edit-link">Edit</a>
                                    <a href="javascript:void(0);" onclick="confirmDelete(${book.id}, '${book.title}')" class="action-link delete-link">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            
            <c:if test="${empty listBook}">
                <div class="no-books">
                    <h3>No books found!</h3>
                    <p>Start by adding your first book.</p>
                    <a href="<c:url value='/' />" class="action-link">Add New Book</a>
                </div>
            </c:if>
        </div>
    </div>

    <!-- Confirmation Dialog -->
    <div id="confirmOverlay" style="display: none; position: fixed; top: 0; left: 0; width: 100%; height: 100%; background-color: rgba(0,0,0,0.5); z-index: 1000;">
        <div style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); background-color: white; padding: 30px; border-radius: 10px; text-align: center; box-shadow: 0 4px 20px rgba(0,0,0,0.3);">
            <h3 style="margin-top: 0; color: #333;">Confirm Delete</h3>
            <p id="confirmMessage">Are you sure you want to delete this book?</p>
            <div>
                <button onclick="proceedDelete()" style="padding: 10px 20px; margin: 5px; background-color: #dc3545; color: white; border: none; border-radius: 5px; cursor: pointer;">Yes, Delete</button>
                <button onclick="cancelDelete()" style="padding: 10px 20px; margin: 5px; background-color: #6c757d; color: white; border: none; border-radius: 5px; cursor: pointer;">Cancel</button>
            </div>
        </div>
    </div>

    <script>
        let deleteUrl = '';
        
        function confirmDelete(bookId, bookTitle) {
            deleteUrl = 'delete?id=' + bookId;
            document.getElementById('confirmMessage').innerHTML = 
                'Are you sure you want to delete:<br><strong>"' + bookTitle + '"</strong>?';
            document.getElementById('confirmOverlay').style.display = 'block';
        }
        
        function proceedDelete() {
            window.location.href = deleteUrl;
        }
        
        function cancelDelete() {
            document.getElementById('confirmOverlay').style.display = 'none';
            deleteUrl = '';
        }
        
        // Close dialog when clicking outside
        document.getElementById('confirmOverlay').addEventListener('click', function(e) {
            if (e.target === this) {
                cancelDelete();
            }
        });
        
        // Add keyboard support
        document.addEventListener('keydown', function(e) {
            if (e.key === 'Escape') {
                cancelDelete();
            }
        });
    </script>
</body>
</html>