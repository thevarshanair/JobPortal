package com.java.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class SearchJobs extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException,IOException{
response.setContentType("text/html"); 
HttpSession session = request.getSession(true);
List joblist=new ArrayList();
Connection con = null;

String url = "jdbc:mysql://localhost:3306/";
String db = "searchjob";
String driver = "com.mysql.jdbc.Driver";
String user = "root";
String pass = "";

String jobcategories="";
String companyname="";
jobcategories=request.getParameter("jobcategories");
companyname=request.getParameter("companyname");
String sqlqueary="SELECT * FROM jobs WHERE job_name LIKE '%%' ";
if(jobcategories!=null && !(jobcategories.equals(""))){
sqlqueary+=" and isbn_code='"+jobcategories+"'";
}
if(companyname!=null && !(companyname.equals("-1"))){
sqlqueary+=" and category='"+companyname+"'";
}

try{
Class.forName(driver);
con = DriverManager.getConnection(url+db, user, pass);
try{
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(sqlqueary);
while (rs.next()) {
List jobs=new ArrayList();
jobs.add(rs.getInt(1));
jobs.add(rs.getInt(2));
jobs.add(rs.getString(3));
jobs.add(rs.getString(4));
joblist.add(jobs);
}
}catch (SQLException s){
System.out.println("SQL statement is not executed!");
}
}
catch (Exception e){
e.printStackTrace();
}
request.setAttribute("joblist",joblist); 
RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SearchJobs.jsp");
dispatcher.forward(request, response); 
}

}
