package com.zou.service;

import com.zou.common.Msg;
import com.zou.entity.SRole;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zou
 * @since 2018-09-26
 */
public interface ISRoleService extends IService<SRole> {

	Msg InsertRole(SRole role);//添加学生
	
	Msg DeleteRole(int roleId);//删除角色
	
	Msg SelectRole(int start);//查看角色
	
	Msg UpdateRole(SRole roles);//更新角色
	
}
