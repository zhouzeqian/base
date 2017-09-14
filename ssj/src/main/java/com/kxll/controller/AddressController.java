package com.kxll.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.kxll.entity.Address;
import com.kxll.service.AddressService;
import com.kxll.vo.AddressVo;

@RestController
@RequestMapping("address")
public class AddressController {
	Logger log=LoggerFactory.getLogger(this.getClass());
	@Resource
	AddressService addressService;

	@RequestMapping("find")
	public List<AddressVo> find() {
		List<AddressVo> list = Lists.newArrayList();
		List<Address> addressList = addressService.find();
		if (addressList != null && addressList.size() > 0) {
			for(Address address:addressList)
				list.add(address.toAddressVo());
		}
		return list;
	}
	
	@RequestMapping("add")
	public Integer add(Address address) {
		address.setCreateTime(new Date());
		address.setIsDel(0);
		addressService.add(address);
		return address.getId();
	}

	@RequestMapping("update")
	public Boolean  update(Integer id,String name) {
		addressService.update(id,name);
		return true;
	}
	
	@RequestMapping("delete")
	public Boolean delete(Integer id){
		addressService.delete(id);
		return true;
	}
}
