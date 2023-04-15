<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Donor</title>
</head>
<body>
    <h1>Add Donor</h1>
    <form action="verifyDonorAdd.jsp" method="post">
        <label for="donorName">Donor Full Name:</label>
        <input type="text" id="donorName" name="donorName" required><br>
        
        <label for="address">Donor Address:</label>
        <input type="text" id="address" name="address" required><br>
        
        <button type="submit">Submit</button>
    </form>
</body>
</html>
