package com.llc.Service.impl;

import com.llc.Service.AddressService;
import com.llc.entity.Address;
import com.llc.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;

    @Override
    public Address findById(Integer id) {
        return addressMapper.selectByPrimaryKey(id);
    }
}
