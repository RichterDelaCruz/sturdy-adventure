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
        <title>Recording Donation</title>
    </head>
    <body> 
        <form action="index.html">
        <%
        if(request.getMethod().equals("POST")) {
            DonationManager donation = new DonationManager();
            donation.setDonationId(Integer.parseInt(request.getParameter("donationId")));
            donation.setDonorName(request.getParameter("donorName"));
            donation.setDonationFormFile(request.getParameter("donationFormFile"));
            donation.setDonationDate(java.sql.Date.valueOf(request.getParameter("donationDate")));
            donation.setAcceptHoid(Integer.parseInt(request.getParameter("acceptHoid")));
            donation.setAcceptPosition(request.getParameter("acceptPosition"));
            donation.setAcceptElectionDate(java.sql.Date.valueOf(request.getParameter("acceptElectionDate")));
            
            if (request.getParameter("approvalHoid") != null && !request.getParameter("approvalHoid").isEmpty()) {
                donation.setApprovalHoid(Integer.parseInt(request.getParameter("approvalHoid")));
            }
            if (request.getParameter("approvalPosition") != null && !request.getParameter("approvalPosition").isEmpty()) {
                donation.setApprovalPosition(request.getParameter("approvalPosition"));
            }
            if (request.getParameter("approvalElectionDate") != null && !request.getParameter("approvalElectionDate").isEmpty()) {
                donation.setApprovalElectionDate(java.sql.Date.valueOf(request.getParameter("approvalElectionDate")));
            }
            
            int status = donation.update_donation();

            if (status == 1) {
    %>
            <h1>Updating Asset Successful</h1>
    <%  
            } else { 
    %>
            <h1>Updating Asset Failed</h1>
    <%  
            }
        } 
    %>

        <input type="submit" value="Back to Main Menu">
        </form>
    </body>
</html>
