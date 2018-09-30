package com.zou.service;

import com.zou.common.Msg;
import com.zou.entity.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zou
 * @since 2018-09-22
 */
public interface IUserService extends IService<User> {

	Msg Byselectbase(User user);
	
	Msg PageSelectUser(int start);//分页查询
}
