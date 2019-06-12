package com.czb.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czb.crm.mapper.BaseDictMapper;
import com.czb.crm.pojo.BaseDict;
import com.czb.crm.pojo.Customer;
import com.czb.crm.pojo.QueryVo;
import com.czb.crm.service.BaseDictService;
import com.czb.crm.utils.PageBean;
@Service
public class BaseDictServiceImpl implements BaseDictService{

	@Autowired
	private BaseDictMapper baseDictMapper; 
	
	@Override
	public List<BaseDict> findAllBaseDict(String typecode) {
		return baseDictMapper.findAllBaseDict(typecode);
	}

	@Override
	public PageBean<Customer> findPage(QueryVo querrVo) {

		//1  查询客户总条数totalCount
		int totalCount = baseDictMapper.findCountCustomer(querrVo);
		//2  查询客户列表
		List<Customer> list = baseDictMapper.findAllCustomer(querrVo);
		
		//3  封装pagebean
		PageBean<Customer> page = new PageBean<Customer>();
		page.setList(list);
		page.setTotalCount(totalCount);
		page.setCurrentPage(querrVo.getCurrentPage());
		page.setPageSize(querrVo.getPageSize());
		return page;
	}

	
	@Override
	public Customer findById(int id) {
		
		
		return baseDictMapper.findById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		baseDictMapper.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		baseDictMapper.deleteCustomer(id);		
	}
	
	
}
