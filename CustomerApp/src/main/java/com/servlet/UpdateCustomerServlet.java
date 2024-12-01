package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.daoimpl.CustomerDaoImpl;
import com.model.pojo.Customer;

/**
 * Servlet implementation class UpdateCustomerServlet
 */
@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String sid =req.getParameter("cid");
      int id=Integer.parseInt(sid);
      String Name=req.getParameter("name");
      String Email=req.getParameter("email");
      String mobile=req.getParameter("mobile");
      String city =req.getParameter("city");
      Customer c=new Customer(id,Name,Email,mobile,city);
    	CustomerDaoImpl cdmp=new CustomerDaoImpl();
    int status=	cdmp.update(c);
    	 if(status==1) {
    		 resp.sendRedirect("CustomerServlet");
    	 }
    	 else {
    		 resp.sendRedirect("Failure.jsp");
    	 }
    }

}
