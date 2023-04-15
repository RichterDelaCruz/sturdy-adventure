<%-- 
    Document   : verifyDonorAdd
    Created on : 04 16, 23, 3:39:46 AM
    Author     : Angelo Richter Dela Cruz
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="assetmgt.DonationManager" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recording Donor</title>
    </head>
    <body> 
        <form action="index.html">
        <%
        if(request.getMethod().equals("POST")) {
            DonationManager donation = new DonationManager();
            
            String donorName = request.getParameter("donorName");
            String address = request.getParameter("address");
            
            int status = donation.addDonor(donorName, address);

            if (status == 1) {
    %>
            <h1>Adding Donor Successful</h1>
    <%  
            } else { 
    %>
            <h1>Adding Donor  Failed</h1>
    <%  
            }
        } 
    %>

        <input type="submit" value="Back to Main Menu">
        </form>
    </body>
</html>
