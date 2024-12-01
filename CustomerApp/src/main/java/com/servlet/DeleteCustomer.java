package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.daoimpl.CustomerDaoImpl;

/**
 * Servlet implementation class DeleteCustomer
 */
@WebServlet("/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   int id =Integer.parseInt(req.getParameter("id"));
	   CustomerDaoImpl cdmp=new CustomerDaoImpl();
	     int x= cdmp.delete(id);
	     if(x==1) {
	    	 resp.sendRedirect("CustomerServlet");
	     }
	     else {
	    	 resp.sendRedirect("failure.jsp");
	     }
	}

}
