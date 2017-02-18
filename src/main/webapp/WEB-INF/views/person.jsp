<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Welcome - View or add a person</h1>


<form:form modelAttribute="personForm" id="personForm" method="post">
    <form:hidden path="person.id"/>
    <form:input path="person.firstName"/>
    <form:input path="person.lastName"/>

    <input type="submit" value="Save"/>
</form:form>


</body>
</html>
