package com.czb.crm.service;

import java.util.List;

import com.czb.crm.pojo.BaseDict;
import com.czb.crm.pojo.Customer;
import com.czb.crm.pojo.QueryVo;
import com.czb.crm.utils.PageBean;

public interface BaseDictService {
	public List<BaseDict> findAllBaseDict(String typecode);
	
	public PageBean<Customer> findPage(QueryVo querrVo);

	public Customer findById(int id);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(int id);
}
