package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import assetmgt.DonationManager;

public final class recordDonation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Record Donation</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Record Donation</h1>\n");
      out.write("    \n");
      out.write("    ");

        DonationManager donationManager = new DonationManager();
        ArrayList<String> donorName = donationManager.getDistinctDonorNames();
        ArrayList<Integer> acceptHoid = donationManager.getOfficerHoids();
        ArrayList<Integer> approvalHoid = donationManager.getPresidentHoids();
        ArrayList<String> acceptPosition = donationManager.getOfficerPositions();
        ArrayList<String> approvalPosition = donationManager.getPresidentPositions();
    
      out.write("\n");
      out.write("    \n");
      out.write("    <form action=\"donationProcessing.jsp\" method=\"post\">\n");
      out.write("        <label for=\"donorName\">Donor Name:</label>\n");
      out.write("        <select id=\"donorName\" name=\"donorName\" required>\n");
      out.write("          ");
 for (String name : donorName) { 
      out.write("\n");
      out.write("            <option value=\"");
      out.print( name );
      out.write('"');
      out.write('>');
      out.print( name );
      out.write("</option>\n");
      out.write("          ");
 } 
      out.write("\n");
      out.write("        </select>\n");
      out.write("        </br>\n");
      out.write("\n");
      out.write("        <label for=\"donationFormFile\">Donation Form File:</label>\n");
      out.write("        <input type=\"text\" id=\"donationFormFile\" name=\"donationFormFile\" required><br>\n");
      out.write("\n");
      out.write("        <label for=\"donationDate\">Donation Date:</label>\n");
      out.write("        <input type=\"date\" id=\"donationDate\" name=\"donationDate\" required><br>\n");
      out.write("        \n");
      out.write("        <label for=\"acceptHoid\">Accepted HOID:</label>\n");
      out.write("        <select id=\"acceptHoid\" name=\"acceptHoid\" required>\n");
      out.write("          ");
 for (Integer hoid : acceptHoid) { 
      out.write("\n");
      out.write("            <option value=\"");
      out.print( hoid );
      out.write('"');
      out.write('>');
      out.print( hoid );
      out.write("</option>\n");
      out.write("          ");
 } 
      out.write("\n");
      out.write("        </select>\n");
      out.write("        </br>\n");
      out.write("        \n");
      out.write("        <label for=\"acceptPosition\">Accepted Position:</label>\n");
      out.write("        <select id=\"acceptPosition\" name=\"acceptPosition\" required>\n");
      out.write("          ");
 for (String position : acceptPosition) { 
      out.write("\n");
      out.write("            <option value=\"");
      out.print( position );
      out.write('"');
      out.write('>');
      out.print( position );
      out.write("</option>\n");
      out.write("          ");
 } 
      out.write("\n");
      out.write("        </select>\n");
      out.write("        </br>\n");
      out.write("        \n");
      out.write("        <label for=\"acceptElectionDate\">Accepted Election Date:</label>\n");
      out.write("        <input type=\"date\" id=\"acceptElectionDate\" name=\"acceptElectionDate\" required><br>\n");
      out.write("        \n");
      out.write("        <label for=\"approvalHoid\">Approval HOID:</label>\n");
      out.write("        <select id=\"approvalHoid\" name=\"approvalHoid\">\n");
      out.write("          <option value=\"\">-- Select --</option>\n");
      out.write("          ");
 for (Integer hoid : approvalHoid) { 
      out.write("\n");
      out.write("            <option value=\"");
      out.print( hoid );
      out.write('"');
      out.write('>');
      out.print( hoid );
      out.write("</option>\n");
      out.write("          ");
 } 
      out.write("\n");
      out.write("        </select>\n");
      out.write("        <br>\n");
      out.write("        \n");
      out.write("        <label for=\"approvalPosition\">Approval Position:</label>    \n");
      out.write("        <select id=\"approvalPosition\" name=\"approvalPosition\">\n");
      out.write("          <option value=\"\">-- Select --</option>\n");
      out.write("          ");
 for (String position : approvalPosition) { 
      out.write("\n");
      out.write("            <option value=\"");
      out.print( position );
      out.write('"');
      out.write('>');
      out.print( position );
      out.write("</option>\n");
      out.write("          ");
 } 
      out.write("\n");
      out.write("        </select>\n");
      out.write("        <br>\n");
      out.write("        \n");
      out.write("        <label for=\"acceptElectionDate\">Approval Election Date:</label>\n");
      out.write("        <input type=\"date\" id=\"approvalElectionDate\" name=\"approvalElectionDate\" ><br>\n");
      out.write("        \n");
      out.write("        <button type=\"submit\">Submit</button>\n");
      out.write("    </form>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
