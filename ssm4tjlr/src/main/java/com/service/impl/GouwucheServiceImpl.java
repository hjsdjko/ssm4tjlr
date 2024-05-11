package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.GouwucheDao;
import com.entity.GouwucheEntity;
import com.service.GouwucheService;
import com.entity.vo.GouwucheVO;
import com.entity.view.GouwucheView;

@Service("gouwucheService")
public class GouwucheServiceImpl extends ServiceImpl<GouwucheDao, GouwucheEntity> implements GouwucheService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GouwucheEntity> page = this.selectPage(
                new Query<GouwucheEntity>(params).getPage(),
                new EntityWrapper<GouwucheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GouwucheEntity> wrapper) {
		  Page<GouwucheView> page =new Query<GouwucheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GouwucheVO> selectListVO(Wrapper<GouwucheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GouwucheVO selectVO(Wrapper<GouwucheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GouwucheView> selectListView(Wrapper<GouwucheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GouwucheView selectView(Wrapper<GouwucheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
