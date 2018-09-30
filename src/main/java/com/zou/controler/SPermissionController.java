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

import com.zou.common.Constant;
import com.zou.common.Msg;
import com.zou.entity.SPermission;
import com.zou.service.ISPermissionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zou
 * @since 2018-09-28
 */
@RestController
@RequestMapping("/sPermission")
@Api(value="角色权限管理")
public class SPermissionController {

	@Autowired
	private ISPermissionService iSPermissionService;
	
	
	@PostMapping(value="/insertPermisson")
	@ApiOperation(value="添加角色权限")
	@RequiresPermissions(logical = Logical.OR,value = {"1","2","3","4","5"})
	public Msg InsertPermisson(@ApiParam(value="传参[permission:权限/roleId:角色id]")@RequestBody SPermission sPermission) {
		return iSPermissionService.InsertPermisson(sPermission);
	}

	@DeleteMapping(value="/deleteParmisson/{roleId}")
	@ApiOperation(value="删除权限")
	@RequiresPermissions(logical = Logical.OR,value = {"1","2","3","4","5"})
	public Msg DeleteParmisson(@ApiParam(value="角色id") @PathVariable int roleId) {
		return iSPermissionService.DeleteParmisson(roleId);
	}
	
	@GetMapping(value="/selectParmisson")
	@ApiOperation(value="角色查看权限")
	@RequiresPermissions(logical = Logical.OR,value = {"1","2","3","4","5"})
	public Msg SelectParmisson(@ApiParam(value="角色id") @RequestParam int roleId) {
		return iSPermissionService.SelectParmisson(roleId);
	}
}

