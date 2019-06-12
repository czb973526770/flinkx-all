package com.czb.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czb.crm.pojo.BaseDict;
import com.czb.crm.pojo.Customer;
import com.czb.crm.pojo.QueryVo;
import com.czb.crm.service.BaseDictService;
import com.czb.crm.utils.PageBean;

@Controller
public class BaseDictController {

	@Autowired
	private BaseDictService baseDictService;

	@RequestMapping("/list")
	public String findAllBaseDict(QueryVo queryVo, Model model) {
		try {
			// 1 客户等级列表
			List<BaseDict> levelList = baseDictService.findAllBaseDict("006");

			// 2 客户行业列表
			List<BaseDict> industryList = baseDictService.findAllBaseDict("001");

			// 3 客户来源列表
			List<BaseDict> sourceList = baseDictService.findAllBaseDict("002");
			// 4 请求转发
			model.addAttribute("levelList", levelList);
			model.addAttribute("industryList", industryList);
			model.addAttribute("sourceList", sourceList);

			// 5 设置queryVo默认值
			if (queryVo.getCurrentPage() == null) {
				queryVo.setCurrentPage(1);
			}
			if (queryVo.getPageSize() == null) {
				queryVo.setPageSize(5);
			}
			queryVo.setStart((queryVo.getCurrentPage() - 1) * queryVo.getPageSize());
			// 6 调用service方法
			PageBean<Customer> page = baseDictService.findPage(queryVo);
			// 7 返回page
			model.addAttribute("page", page);
			// 8 回写查询条件
			model.addAttribute("custName", queryVo.getCustName());
			model.addAttribute("custSource", queryVo.getCustSource());
			model.addAttribute("custIndustry", queryVo.getCustIndustry());
			model.addAttribute("custLevel", queryVo.getCustLevel());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "customer";

	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public Customer findCustomer(int id) {		
		Customer customer = baseDictService.findById(id);		
		return customer;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public boolean updateCustomer(Customer customer) {		
		try {
			baseDictService.updateCustomer(customer);	
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteCustomer(int id) {		
		try {
			baseDictService.deleteCustomer(id);	
			return "ok";
			
		} catch (Exception e) {
			return "failed!";
		}
	}
	
}
