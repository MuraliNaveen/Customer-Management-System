package com.model.daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connector.Connector;
import com.model.dao.CustomerDAO;
import com.model.pojo.Customer;
import com.secret.Encryption;


public class CustomerDaoImpl implements CustomerDAO{
        List<Customer> customerList=new ArrayList<Customer>();
	 private final String FETCHALL="select * from customer";
	 private final String INSERT="insert into `customer`(`Name`,`Email`,`Mobile`,`City`) values(?,?,?,?)";
	 private final String FETCHONID="select * from customer where `customerId`=?";
	 private final String UPDATE="update customer set `Name`=? "
	 		+ ",`Mobile`=? ,`City`=? where `customerId`=?";
	 private final String DELETE="delete from customer  where `customerId`=?";
	 private Connection con;
	private Statement stmt;
	private ResultSet resultset;
	
	private int status;
	private PreparedStatement pstmt;

	public CustomerDaoImpl() {
		try {
		con=Connector.connector();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public int insert(Customer c) {
		try {
		 pstmt=  con.prepareStatement(INSERT);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getEmail());
			pstmt.setString(3, c.getMobile());
			pstmt.setString(4, c.getCity());
			status = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}


	@Override
	public int update(Customer c) {
		try {
			pstmt=con.prepareStatement(UPDATE);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getMobile());
			pstmt.setString(3, c.getCity());
			pstmt.setInt(4, c.getId());
			status=pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int delete(int id) {
		try {
			pstmt=con.prepareStatement(DELETE);
			pstmt.setInt(1, id);
			status = pstmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	public List<Customer> fetchAll() {
		try {
		stmt= con.createStatement();
		   resultset = stmt.executeQuery(FETCHALL);
		   customerList=extractList(resultset);
		   for(Customer c: customerList) {
			   System.out.println(c);
		   }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	

	public Customer fetchonid(int id) {
		try {
			pstmt= con.prepareStatement(FETCHONID);
			pstmt.setInt(1, id);
			resultset=pstmt.executeQuery();
			   customerList=extractList(resultset);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		return customerList.get(0);
	}
  public  List<Customer> extractList(ResultSet resultset) {
	  
	  try {
		  while(resultset.next()) {
			  
			  Customer c=new Customer(
					  resultset.getInt("customerId"),
					  resultset.getString("Name"),
					  
					 Encryption.decrypt( resultset.getString("Email")),
					  resultset.getString("Mobile"),
					  resultset.getString("City")
					  
					  );
					  customerList.add(c);
		  }
	  }
	  catch (Exception e) {
		e.printStackTrace();
	}
	  return customerList;
  }
  
  
  
}
