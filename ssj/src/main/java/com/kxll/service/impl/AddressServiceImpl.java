package com.kxll.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.kxll.dao.AddressDao;
import com.kxll.entity.Address;
import com.kxll.service.AddressService;

@Service
@Transactional(isolation=Isolation.READ_COMMITTED)
public class AddressServiceImpl implements AddressService {
	@Resource
	AddressDao addressDao;

	@Override
	public void add(Address address) {
		// TODO Auto-generated method stub
		addressDao.save(address);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		addressDao.delete(id);
	}

	@Override
	public void update(Integer id,String name) {
		// TODO Auto-generated method stub
		addressDao.update(id,name);
	}

	@Override
	public List<Address> find() {
		// TODO Auto-generated method stub
		return addressDao.findAll();
	}

}
