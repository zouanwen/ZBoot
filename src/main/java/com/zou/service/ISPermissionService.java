package com.zou.service;

import com.zou.common.Msg;
import com.zou.entity.SPermission;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zou
 * @since 2018-09-28
 */
@CacheConfig(cacheNames = "permission")
public interface ISPermissionService extends IService<SPermission> {

	@CacheEvict(value="permission",allEntries=true)
	Msg InsertPermisson(SPermission sPermission);//添加角色权限
	
	Msg UpdateParmisson(SPermission sPermission);//更新角色权限
	
	@CacheEvict(value="permission",allEntries=true)
	Msg DeleteParmisson(int role_id);//删除角色权限
	
	Msg SelectParmisson(int role_id);//查看解决权限
}
