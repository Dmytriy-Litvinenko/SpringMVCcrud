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
            <td>
                <%--form method="post" action="/employeeDelete">
                    <input type="hidden" name="id" value=${employee.id}>
                    <input type="hidden" name="department_id" value=${department.id}>
                    <input type="submit" value="Delete">
                </form--%>
                <a href="/empAddAndValidate?employee_id=${employee.id}">Edit</a>
                |<a href="/employeeDelete?id=${employee.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <%--td colspan="5">
            <a href="/empAdd?department_id=${department_id}">Add new employee</a>
        </td--%>
            <%--form:form method="post" action="/empAdd">
                <input type="hidden" name="id" value=${department_id}>
                <input type="submit" value="Add new employee">
            </form:form--%>
        <td>
            <a href="/empAddAndValidate?department_id=${department_id}">Add and validate new employee</a>
        </td>
    </tr>
</table>
</body>
</html>
