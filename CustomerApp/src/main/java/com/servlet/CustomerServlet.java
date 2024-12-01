package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.daoimpl.CustomerDaoImpl;
import com.model.pojo.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	
	     
	      @Override
	    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	  CustomerDaoImpl cimpl=new CustomerDaoImpl();
	 	     List<Customer> customerlist=cimpl.fetchAll();
	 	     
	 	     req.getSession().setAttribute("customerlist", customerlist);
	 	     
	 	     resp.sendRedirect("Home.jsp");
	    }
	     



}
