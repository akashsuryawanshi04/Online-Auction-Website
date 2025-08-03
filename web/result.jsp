<!DOCTYPE html>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <h2>Result</h2>
    <% String message = (String) request.getAttribute("message"); %>
    <% if (message != null && !message.isEmpty()) { %>
        <p><%= message %></p>
    <% } else { %>
        <p>No message to display.</p>
    <% } %>
    <a href="myProduct.jsp">Go back to add another product</a>
</body>
</html>
