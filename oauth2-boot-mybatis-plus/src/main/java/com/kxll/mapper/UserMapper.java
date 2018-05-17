package com.kxll.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kxll.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author zzq
 * @since 2018-05-14
 */
public interface UserMapper extends BaseMapper<User> {

     List<User> loadUserByUsername(@Param("username") String username);

}