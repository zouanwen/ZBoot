package com.zou.controler;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zou.common.Msg;
import com.zou.entity.SCarousel;
import com.zou.service.ISCarouselService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zou
 * @since 2018-09-26
 */
@RestController
@RequestMapping("sCarousel")
@Api(value="录播图管理")
public class SCarouselController {

	
	@Autowired
	private ISCarouselService iSCarouselService;
	
	@PostMapping(value="insertCarouse")
	@ApiOperation(value="添加录播图")
	public Msg InsertCarouse(@ApiParam(value="传参:carouselImages:图片")@RequestBody SCarousel scarousel) {
		return iSCarouselService.InsertCarouse(scarousel);
	}
	
	@DeleteMapping(value="/delectCarouse/{carousel_id}")
	@ApiOperation(value="删除录播图")
	public Msg DelectCarouse(@ApiParam(value="录播图id")@PathVariable int carouselId) {
		return iSCarouselService.DelectCarouse(carouselId);
	}
	
	@GetMapping(value="/selectCarouse")
	@ApiOperation(value="查看录播图")
	public Msg SelectCarouse() {
		return iSCarouselService.SelectCarouse();
	}
}

