<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
    <style>
        /*body { background-color: #eee; font: helvetica; }
        #container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; }
        label {width: 150px; display:inline-block;}
        input { display:inline-block; margin-right: 10px; }*/
        form {line-height: 160%; }
        .error { color: red; font-size: 0.9em; font-weight: bold; }
    </style>
</head>
<body>
<form:form method="post"  commandName="employee" >
    <table>
        <tr>
            <td>FirstName:</td>
            <td><form:input  path="firstName" /></td>
            <td><form:errors path="firstName" cssClass="error"/></td>
                <%--form:input path="firstName" action="/empSaveAfterValidation" /--%>
        </tr>
        <tr>
            <td>SecondName:</td>
            <td><form:input path="secondName"/></td>
            <td><form:errors path="secondName" cssClass="error"/></td>
            <td></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="email"/></td>
            <td><form:errors path="email" cssClass="error"/></td>
            <td></td>
        </tr>
        <tr>
            <td>
                <input type="hidden" name="department_id" value="${department_id}"/>
                <input type="submit" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
