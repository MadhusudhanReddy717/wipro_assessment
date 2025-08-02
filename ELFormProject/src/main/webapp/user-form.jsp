<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>EL Form</title></head>
<body>
    <h2>User Information</h2>
    <form action="user" method="post">
        Name: <input type="text" name="name" /><br><br>
        Password: <input type="password" name="pass" /><br><br>
        Address:<br>
        <textarea name="addr" rows="3" cols="30"></textarea><br><br>
        
        Subscribe Newsletter:
        <input type="checkbox" name="news" value="true" /><br><br>
        
        Favorite Web Frameworks:<br>
        <input type="checkbox" name="fw" value="Spring MVC" />Spring MVC
        <input type="checkbox" name="fw" value="Struts 1" />Struts 1
        <input type="checkbox" name="fw" value="Struts 2" />Struts 2
        <input type="checkbox" name="fw" value="Apache Wicket" />Apache Wicket<br><br>
        
        Gender:<br>
        <input type="radio" name="gender" value="Male" />Male
        <input type="radio" name="gender" value="Female" />Female<br><br>

        Favorite Number:<br>
        <select name="num">
            <option>1</option><option>2</option><option>3</option><option>4</option>
        </select><br><br>

        <input type="submit" value="Submit" />
    </form>
</body>
</html>
