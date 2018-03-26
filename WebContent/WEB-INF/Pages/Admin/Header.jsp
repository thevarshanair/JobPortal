<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.lang.Object" %>   
<%@ page import="java.lang.String" %>  

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<table width="100%" cellspacing="0" cellpadding="0" align="center">
            	<tr valign="top">
                	<td colspan="2"  height="45" >
                            <pre><a href="Home.jsp" >Home Page</a>    
                            <a href="Account.jsp" >My Account</a>   
                            <a href="Registration.jsp">New Registration</a>      
                            <a href="../Logout" >Logout</a></pre></td>
                </tr>
        </table>
</head>
<body>
<%
          Object obj=session.getAttribute("regId");
          if(obj==null)
          {
                response.sendRedirect("UnAuth.jsp");
          }
          String role=session.getAttribute("role").toString();
          if(!role.equals("admin"))
           {
                if(role.equals("University"))
                    response.sendRedirect("/University/Home.jsp");
                else
                    if(role.equals("Companies"))
                        response.sendRedirect("/Companies/Home.jsp");
                    else
                        if(role.equals("Candidates"))
                            response.sendRedirect("/Candidates/Home.jsp");

            }
             %>
       
        <h2>Hello,Admin </h2>
