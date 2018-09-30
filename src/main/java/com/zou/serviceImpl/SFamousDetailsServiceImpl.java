package com.zou.serviceImpl;

import com.zou.common.Msg;
import com.zou.common.ResultUtil;
import com.zou.entity.SFamousDetails;
import com.zou.mapper.SFamousDetailsMapper;
import com.zou.service.ISFamousDetailsService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Date;
import java.util.List;

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
public class SFamousDetailsServiceImpl extends ServiceImpl<SFamousDetailsMapper, SFamousDetails> implements ISFamousDetailsService {

	@Autowired
	private SFamousDetailsMapper sFamousDetailsMapper;
	
	
	/*
	 * (non-Javadoc)
	 * @see com.zou.service.ISFamousDetailsService#InsertFamousDetaial()
	 * 添加资讯
	 */
	@Override
	public Msg InsertFamousDetaial(SFamousDetails sFamousDetails) {
		// TODO Auto-generated method stub
		sFamousDetails.setCreateTime(new Date());
		if(sFamousDetailsMapper.insert(sFamousDetails)==1){
			return ResultUtil.success(1, 0);
		}else {
			return ResultUtil.error(0, "添加错误");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.zou.service.ISFamousDetailsService#UpdateFamousDetaial()
	 * 更改资讯
	 */
	@Override
	public Msg UpdateFamousDetaial(SFamousDetails sFamousDetails) {
		// TODO Auto-generated method stub
		sFamousDetails.setUpdateTime(new Date());
		if(sFamousDetailsMapper.update(sFamousDetails,  new EntityWrapper<SFamousDetails>().eq("details_id", sFamousDetails.getDetailsId()))==1){
			return ResultUtil.success(1, 0);
		}else {
			return ResultUtil.error(0, "id错误");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.zou.service.ISFamousDetailsService#DeleteFamousDetaial()
	 * 删除资讯
	 */
	@Override
	public Msg DeleteFamousDetaial(int detailsId) {
		// TODO Auto-generated method stub
		if(sFamousDetailsMapper.deleteById(detailsId)==1){
			return ResultUtil.success(1, 0);
		}else {
			return ResultUtil.error(0, "id错误");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.zou.service.ISFamousDetailsService#SelectFamousDetaial()
	 * 查看单个资讯
	 */
	@Override
	public Msg SelectFamousDetaial(int detailsId) {
		// TODO Auto-generated method stub
		return ResultUtil.success(sFamousDetailsMapper.selectById(detailsId), 0);
	}

	/*
	 * (non-Javadoc)
	 * @see com.zou.service.ISFamousDetailsService#SelectAllDetaial()
	 * 查看全部资讯
	 */
	@Override
	public Msg SelectAllDetaial(int start) {
		// TODO Auto-generated method stub
		List<SFamousDetails> list=sFamousDetailsMapper.selectPage(new Page(start,10),  new EntityWrapper());
		return ResultUtil.success(list,sFamousDetailsMapper.selectCount(new EntityWrapper()));
	}

	/*
	 * (non-Javadoc)
	 * @see com.zou.service.ISFamousDetailsService#SelectClassDetaial()
	 * 通过分类查看资讯
	 */
	@Override
	public Msg SelectClassDetaial(int classId,int start) {
		// TODO Auto-generated method stub
		List<SFamousDetails> list=sFamousDetailsMapper.selectPage(new Page(start,10),  new EntityWrapper().eq("class_id", classId));
		return ResultUtil.success(list,sFamousDetailsMapper.selectCount(new EntityWrapper().eq("class_id", classId)));
	}

}
