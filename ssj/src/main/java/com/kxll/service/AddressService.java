package com.kxll.service;

import java.util.List;

import com.kxll.entity.Address;

public interface AddressService {

	void add(Address address);

	void delete(Integer id);

	void update(Integer id,String name);

	List<Address> find();
}
