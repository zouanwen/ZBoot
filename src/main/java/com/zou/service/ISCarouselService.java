package com.zou.service;

import com.zou.common.Msg;
import com.zou.entity.SCarousel;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zou
 * @since 2018-09-26
 */
public interface ISCarouselService extends IService<SCarousel> {

	Msg InsertCarouse(SCarousel scarousel);//添加轮播图
	
	Msg DelectCarouse(int carousel_id);//删除录播图
	
	Msg SelectCarouse();//查看全部录播图
}
