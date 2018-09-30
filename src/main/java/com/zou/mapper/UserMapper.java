package com.zou.mapper;

import com.zou.entity.User;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zou
 * @since 2018-09-22
 */
@CacheConfig(cacheNames = "user")
public interface UserMapper extends BaseMapper<User> {
	
	@Cacheable
	int InsertUser(User user);//查询
}
