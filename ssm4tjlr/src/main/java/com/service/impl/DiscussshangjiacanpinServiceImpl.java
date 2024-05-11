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


import com.dao.DiscussshangjiacanpinDao;
import com.entity.DiscussshangjiacanpinEntity;
import com.service.DiscussshangjiacanpinService;
import com.entity.vo.DiscussshangjiacanpinVO;
import com.entity.view.DiscussshangjiacanpinView;

@Service("discussshangjiacanpinService")
public class DiscussshangjiacanpinServiceImpl extends ServiceImpl<DiscussshangjiacanpinDao, DiscussshangjiacanpinEntity> implements DiscussshangjiacanpinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshangjiacanpinEntity> page = this.selectPage(
                new Query<DiscussshangjiacanpinEntity>(params).getPage(),
                new EntityWrapper<DiscussshangjiacanpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshangjiacanpinEntity> wrapper) {
		  Page<DiscussshangjiacanpinView> page =new Query<DiscussshangjiacanpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussshangjiacanpinVO> selectListVO(Wrapper<DiscussshangjiacanpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussshangjiacanpinVO selectVO(Wrapper<DiscussshangjiacanpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussshangjiacanpinView> selectListView(Wrapper<DiscussshangjiacanpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshangjiacanpinView selectView(Wrapper<DiscussshangjiacanpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
