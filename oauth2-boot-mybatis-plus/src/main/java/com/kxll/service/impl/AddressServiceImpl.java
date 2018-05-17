package com.kxll.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kxll.entity.Address;
import com.kxll.mapper.AddressMapper;
import com.kxll.service.IAddressService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author zzq
 * @since 2018-05-14
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {
	
}
