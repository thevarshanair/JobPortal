package com.java.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.String;
 
import com.java.DBA.LoginService;

public class LoginServlet extends HttpServlet {
    
LoginService service = null;
 
public void init(ServletConfig config)throws ServletException{
    service = new LoginService();
}
 
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
     
    String message = service.doLogin(username, password);
    response.getWriter().write(message);
}
}
