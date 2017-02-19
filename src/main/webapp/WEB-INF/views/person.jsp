<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="https://code.jquery.com/jquery-3.1.1.min.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/2.3.0/mustache.min.js"></script>

</head>
<body>

<h1>Welcome - View or add a person</h1>


<script id="personRowDataTemplate" type="x-tmpl-mustache">

    {{#data}}
      <tr>
        <td>{{firstName}}</td>
        <td>{{lastName}}</td>

      </tr>
    {{/data}}




</script>

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
            contentType: "application/x-www-form-urlencoded",
            dataType: 'json',
            success: function (data) {

                var rowTemplate = $("#personRowDataTemplate").html();
                var renderedMarkup = Mustache.to_html(rowTemplate, data);
                $("#personRows").empty();
                $("#personRows").html(renderedMarkup);


            },
            error: function (data) {
            }
        });
    });

</script>

</body>
</html>
