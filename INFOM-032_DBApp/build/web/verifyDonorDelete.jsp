<%--
    Document   : verifyDonorDelete
    Created on : 04 15, 23, 11:02:45 PM
    Author     : Angelo Richter Dela Cruz
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="assetmgt.DonationManager" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deleting Donor</title>
    </head>
    <body> 
        <form action="index.html">
        <%
        if(request.getMethod().equals("POST")) {
            DonationManager donation = new DonationManager();
            
            String donorName = request.getParameter("donorName");
            
            int status = donation.deleteDonor(donorName);

            if (status == 1) {
    %>
            <h1>Deleting Donor Successful</h1>
    <%  
            } else { 
    %>
            <h1>Deleting Donor  Failed</h1>
    <%  
            }
        } 
    %>

        <input type="submit" value="Back to Main Menu">
        </form>
    </body>
</html>
