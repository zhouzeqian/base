package com.kxll.service.impl;

import com.kxll.entity.Permission;
import com.kxll.mapper.PermissionMapper;
import com.kxll.service.IPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {
	
}
