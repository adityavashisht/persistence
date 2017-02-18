<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>v

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="https://code.jquery.com/jquery-3.1.1.min.js" type="text/javascript"></script>
</head>
<body>

<h1>Welcome - View or add a person</h1>


<form:form modelAttribute="personForm" id="personForm" method="post">
    <form:hidden path="person.id"/>
    <form:input path="person.firstName"/>
    <form:input path="person.lastName"/>

    <input type="submit" value="Save"/>
</form:form>



<table>
    <tbody id="personRows">

    </tbody>

</table>

<script>

    $(function () {
        var URL = '<spring:url value="/table/view/all"/>';

        $.ajax({
            type: "POST",
            url: URL,
            dataType:'json',

            success: function (data) {
                alert(data);

            },
            error: function(data) {
            }
        });
    });

</script>

</body>
</html>
