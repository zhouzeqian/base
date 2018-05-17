package com.kxll.service.impl;

import com.kxll.entity.Message;
import com.kxll.mapper.MessageMapper;
import com.kxll.service.IMessageService;
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
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {
	
}
