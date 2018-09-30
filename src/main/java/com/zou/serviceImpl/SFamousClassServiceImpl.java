package com.zou.serviceImpl;

import com.zou.common.Msg;
import com.zou.common.ResultUtil;
import com.zou.entity.SFamousClass;
import com.zou.mapper.SFamousClassMapper;
import com.zou.service.ISFamousClassService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
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
public class SFamousClassServiceImpl extends ServiceImpl<SFamousClassMapper, SFamousClass> implements ISFamousClassService {

	@Autowired
	private SFamousClassMapper sFamousClassMapper;
	
	/*
	 * (non-Javadoc)
	 * @see com.zou.service.ISFamousClassService#InsertFamousClass(com.zou.entity.SFamousClass)
	 * 添加分类
	 */
	@Override
	public Msg InsertFamousClass(SFamousClass sFamousClass) {
		// TODO Auto-generated method stub
		sFamousClass.setCreateTime(new Date());
		if(sFamousClassMapper.insert(sFamousClass)==1) {
			return ResultUtil.success(1, 0);
		}else {
			return ResultUtil.error(0, "添加错误");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.zou.service.ISFamousClassService#UpdateFamousClass(com.zou.entity.SFamousClass)
	 * 修改分类
	 */
	@Override
	public Msg UpdateFamousClass(SFamousClass sFamousClass) {
		// TODO Auto-generated method stub
		sFamousClass.setUpdateTime(new Date());
		if(sFamousClassMapper.update(sFamousClass,  new EntityWrapper<SFamousClass>().eq("class_id", sFamousClass.getClassId()))==1) {
			return ResultUtil.success(1, 0);
		}else {
			return ResultUtil.error(0, "修改错误");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.zou.service.ISFamousClassService#DeleteFamousClass(int)
	 * 删除分类
	 */
	@Override
	public Msg DeleteFamousClass(int classId) {
		// TODO Auto-generated method stub
		if(sFamousClassMapper.deleteById(classId)==1) {
			return ResultUtil.success(1, 0);
		}else {
			return ResultUtil.error(0, "删除错误");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.zou.service.ISFamousClassService#SelectFamousClass()
	 * 查看分类
	 */
	@Override
	public Msg SelectFamousClass() {
		// TODO Auto-generated method stub
		return ResultUtil.success(sFamousClassMapper.selectList(new EntityWrapper<>()), 0);
	}

}
