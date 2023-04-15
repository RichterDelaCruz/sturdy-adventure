<%-- 
    Document   : propmtUpdateDonor
    Created on : 04 16, 23, 3:39:46 AM
    Author     : ccslearner
--%>

<%@ page import="java.util.*" %>
<%@ page import="assetmgt.DonationManager" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Donor</title>
</head>
<body>
    <h1>Delete Donor</h1>
    
    <%
    DonationManager donationManager = new DonationManager();
    ArrayList<String> donorName = donationManager.getDistinctDonorNames();
    %>
    
    <form action="verifyDonorDelete.jsp" method="post">
        <label for="donorName">Donor Name:</label>
        <select id="donorName" name="donorName" required>
          <% for (String name : donorName) { %>
            <option value="<%= name %>"><%= name %></option>
          <% } %>
        </select>
        </br>
        
        <button type="submit">Submit</button>
    </form>
</body>
</html>

