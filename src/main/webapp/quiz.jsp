<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FIRST-ACER-Desktop
  Date: 10/27/2023
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<h1 class="text-3xl underline">Quiz</h1>
    <form action="QuizController" method="POST" class="p-6">
        <h2 class="text-xl">${currentQuestion.title}</h2>
        <ul class="flex flex-col justify-center">
            <c:forEach var="option" items="${currentQuestion.options}" varStatus="status">
                <li>
                    <input type="radio" id="${status.index}" name="answer" value="${status.index}"/>
                    <label for="${status.index}">${option}</label>
                </li>
            </c:forEach>
        </ul>
        <input type="submit" value="send" class="border border-1 py-[.5rem] px-[.75rem] cursor-pointer">
    </form>
</body>
</html>
