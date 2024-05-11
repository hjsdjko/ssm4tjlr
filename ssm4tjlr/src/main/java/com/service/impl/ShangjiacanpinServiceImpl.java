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


import com.dao.ShangjiacanpinDao;
import com.entity.ShangjiacanpinEntity;
import com.service.ShangjiacanpinService;
import com.entity.vo.ShangjiacanpinVO;
import com.entity.view.ShangjiacanpinView;

@Service("shangjiacanpinService")
public class ShangjiacanpinServiceImpl extends ServiceImpl<ShangjiacanpinDao, ShangjiacanpinEntity> implements ShangjiacanpinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShangjiacanpinEntity> page = this.selectPage(
                new Query<ShangjiacanpinEntity>(params).getPage(),
                new EntityWrapper<ShangjiacanpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShangjiacanpinEntity> wrapper) {
		  Page<ShangjiacanpinView> page =new Query<ShangjiacanpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShangjiacanpinVO> selectListVO(Wrapper<ShangjiacanpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShangjiacanpinVO selectVO(Wrapper<ShangjiacanpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShangjiacanpinView> selectListView(Wrapper<ShangjiacanpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShangjiacanpinView selectView(Wrapper<ShangjiacanpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
