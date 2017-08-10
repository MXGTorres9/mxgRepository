<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: green;">
    <table cellpadding=0 cellspacing=0 border="1px solid red;" style="width:50%;">
        <thead>
            <tr>
                <th>ID</th>
                <th>UserName</th>
                <th>Name</th>
                <th>Age</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${userlist }" var="user">
	            <tr>
	                <td>${user.id }</td>
	                <td>${user.userName }</td>
	                <td>${user.name }</td>
	                <td>${user.age }</td>
	            </tr>
            </c:forEach>
            
        </tbody>
    </table>

    
</body>
</html>