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
import com.zou.entity.SFamousDetails;
import com.zou.service.ISFamousDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/sFamousDetails")
@Api(value="资讯模块")
public class SFamousDetailsController {

	@Autowired
	private ISFamousDetailsService iSFamousDetailsService;
	String a="9";
	
	@PostMapping(value="/insertFamousDetaial")
	@ApiOperation(value="添加资讯详情")
	@RequiresPermissions(logical = Logical.OR,value = {"1","2","3","4","5"})
	public Msg InsertFamousDetaial(@ApiParam(value="传参[classId:分类id/detailsTitle:题目/detailsImages:图片/detailsContent:内容]") @RequestBody SFamousDetails sFamousDetails) {
		return iSFamousDetailsService.InsertFamousDetaial(sFamousDetails);
	}
	
	@PutMapping(value="/updateFamousDetaial")
	@ApiOperation(value="修改资讯详情")
	@RequiresPermissions(logical = Logical.OR,value = {"1","2","3","4","5"})
	public Msg UpdateFamousDetaial(@ApiParam(value="传参[classId:分类id/detailsTitle:题目/detailsImages:图片/detailsContent:内容/detailsId:详情id]") @RequestBody SFamousDetails sFamousDetails) {
		return iSFamousDetailsService.UpdateFamousDetaial(sFamousDetails);
	}
	
	@DeleteMapping(value="/deleteFamousDetaial/{detailsId}")
	@ApiOperation(value="删除资讯详情")
	@RequiresPermissions(logical = Logical.OR,value = {"1","2","3","4","5"})
	public Msg DeleteFamousDetaial(@ApiParam(value="detailsId:详情id") @PathVariable int detailsId) {
		return iSFamousDetailsService.DeleteFamousDetaial(detailsId);
	}
	
	@GetMapping(value="/selectFamousDetaial")
	@ApiOperation(value="查看资讯详情")
	public Msg SelectFamousDetaial(@ApiParam(value="详情id")  @RequestParam int detailsId) {
		return iSFamousDetailsService.SelectFamousDetaial(detailsId);
	}
	
	@GetMapping(value="/selectAllDetaial")
	@ApiOperation(value="查看所有资讯详情")
	@RequiresPermissions(logical = Logical.OR,value = {"3"})
	public Msg SelectAllDetaial(@ApiParam(value="页码") @RequestParam int start) {
		return iSFamousDetailsService.SelectAllDetaial(start);
	}
	
	@GetMapping(value="/selectClassDetaial")
	@ApiOperation(value="通过分类查看资讯详情")
	public Msg SelectClassDetaial(@ApiParam(value="分类id") @RequestParam int classId,@ApiParam(value="页码") @RequestParam int start) {
		return iSFamousDetailsService.SelectClassDetaial(classId, start);
	}
}

