package com.zou.service;

import com.zou.common.Msg;
import com.zou.entity.SFamousDetails;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zou
 * @since 2018-09-26
 */
public interface ISFamousDetailsService extends IService<SFamousDetails> {
	
	Msg InsertFamousDetaial(SFamousDetails sFamousDetails);//添加资讯
	
	Msg UpdateFamousDetaial(SFamousDetails sFamousDetails);//更改资讯
	
	Msg DeleteFamousDetaial(int detailsId);//删除资讯
	
	Msg SelectFamousDetaial(int detailsId);//查看单个资讯
	
	Msg SelectAllDetaial(int start);//查看全部资讯
	
	Msg SelectClassDetaial(int classId,int start);//通过分类查看资讯

}
