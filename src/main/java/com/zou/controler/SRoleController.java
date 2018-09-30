package com.zou.controler;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zou.common.Msg;
import com.zou.entity.SRole;
import com.zou.service.ISRoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zou
 * @since 2018-09-26
 */
@RestController
@RequestMapping("/sRole")
@Api(value="角色管理")
public class SRoleController {

	@Autowired
	private ISRoleService iSRoleService;
	
	@PostMapping(value="/insertRole")
	@ApiOperation(value="添加角色")
	@RequiresPermissions(logical = Logical.OR,value = {"1","2","3","4","5"})
	public Msg InsertRole(@ApiParam(value="传参[role:角色]") @RequestBody SRole role) {
		return iSRoleService.InsertRole(role);
	}
	
	@DeleteMapping(value="/deleteRole/{roleId}")
	@ApiOperation(value="删除角色")
	@RequiresPermissions(logical = Logical.OR,value = {"1","2","3","4","5"})
	public Msg DeleteRole(@ApiParam(value="角色id") @PathVariable int roleId) {
		return iSRoleService.DeleteRole(roleId);
	}
	
	@GetMapping(value="/selectRole")
	@ApiOperation(value="查看角色")
	@RequiresPermissions(logical = Logical.OR,value = {"1","2","3","4","5"})
	public Msg SelectRole(@ApiParam(value="页码") @RequestParam int start) {
		return iSRoleService.SelectRole(start);
	}
	
	@PutMapping(value="/updateRole")
	@ApiOperation(value="更新角色")
	@RequiresPermissions(logical = Logical.OR,value = {"1","2","3","4","5"})
	public Msg UpdateRole(@ApiParam(value="传参[role:角色]") @RequestBody SRole role) {
		return iSRoleService.UpdateRole(role);
	}
}

