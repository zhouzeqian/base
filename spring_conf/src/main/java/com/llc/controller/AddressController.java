package com.llc.controller;

import com.llc.Service.AddressService;
import com.llc.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @RequestMapping("find")
    public Address find(Integer id){
        return addressService.findById(id);
    }
}
