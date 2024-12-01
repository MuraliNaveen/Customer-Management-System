package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.daoimpl.CustomerDaoImpl;
import com.model.pojo.Customer;
import com.secret.Encryption;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String Name=req.getParameter("name");
		String Emailss=req.getParameter("email");
		String Email=Encryption.encrypt(Emailss);
		String City=req.getParameter("city");
		String Mobile=req.getParameter("mobile");
		Customer c=new Customer(
				Name,Email,City,Mobile
				);
		CustomerDaoImpl cdmpl=new CustomerDaoImpl();
		
		int status =cdmpl.insert(c);
		if(status==1) {
			resp.sendRedirect("CustomerServlet");
		}
		else {
			resp.sendRedirect("Failure.jsp");
		}

		}
}
