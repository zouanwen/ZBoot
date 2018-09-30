package com.zou.mapper;

import com.zou.entity.SLogin;
import com.zou.entity.SPermission;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zou
 * @since 2018-09-26
 */
@CacheConfig(cacheNames = "permission")
public interface SLoginMapper extends BaseMapper<SLogin> {

	SLogin SelectLogin(@Param("user_iphone") Long user_iphone);//查询后台
	
	String SelectRole(@Param("user_iphone") Long user_iphone);//查询用户权限
	
	@Cacheable(value="permission")
	List<SPermission> SelectPermission(@Param("user_iphone") Long user_iphone);//查看角色权限
}
