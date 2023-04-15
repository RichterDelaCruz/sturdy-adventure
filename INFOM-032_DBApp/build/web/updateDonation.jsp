<%-- 
    Document   : updateDonation
    Created on : 04 16, 23, 12:25:01 AM
    Author     : ccslearner
--%>

<%@ page import="java.util.*" %>
<%@ page import="assetmgt.DonationManager" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Donation</title>
</head>
<body>
    <h1>Update Donation</h1>
    
    <%
        DonationManager donationManager = new DonationManager();
        ArrayList<Integer> donationIds = donationManager.getDonationIds();
        ArrayList<Integer> acceptHoid = donationManager.getOfficerHoids();
        ArrayList<Integer> approvalHoid = donationManager.getPresidentHoids();
        ArrayList<String> donorName = donationManager.getDistinctDonorNames();
        ArrayList<String> acceptPosition = donationManager.getOfficerPositions();
        ArrayList<String> approvalPosition = donationManager.getPresidentPositions();
    %>
    
    <form action="donationUpdating.jsp" method="post">
        <label for="donationId">Donation ID:</label>
        <select id="donationId" name="donationId" required>
          <% for (Integer id : donationIds) { %>
            <option value="<%= id %>"><%= id %></option>
          <% } %>
        </select>
        </br>
        
        <label for="donorName">Donor Name:</label>
        <select id="donorName" name="donorName" required>
          <% for (String name : donorName) { %>
            <option value="<%= name %>"><%= name %></option>
          <% } %>
        </select>
        </br>

        <label for="donationFormFile">Donation Form File:</label>
        <input type="text" id="donationFormFile" name="donationFormFile" required><br>

        <label for="donationDate">Donation Date:</label>
        <input type="date" id="donationDate" name="donationDate" required><br>

        <label for="acceptHoid">Accepted HOID:</label>
        <select id="acceptHoid" name="acceptHoid" required>
          <% for (Integer hoid : acceptHoid) { %>
            <option value="<%= hoid %>"><%= hoid %></option>
          <% } %>
        </select>
        </br>

        <label for="acceptPosition">Accepted Position:</label>
        <select id="acceptPosition" name="acceptPosition" required>
          <% for (String position : acceptPosition) { %>
            <option value="<%= position %>"><%= position %></option>
          <% } %>
        </select>
        </br>

        <label for="acceptElectionDate">Accepted Election Date:</label>
        <input type="date" id="acceptElectionDate" name="acceptElectionDate" required><br>
        
        <label for="approvalHoid">Approval HOID:</label>
        <select id="approvalHoid" name="approvalHoid">
          <option value="">-- Select --</option>
          <% for (Integer hoid : approvalHoid) { %>
            <option value="<%= hoid %>"><%= hoid %></option>
          <% } %>
        </select>
        <br>
        
        <label for="approvalPosition">Approval Position:</label>    
        <select id="approvalPosition" name="approvalPosition">
          <option value="">-- Select --</option>
          <% for (String position : approvalPosition) { %>
            <option value="<%= position %>"><%= position %></option>
          <% } %>
        </select>
        <br>
        
        <label for="acceptElectionDate">Approval Election Date:</label>
        <input type="date" id="approvalElectionDate" name="approvalElectionDate" ><br>
        
        <button type="submit">Submit</button>
    </form>
</body>
</html>
