<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Dashboard</title>
</head>
<body>

<h2>Dashboard</h2>

<a href="create-event">Create Event</a> |
<a href="logout">Logout</a>

<hr>

<h3>All Events</h3>

<table border="1">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Date</th>
    </tr>

    <c:forEach var="e" items="${events}">
        <tr>
            <td>${e.title}</td>
            <td>${e.description}</td>
            <td>${e.eventDate}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>