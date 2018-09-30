package com.zou.service;

import com.zou.common.Msg;
import com.zou.entity.SLogin;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zou
 * @since 2018-09-26
 */
public interface ISLoginService extends IService<SLogin> {

	Msg InsertLogin(SLogin sLogin);//添加账号
	
	Msg SelectLogin(int start);//查看所有的账号
	
	Msg DeleteLogin(int id);//删除账号
	
	Msg SLong(SLogin sLogin);//登录
	
	Msg UpdateLogin(SLogin sLogin);//更新密碼
	
}
