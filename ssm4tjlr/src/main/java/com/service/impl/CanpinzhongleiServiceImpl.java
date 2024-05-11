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


import com.dao.CanpinzhongleiDao;
import com.entity.CanpinzhongleiEntity;
import com.service.CanpinzhongleiService;
import com.entity.vo.CanpinzhongleiVO;
import com.entity.view.CanpinzhongleiView;

@Service("canpinzhongleiService")
public class CanpinzhongleiServiceImpl extends ServiceImpl<CanpinzhongleiDao, CanpinzhongleiEntity> implements CanpinzhongleiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CanpinzhongleiEntity> page = this.selectPage(
                new Query<CanpinzhongleiEntity>(params).getPage(),
                new EntityWrapper<CanpinzhongleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CanpinzhongleiEntity> wrapper) {
		  Page<CanpinzhongleiView> page =new Query<CanpinzhongleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CanpinzhongleiVO> selectListVO(Wrapper<CanpinzhongleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CanpinzhongleiVO selectVO(Wrapper<CanpinzhongleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CanpinzhongleiView> selectListView(Wrapper<CanpinzhongleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CanpinzhongleiView selectView(Wrapper<CanpinzhongleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
