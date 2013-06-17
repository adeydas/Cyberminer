<%-- 
    Document   : index
    Created on : Apr 19, 2013, 2:20:31 AM
    Author     : abhishek
--%>

<%@page import="java.util.Iterator"%>
<%@page import="com.asad.Result"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.asad.Searchresults" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width" />
        <link rel="stylesheet" href="normalize.css" />
        <link rel="stylesheet" href="foundation.css" />        
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>
        <script src="custom.modernizr.js"></script>
        <script type="text/javascript" src="jquery-1.9.1.js"></script>        
        <script type="text/javascript">            
            $(document).ready(function(){                
                $('.result p').each(function(){
                    $(this).html($(this).html().substr(0,300)+"...");
                });
                $('#searchBox').val($('#searchKeyword').text());
                $('#searchTerm').text($('#searchBox').val()); 
                if(getCookie("linksPerPage") == null){
                    setCookie("linksPerPage",10,365);
                }else{
                    $('#linksPerPage').val( getCookie("linksPerPage")).attr('selected',true);
                }                
                
                $('#searchButton').click(function() {                                        
                    document.form1.action = "index.jsp?linksPerPage="+getCookie("linksPerPage");                    
                    document.form1.submit();                    
                });
                
                $('#linksPerPage').change(function(){
                    setCookie("linksPerPage",$('#linksPerPage').val(),365);
                    document.form1.action = "index.jsp?linksPerPage="+$('#linksPerPage').val();
                    document.form1.submit();
                });
            });            

function getCookie(c_name)
{
var c_value = document.cookie;
var c_start = c_value.indexOf(" " + c_name + "=");
if (c_start == -1)
{
c_start = c_value.indexOf(c_name + "=");
}
if (c_start == -1)
{
c_value = null;
}
else
{
c_start = c_value.indexOf("=", c_start) + 1;
var c_end = c_value.indexOf(";", c_start);
if (c_end == -1)
{
c_end = c_value.length;
}
c_value = unescape(c_value.substring(c_start,c_end));
}
return c_value;
}

function setCookie(c_name,value,exdays)
{
var exdate=new Date();
exdate.setDate(exdate.getDate() + exdays);
var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString());
document.cookie=c_name + "=" + c_value;
}

function checkCookie()
{
var linksPerPage=getCookie("linksPerPage");
  if (linksPerPage!=null && linksPerPage!="")
    {
    setCookie("linksPerPage",10,365);
    }  
}
        </script>    
        <title>CyberMiner</title>
    </head>
    <body>
        <header>
            <div class="row">
                <div class="large-12 columns">
                    <div class="large-5 columns large-centered">
                    <h1>CyberMiner</h1>
                    </div>
                    <div class="row">
                    <form method="post" name="form1">
                        <div class="large-5 columns large-centered">
                            <div class="row collapse">
                                <div class="large-8 columns ui-widget">
                                    <input type="text" id="searchBox" name="searchBox" placeholder="Search"/>
                                </div>
                                <div class="large-4 columns">
                                    <input type="button" class="button radius postfix" id="searchButton" value="Search"/>
                                </div>
                            </div>
                         </div>
                    </form>
                    </div>
                </div>
            </div>
        </header>
        <div class="row">
            <div class="large-12 columns">
                <div class="container">
                                        
                    <%
                        Searchresults results = new Searchresults();
                        String autoFillString = "";
                        if (request.getParameter("searchBox") != null) {
                            //autoFillString = results.autoFill(request.getParameter("searchBox"));            
                        }
                    %>
                    <span style="display:none;" id="autoFillString"><%=autoFillString%></span>
                    <%
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
                    %>                    
                    <div class="large-4 columns large-offset-8">
                        <select id="linksPerPage">
                            <option value="10">10 (results per page)</option>
                            <option value="20">20 (results per page)</option>
                            <option value="30">30 (results per page)</option>
                        </select>
                        <p>Displaying (<%=startIndex%> - <%=endIndex%>) of <%=searchResult.size()%> results found</p></div>        
                    <div class="row">       
                        <%
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
                        %>         
                        <div class="large-12 columns panel result">
                            <p><%=rs1.getDesc()%></p>
                            <a href="<%=rs1.getUrl()%>" target="_blank"><%=rs1.getUrl()%></a>
                        </div>   
                        <%
                        i++;
                                               }
                            }                            
                        %>
                    </div>      
                    <span style="display:none;" id="searchKeyword"><%=request.getParameter("searchBox")%></span>
                    <div class="pagination-centered">
                        <ul class="pagination">
                        <form action="index.jsp" method="post"> 
                            <%
                                for (int cnt = 1; cnt <= numPages; cnt++) {
                                    if (cnt == count) {
                            %>
                            <li class="current"><a href="index.jsp?count=<%=cnt%>&searchBox=<%=request.getParameter("searchBox")%>&linksPerPage=<%=linksPerPage%>"><%=cnt%></a></li>
                            <%
                            } else {
                            %>
                            <li><a href="index.jsp?count=<%=cnt%>&searchBox=<%=request.getParameter("searchBox")%>&linksPerPage=<%=linksPerPage%>"><%=cnt%></a></li>
                            <%
                                    }
                                }
                            %>
                        </form>    
                        </ul>
                    </div>
                    <%
                    } else {
                    %>
                    <div class="large-12 columns panel"><h4>No results found, please try another search term</h4></div>
                        <%                }
                            }
                        %>
                </div>
            </div>
        </div>
    </body>
</html>
