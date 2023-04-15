<%-- 
    Document   : propmtDonationPicturesAdd
    Created on : 04 16, 23, 3:07:04 AM
    Author     : Angelo Richter Dela Cruz
--%>

<%@ page import="java.util.*" %>
<%@ page import="assetmgt.DonationManager" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Donation Picture</title>
</head>
<body>
    <h1>Add Donation Picture</h1>
    
    <%
        DonationManager donationManager = new DonationManager();
        ArrayList<Integer> donationIDs = donationManager.getDonationIDs();
    %>
    
    <form action="verifyDonationPicturesAdd.jsp" method="post">
        
        <label for="donationId">Donation ID:</label>
        <select id="donationId" name="donationId" required>
          <% for (Integer IDs : donationIDs) { %>
            <option value="<%= IDs %>"><%= IDs %></option>
          <% } %>
        </select>
        </br>
        
        <label for="pictureFile">Picture File:</label>
        <input type="text" id="pictureFile" name="pictureFile" required><br>
      
        
        <button type="submit">Submit</button>
    </form>
</body>
</html>
