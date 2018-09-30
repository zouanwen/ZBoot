package com.zou.serviceImpl;

import com.zou.common.Msg;
import com.zou.common.ResultUtil;
import com.zou.entity.SCarousel;
import com.zou.mapper.SCarouselMapper;
import com.zou.service.ISCarouselService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zou
 * @since 2018-09-26
 */
@Service
public class SCarouselServiceImpl extends ServiceImpl<SCarouselMapper, SCarousel> implements ISCarouselService {
	
	@Autowired
	private SCarouselMapper SCarouselMapper;
	/*
	 * (non-Javadoc)
	 * @see com.zou.service.ISCarouselService#InsertCarouse(com.zou.entity.SCarousel)
	 * 添加轮播图
	 */
	@Override
	public Msg InsertCarouse(SCarousel scarousel) {
		// TODO Auto-generated method stub
		scarousel.setCreateTime(new Date());
		if(SCarouselMapper.insert(scarousel)==1) {
			return ResultUtil.success(1, 0);
		}else {
			return ResultUtil.error(0, "添加错误");
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.zou.service.ISCarouselService#DelectCarouse(int)
	 * 删除录播图
	 */
	@Override
	public Msg DelectCarouse(int carousel_id) {
		// TODO Auto-generated method stub
		if(SCarouselMapper.deleteById(carousel_id)==1) {
			return ResultUtil.success(1, 0);
		}else {
			return ResultUtil.error(0, "删除错误");
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.zou.service.ISCarouselService#SelectCarouse()
	 * 查看录播图
	 */
	@Override
	public Msg SelectCarouse() {
		// TODO Auto-generated method stub
		return ResultUtil.success(SCarouselMapper.selectList(new EntityWrapper<>()), 0);
	}

}
