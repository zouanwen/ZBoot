package com.zou.serviceImpl;

import com.zou.common.Msg;
import com.zou.common.ResultUtil;
import com.zou.entity.SRole;
import com.zou.mapper.SRoleMapper;
import com.zou.service.ISRoleService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zou
 * @since 2018-09-26
 */
@Service
public class SRoleServiceImpl extends ServiceImpl<SRoleMapper, SRole> implements ISRoleService {

	@Autowired
	private SRoleMapper sRoleMapper;
	
	@Override
	public Msg InsertRole(SRole role) {
		// TODO Auto-generated method stub
		role.setCreateTime(new Date());
		if(sRoleMapper.insert(role)==1) {
			return ResultUtil.success(1, 0);
		}else {
			return ResultUtil.error(0, "添加错误");
		}
	}

	@Override
	public Msg DeleteRole(int roleId) {
		// TODO Auto-generated method stub
		if(sRoleMapper.deleteById(roleId)==1) {
			return ResultUtil.success(1, 0);
		}else {
			return ResultUtil.error(0, "删除错误");
		}
	}

	@Override
	public Msg SelectRole(int start) {
		// TODO Auto-generated method stub
		return ResultUtil.success(sRoleMapper.selectPage(new Page(start,10), new EntityWrapper().orderBy("create_time", false)),sRoleMapper.selectCount(new EntityWrapper()));
	}

	@Override
	public Msg UpdateRole(SRole role) {
		// TODO Auto-generated method stub
		role.setUpdateTime(new Date());
		if(sRoleMapper.update(role, new EntityWrapper().eq("role_id", role.getRoleId()))==1) {
			return ResultUtil.success(1, 0);
		}else {
			return ResultUtil.error(0, "添加错误");
		}
	}

}
