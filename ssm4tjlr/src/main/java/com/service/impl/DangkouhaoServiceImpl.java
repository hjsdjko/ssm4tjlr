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


import com.dao.DangkouhaoDao;
import com.entity.DangkouhaoEntity;
import com.service.DangkouhaoService;
import com.entity.vo.DangkouhaoVO;
import com.entity.view.DangkouhaoView;

@Service("dangkouhaoService")
public class DangkouhaoServiceImpl extends ServiceImpl<DangkouhaoDao, DangkouhaoEntity> implements DangkouhaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DangkouhaoEntity> page = this.selectPage(
                new Query<DangkouhaoEntity>(params).getPage(),
                new EntityWrapper<DangkouhaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DangkouhaoEntity> wrapper) {
		  Page<DangkouhaoView> page =new Query<DangkouhaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DangkouhaoVO> selectListVO(Wrapper<DangkouhaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DangkouhaoVO selectVO(Wrapper<DangkouhaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DangkouhaoView> selectListView(Wrapper<DangkouhaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DangkouhaoView selectView(Wrapper<DangkouhaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
