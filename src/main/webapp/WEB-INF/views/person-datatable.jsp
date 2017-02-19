<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="https://code.jquery.com/jquery-3.1.1.min.js" type="text/javascript"></script>

    <script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js" type="text/javascript"></script>

    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css"/>


</head>
<body>

<h1>Person Datatable</h1>

<table id="personTable" class="display" width="100%" cellspacing="0">
    <thead>
    <tr>
        <th>First name</th>
        <th>Last name</th>

    </tr>
    </thead>
    <tbody>
    </tbody>
</table>


<script>

    $(function() {

        $("#personTable").dataTable({
            "serverSide": true,
            "processing" : true,
            ajax: {
                url: '<spring:url value="/datatable/ajax"/>',
                type: 'POST',
                "contentType": 'application/json',
                "dataType": "json",
                "data": function (d) {
                    return JSON.stringify(d);
                }
            },
            columns : [
                {data:"firstName"},
                {data:"lastName"}
            ]



        });
    });
</script>

</body>
</html>