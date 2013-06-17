package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import com.asad.Result;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import com.asad.Searchresults;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"normalize.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"foundation.css\" />        \n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>\n");
      out.write("        <script src=\"custom.modernizr.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"jquery-1.9.1.js\"></script>        \n");
      out.write("        <script type=\"text/javascript\">            \n");
      out.write("            $(document).ready(function(){                \n");
      out.write("                $('.result p').each(function(){\n");
      out.write("                    $(this).html($(this).html().substr(0,300)+\"...\");\n");
      out.write("                });\n");
      out.write("                $('#searchBox').val($('#searchKeyword').text());\n");
      out.write("                $('#searchTerm').text($('#searchBox').val()); \n");
      out.write("                if(getCookie(\"linksPerPage\") == null){\n");
      out.write("                    setCookie(\"linksPerPage\",10,365);\n");
      out.write("                }else{\n");
      out.write("                    $('#linksPerPage').val( getCookie(\"linksPerPage\")).attr('selected',true);\n");
      out.write("                }                \n");
      out.write("                \n");
      out.write("                $('#searchButton').click(function() {                                        \n");
      out.write("                    document.form1.action = \"index.jsp?linksPerPage=\"+getCookie(\"linksPerPage\");                    \n");
      out.write("                    document.form1.submit();                    \n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                $('#linksPerPage').change(function(){\n");
      out.write("                    setCookie(\"linksPerPage\",$('#linksPerPage').val(),365);\n");
      out.write("                    document.form1.action = \"index.jsp?linksPerPage=\"+$('#linksPerPage').val();\n");
      out.write("                    document.form1.submit();\n");
      out.write("                });\n");
      out.write("            });            \n");
      out.write("\n");
      out.write("function getCookie(c_name)\n");
      out.write("{\n");
      out.write("var c_value = document.cookie;\n");
      out.write("var c_start = c_value.indexOf(\" \" + c_name + \"=\");\n");
      out.write("if (c_start == -1)\n");
      out.write("{\n");
      out.write("c_start = c_value.indexOf(c_name + \"=\");\n");
      out.write("}\n");
      out.write("if (c_start == -1)\n");
      out.write("{\n");
      out.write("c_value = null;\n");
      out.write("}\n");
      out.write("else\n");
      out.write("{\n");
      out.write("c_start = c_value.indexOf(\"=\", c_start) + 1;\n");
      out.write("var c_end = c_value.indexOf(\";\", c_start);\n");
      out.write("if (c_end == -1)\n");
      out.write("{\n");
      out.write("c_end = c_value.length;\n");
      out.write("}\n");
      out.write("c_value = unescape(c_value.substring(c_start,c_end));\n");
      out.write("}\n");
      out.write("return c_value;\n");
      out.write("}\n");
      out.write("\n");
      out.write("function setCookie(c_name,value,exdays)\n");
      out.write("{\n");
      out.write("var exdate=new Date();\n");
      out.write("exdate.setDate(exdate.getDate() + exdays);\n");
      out.write("var c_value=escape(value) + ((exdays==null) ? \"\" : \"; expires=\"+exdate.toUTCString());\n");
      out.write("document.cookie=c_name + \"=\" + c_value;\n");
      out.write("}\n");
      out.write("\n");
      out.write("function checkCookie()\n");
      out.write("{\n");
      out.write("var linksPerPage=getCookie(\"linksPerPage\");\n");
      out.write("  if (linksPerPage!=null && linksPerPage!=\"\")\n");
      out.write("    {\n");
      out.write("    setCookie(\"linksPerPage\",10,365);\n");
      out.write("    }  \n");
      out.write("}\n");
      out.write("        </script>    \n");
      out.write("        <title>CyberMiner</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"large-12 columns\">\n");
      out.write("                    <div class=\"large-5 columns large-centered\">\n");
      out.write("                    <h1>CyberMiner</h1>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                    <form method=\"post\" name=\"form1\">\n");
      out.write("                        <div class=\"large-5 columns large-centered\">\n");
      out.write("                            <div class=\"row collapse\">\n");
      out.write("                                <div class=\"large-8 columns ui-widget\">\n");
      out.write("                                    <input type=\"text\" id=\"searchBox\" name=\"searchBox\" placeholder=\"Search\"/>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"large-4 columns\">\n");
      out.write("                                    <input type=\"button\" class=\"button radius postfix\" id=\"searchButton\" value=\"Search\"/>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                         </div>\n");
      out.write("                    </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"large-12 columns\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                                        \n");
      out.write("                    ");

                        Searchresults results = new Searchresults();
                        String autoFillString = "";
                        if (request.getParameter("searchBox") != null) {
                            //autoFillString = results.autoFill(request.getParameter("searchBox"));            
                        }
                    
      out.write("\n");
      out.write("                    <span style=\"display:none;\" id=\"autoFillString\">");
      out.print(autoFillString);
      out.write("</span>\n");
      out.write("                    ");

                        ArrayList<Result> searchResult;
                        if (request.getParameter("searchBox") != null) {
                            searchResult = results.getResults(request.getParameter("searchBox"));
                            int linksPerPage = 10;
                            if(request.getParameter("linksPerPage") != null){
                                linksPerPage = Integer.parseInt(request.getParameter("linksPerPage"));
                            }
                            int startIndex = 1, count = 1;
                            if (searchResult != null) {
                                if (request.getParameter("count") != null) {
                                    count = Integer.parseInt(request.getParameter("count"));
                                    startIndex = ((count-1) *linksPerPage ) +1;
                                }
                                int endIndex = count * linksPerPage;
                                if ((endIndex) > searchResult.size()) {
                                    endIndex = searchResult.size();
                                }
                    
      out.write("                    \n");
      out.write("                    <div class=\"large-4 columns large-offset-8\">\n");
      out.write("                        <select id=\"linksPerPage\">\n");
      out.write("                            <option value=\"10\">10 (results per page)</option>\n");
      out.write("                            <option value=\"20\">20 (results per page)</option>\n");
      out.write("                            <option value=\"30\">30 (results per page)</option>\n");
      out.write("                        </select>\n");
      out.write("                        <p>Displaying (");
      out.print(startIndex);
      out.write(" - ");
      out.print(endIndex);
      out.write(") of ");
      out.print(searchResult.size());
      out.write(" results found</p></div>        \n");
      out.write("                    <div class=\"row\">       \n");
      out.write("                        ");

                            int numPages = searchResult.size() / linksPerPage;
                            if(searchResult.size()%linksPerPage != 0){
                                numPages = (searchResult.size() / linksPerPage) + 1;
                            }
                            int i= startIndex;
                            int j = 1;
                            System.out.println("StartIndex : "+startIndex +" & EndIndex : "+endIndex);
                            //for(Map.Entry<String,String> entry : searchResult.entrySet()) {                                
                            Iterator<Result> iter = searchResult.iterator();
                            while(iter.hasNext()){
                                Result rs1 = iter.next();
                                if(j < startIndex){
                                    j++;
                                    continue;
                                }
                            if(i <= endIndex){
                        
      out.write("         \n");
      out.write("                        <div class=\"large-12 columns panel result\">\n");
      out.write("                            <p>");
      out.print(rs1.getDesc());
      out.write("</p>\n");
      out.write("                            <a href=\"");
      out.print(rs1.getUrl());
      out.write("\" target=\"_blank\">");
      out.print(rs1.getUrl());
      out.write("</a>\n");
      out.write("                        </div>   \n");
      out.write("                        ");

                        i++;
                                               }
                            }                            
                        
      out.write("\n");
      out.write("                    </div>      \n");
      out.write("                    <span style=\"display:none;\" id=\"searchKeyword\">");
      out.print(request.getParameter("searchBox"));
      out.write("</span>\n");
      out.write("                    <div class=\"pagination-centered\">\n");
      out.write("                        <ul class=\"pagination\">\n");
      out.write("                        <form action=\"index.jsp\" method=\"post\"> \n");
      out.write("                            ");

                                for (int cnt = 1; cnt <= numPages; cnt++) {
                                    if (cnt == count) {
                            
      out.write("\n");
      out.write("                            <li class=\"current\"><a href=\"index.jsp?count=");
      out.print(cnt);
      out.write("&searchBox=");
      out.print(request.getParameter("searchBox"));
      out.write("&linksPerPage=");
      out.print(linksPerPage);
      out.write('"');
      out.write('>');
      out.print(cnt);
      out.write("</a></li>\n");
      out.write("                            ");

                            } else {
                            
      out.write("\n");
      out.write("                            <li><a href=\"index.jsp?count=");
      out.print(cnt);
      out.write("&searchBox=");
      out.print(request.getParameter("searchBox"));
      out.write("&linksPerPage=");
      out.print(linksPerPage);
      out.write('"');
      out.write('>');
      out.print(cnt);
      out.write("</a></li>\n");
      out.write("                            ");

                                    }
                                }
                            
      out.write("\n");
      out.write("                        </form>    \n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    ");

                    } else {
                    
      out.write("\n");
      out.write("                    <div class=\"large-12 columns panel\"><h4>No results found, please try another search term</h4></div>\n");
      out.write("                        ");
                }
                            }
                        
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
