package com.zou.serviceImpl;

import com.zou.common.Msg;
import com.zou.common.ResultUtil;
import com.zou.entity.SPermission;
import com.zou.mapper.SPermissionMapper;
import com.zou.service.ISPermissionService;

import io.swagger.annotations.ApiParam;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zou
 * @since 2018-09-28
 */
@Service
public class SPermissionServiceImpl extends ServiceImpl<SPermissionMapper, SPermission> implements ISPermissionService {
	
	@Autowired
	private SPermissionMapper sPermissionMapper;

	@Override
	public Msg InsertPermisson(SPermission sPermission) {
		// TODO Auto-generated method stub
		sPermission.setCreateTime(new Date());
		if(sPermissionMapper.insert(sPermission)==1) {
			return ResultUtil.success(1, 0);
		}else {
			return ResultUtil.error(0, "添加错误");
		}
	}

	@Override
	public Msg UpdateParmisson(SPermission sPermission) {
		// TODO Auto-generated method stub
		sPermission.setUpdateTime(new Date());
		if(sPermissionMapper.update(sPermission, new EntityWrapper<SPermission>().eq("role_id", sPermission.getRoleId()))==1) {
			return ResultUtil.success(1, 0);
		}else {
			return ResultUtil.error(0, "修改错误");
		}
	}

	@Override
	public Msg DeleteParmisson(int role_id) {
		// TODO Auto-generated method stub
		Map<String, Object> columnMap=new HashMap<String,Object>();
		columnMap.put("role_id", role_id);
		if(sPermissionMapper.deleteByMap(columnMap)>0) {
			return ResultUtil.success(1, 0);
		}else {
			return ResultUtil.error(0, "删除错误");
		}
	}

	@Override
	public Msg SelectParmisson(int role_id) {
		// TODO Auto-generated method stub
		return ResultUtil.success(sPermissionMapper.selectList(new EntityWrapper<SPermission>().eq("role_id", role_id)), 0);
	}

}
