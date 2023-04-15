package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import assetmgt.DonationManager;

public final class donationProcessing_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Recording Donation</title>\n");
      out.write("    </head>\n");
      out.write("    <body> \n");
      out.write("        <form action=\"index.html\">\n");
      out.write("        ");

        if(request.getMethod().equals("POST")) {
            DonationManager donation = new DonationManager();
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
            
            int status = donation.record_donation();

            if (status == 1) {
    
      out.write("\n");
      out.write("            <h1>Registering Asset Successful</h1>\n");
      out.write("    ");
  
            } else { 
    
      out.write("\n");
      out.write("            <h1>Registering Asset Failed</h1>\n");
      out.write("    ");
  
            }
    } 

      out.write("\n");
      out.write("\n");
      out.write("        <input type=\"submit\" value=\"Back to Main Menu\">\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
