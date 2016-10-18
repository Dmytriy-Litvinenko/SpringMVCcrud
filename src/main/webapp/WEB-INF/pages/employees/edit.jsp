<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="/empSave">
    <table>
        <tr>
            <td>FirstName:</td>
            <td><input type="text" name="firstName" value="${employee.firstName}"/></td>
        </tr>
        <tr>
            <td>SecondName:</td>
            <td><input type="text" name="secondName" value="${employee.secondName}"/></td>
        </tr>
        <tr>
            <td>
                <input type="hidden" name="department_id" value="${department.id}"/>
                <input type="hidden" name="employee_id" value="${employee.id}"/>
                <input type="submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
