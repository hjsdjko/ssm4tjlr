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


import com.dao.WodehuodongDao;
import com.entity.WodehuodongEntity;
import com.service.WodehuodongService;
import com.entity.vo.WodehuodongVO;
import com.entity.view.WodehuodongView;

@Service("wodehuodongService")
public class WodehuodongServiceImpl extends ServiceImpl<WodehuodongDao, WodehuodongEntity> implements WodehuodongService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WodehuodongEntity> page = this.selectPage(
                new Query<WodehuodongEntity>(params).getPage(),
                new EntityWrapper<WodehuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WodehuodongEntity> wrapper) {
		  Page<WodehuodongView> page =new Query<WodehuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WodehuodongVO> selectListVO(Wrapper<WodehuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WodehuodongVO selectVO(Wrapper<WodehuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WodehuodongView> selectListView(Wrapper<WodehuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WodehuodongView selectView(Wrapper<WodehuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
