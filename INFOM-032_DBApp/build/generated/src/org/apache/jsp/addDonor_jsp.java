package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;

public final class addDonor_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Add Donor</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Add Donor</h1>\n");
      out.write("    ");

        String message = "";
        if (request.getParameter("submit") != null) {
            String donorName = request.getParameter("donorName");
            String address = request.getParameter("address");
            
            // Create a connection to the database
            Connection conn = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB", "root", "");
                
                // Check if the donor already exists in the database
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM donors WHERE donorname = ?");
                ps.setString(1, donorName);
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    // Donor already exists
                    message = "Donor already exists.";
                } else {
                    // Insert the new donor into the database
                    PreparedStatement psInsert = conn.prepareStatement("INSERT INTO donors (donorname, address) VALUES (?, ?)");
                    psInsert.setString(1, donorName);
                    psInsert.setString(2, address);
                    psInsert.executeUpdate();
                    message = "Donor added successfully.";
                }
            } catch (SQLException | ClassNotFoundException e) {
                message = "Error: " + e.getMessage();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {}
                }
            }
        }
    
      out.write("\n");
      out.write("    <form method=\"post\">\n");
      out.write("        <p><label for=\"donorName\">Donor Name:</label> <input type=\"text\" name=\"donorName\" required></p>\n");
      out.write("        <p><label for=\"address\">Address:</label> <input type=\"text\" name=\"address\" required></p>\n");
      out.write("        <p><input type=\"submit\" name=\"submit\" value=\"Add Donor\"></p>\n");
      out.write("    </form>\n");
      out.write("    ");
 if (!message.equals("")) { 
      out.write("\n");
      out.write("        <p>");
      out.print( message );
      out.write("</p>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("</body>\n");
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
