package com.zou.controler;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zou.common.Msg;
import com.zou.common.ResultUtil;
import com.zou.entity.User;
import com.zou.service.IUserService;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zou
 * @since 2018-09-22
 */
@RestController
@RequestMapping("/zou/user")
public class UserController {

	@Autowired
	private IUserService iUserService;
	
	@GetMapping(value="/test")
	@ApiOperation(value="测试")
	public Msg test() {
		List<User> list=iUserService.selectList(null);
		System.out.println(list.size());
		return ResultUtil.success(iUserService.selectList(null), 1);
	}
	
	@PostMapping(value="/test1")
	@ApiOperation(value="插入测试")
	public void test1(@RequestBody User entity) {
		System.out.println(entity.getNames());
		iUserService.insert(entity);
	}
	
	@PostMapping(value="/Byselectbase")
	@ApiOperation(value="插入测试")
	public Msg Byselectbase(@RequestBody User user) {
		return iUserService.Byselectbase(user);
	}
	
	@GetMapping(value="/PageSelectUser")
	@ApiOperation(value="分页")
	public Msg PageSelectUser(@RequestParam int start) {
		return iUserService.PageSelectUser(start);
	}
}

