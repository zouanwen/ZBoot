package com.zou.controler;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zou.common.Msg;
import com.zou.entity.SFamousClass;
import com.zou.service.ISFamousClassService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@RequestMapping("/sFamousClass")
@Api(value="资讯分类管理")
public class SFamousClassController {

	@Autowired
	private ISFamousClassService iSFamousClassService;
	
	@PostMapping(value="/insertFamousClass")
	@ApiOperation(value="添加资讯分类")
	@RequiresPermissions(logical = Logical.OR,value = {"1","2","3","4","5"})
	public Msg InsertFamousClass(@ApiParam(value="传参[className:分类名字/classImages:分类图片]")@RequestBody SFamousClass sFamousClass) {
		return iSFamousClassService.InsertFamousClass(sFamousClass);
	}
	
	@PutMapping(value="/UpdateFamousClass")
	@ApiOperation(value="修改资讯分类")
	@RequiresPermissions(logical = Logical.OR,value = {"1","2","3","4","5"})
	public Msg UpdateFamousClass(@ApiParam(value="传参[classId:分类id/className:分类名字/classImages:分类图片]")@RequestBody SFamousClass sFamousClass) {
		return iSFamousClassService.UpdateFamousClass(sFamousClass);
	}
	
	@DeleteMapping(value="/DeleteFamousClass/{classId}")
	@ApiOperation(value="删除资讯分类")
	@RequiresPermissions(logical = Logical.OR,value = {"1","2","3","4","5"})
	public Msg DeleteFamousClass(@ApiParam(value="分类id") @PathVariable int classId) {
		return iSFamousClassService.DeleteFamousClass(classId);
	}
	
	@GetMapping(value="/SelectFamousClass")
	@ApiOperation(value="查看资讯分类")
	public Msg SelectFamousClass() {
		return iSFamousClassService.SelectFamousClass();
	}
}

