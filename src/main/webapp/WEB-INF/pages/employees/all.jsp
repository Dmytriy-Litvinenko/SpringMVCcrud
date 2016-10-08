<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table width="600px">
    <tr>
        <td><b>Name</b></td>
        <td><b>Surname</b></td>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.firstName}</td>
            <td>${employee.secondName}</td>
            <td><a href="/empAdd?id=${employee.id}">Edit</a> |
                <a href="/employeeDelete?id=${employee.id}">Delete</a>
                <%--|a href="/emp?id=${employee.id}">Employees</a<?id=${department_id}--%>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <%--form:form method="post" action="/empAdd">
                <input type="hidden" name="id" value=${department_id}>
                <input type="submit" value="Add new employee">
            </form:form--%>
            <a href="/empAdd?department_id=${department_id}">Add new employee</a>
        </td>
    </tr>
</table>
</body>
</html>
