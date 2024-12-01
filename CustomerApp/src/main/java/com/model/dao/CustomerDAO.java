package com.model.dao;

import java.util.List;

import com.model.pojo.Customer;

public interface CustomerDAO {
   int  insert(Customer c);
   List<Customer> fetchAll();
   
   int  update(Customer c);
   int delete(int id);
}
