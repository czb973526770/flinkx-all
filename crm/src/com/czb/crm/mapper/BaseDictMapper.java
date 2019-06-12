package com.czb.crm.mapper;

import java.util.List;

import com.czb.crm.pojo.BaseDict;
import com.czb.crm.pojo.Customer;
import com.czb.crm.pojo.QueryVo;

public interface BaseDictMapper {
	
	public List<BaseDict> findAllBaseDict(String typecode);
	
	public List<Customer> findAllCustomer(QueryVo querrVo);
	
	public int findCountCustomer(QueryVo querrVo);

	public Customer findById(int id);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(int id);
}
