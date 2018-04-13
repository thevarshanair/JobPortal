<%@page import="java.util.*;"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>
<table align="center">
<%
List joblist=new ArrayList();
joblist=(ArrayList)request.getAttribute("joblist");
if(joblist!=null && joblist.size()>0 ){
%>
<h2 align="center">Job List</h2>
<tr>
<th>Job Category</th>
<th>Company Name</th>
<th>Job Level</th>
</tr>
<%
for(int i=0;i<joblist.size();i++){
List job=(List)joblist.get(i);
%>
<tr>
<td><%=job.get(1) %></td>
<td><%=job.get(2) %></td>
<td><%=job.get(3) %></td>
</tr>
<%}}else{%>
Not  Available  Any Job Details
<%}%>
</table>
</body>
</html>