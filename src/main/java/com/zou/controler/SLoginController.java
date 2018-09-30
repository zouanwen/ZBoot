package com.zou.controler;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zou.common.Constant;
import com.zou.common.Msg;
import com.zou.entity.SLogin;
import com.zou.service.ISLoginService;

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
 * @since 2018-09-26
 */
@RestController
@RequestMapping("/sLogin")
@Api(value="登录管理")
public class SLoginController {

	@Autowired
	private ISLoginService iSLoginService;
	
	@PostMapping(value="/insertLogin")
	@ApiOperation(value="添加登录")
	@RequiresPermissions(logical = Logical.OR,value ={"1","2","3","4","5"})
	public Msg InsertLogin(@ApiParam(value="传参-[userName:用户名/userIphone:账号/userPwd:密码/roleId:角色id]")@RequestBody SLogin sLogin) {
		return iSLoginService.InsertLogin(sLogin);
	}
	
	@GetMapping(value="/selectLogin")
	@ApiOperation(value="查看所有的账号")
	@RequiresPermissions(logical = Logical.OR,value = {"1","2","3","4","5"})
	public Msg SelectLogin(@ApiParam(value="页码")@RequestParam int start) {
		return iSLoginService.SelectLogin(start);
	}
	
	@DeleteMapping(value="/deleteLogin/{id}")
	@ApiOperation(value="删除账号")
	@RequiresPermissions(logical = Logical.OR,value = {"1","2","3","4","5"})
	public Msg DeleteLogin(@ApiParam(value="账号id") @PathVariable int id) {
		return iSLoginService.DeleteLogin(id);
	}
	
	@PostMapping(value="/sLogin")
	@ApiOperation(value="登录")
	public Msg sLogin(@ApiParam(value="传参-[userIphone:账号/userPwd:密码]")@RequestBody SLogin sLogin) {
		return iSLoginService.SLong(sLogin);
	}
}

