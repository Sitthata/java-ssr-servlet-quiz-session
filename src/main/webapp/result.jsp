<%--
  Created by IntelliJ IDEA.
  User: FIRST-ACER-Desktop
  Date: 10/27/2023
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Title</title>
</head>
<body>
    <h2>Good! This is your score</h2>
    <p>${correctAnswer}/${totalQuestion}</p>
    <form action="ResetQuiz" method="POST">
        <input type="submit" value="reset">
    </form>
</body>
</html>
