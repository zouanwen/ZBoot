package com.zou.serviceImpl;

import com.zou.common.Msg;
import com.zou.common.ResultUtil;
import com.zou.entity.User;
import com.zou.mapper.UserMapper;
import com.zou.service.IUserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zou
 * @since 2018-09-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Msg Byselectbase(User user) {
		// TODO Auto-generated method stub
		return ResultUtil.success(userMapper.InsertUser(user), 0);
	}

	@Override
	public Msg PageSelectUser(int start) {
		// TODO Auto-generated method stub
		List<User> list=userMapper.selectPage(new Page(start,10), new EntityWrapper());
		return ResultUtil.success(list,userMapper.selectCount(new EntityWrapper()));
	}

}
