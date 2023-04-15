<%-- 
    Document   : verifyDonationPictures
    Created on : 04 16, 23, 3:07:35 AM
    Author     : ccslearner
--%>
<%--
    Document   : donationProcessing
    Created on : 04 15, 23, 11:02:45 PM
    Author     : ccslearner
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="assetmgt.DonationManager" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Donation Picture</title>
    </head>
    <body> 
        <form action="index.html">
        <%
        if(request.getMethod().equals("POST")) {
            DonationManager donation = new DonationManager();
           
            
            Integer donationId = Integer.parseInt(request.getParameter("donationId"));
            String pictureFile = request.getParameter("pictureFile");
            
            int status = donation.addPicture(donationId, pictureFile);

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

