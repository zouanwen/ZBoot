package com.zou.service;

import com.zou.common.Msg;
import com.zou.entity.SFamousClass;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zou
 * @since 2018-09-26
 */
public interface ISFamousClassService extends IService<SFamousClass> {

	Msg InsertFamousClass(SFamousClass sFamousClass);//添加资讯分类
	
	Msg UpdateFamousClass(SFamousClass sFamousClass);//更改资讯分类
	
	Msg DeleteFamousClass(int classId);//删除资讯分类
	
	Msg SelectFamousClass();//查看资讯分类

}
