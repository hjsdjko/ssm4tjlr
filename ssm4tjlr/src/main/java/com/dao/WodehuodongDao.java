package com.dao;

import com.entity.WodehuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WodehuodongVO;
import com.entity.view.WodehuodongView;


/**
 * 我的活动
 * 
 * @author 
 * @email 
 * @date 2021-04-15 22:52:57
 */
public interface WodehuodongDao extends BaseMapper<WodehuodongEntity> {
	
	List<WodehuodongVO> selectListVO(@Param("ew") Wrapper<WodehuodongEntity> wrapper);
	
	WodehuodongVO selectVO(@Param("ew") Wrapper<WodehuodongEntity> wrapper);
	
	List<WodehuodongView> selectListView(@Param("ew") Wrapper<WodehuodongEntity> wrapper);

	List<WodehuodongView> selectListView(Pagination page,@Param("ew") Wrapper<WodehuodongEntity> wrapper);
	
	WodehuodongView selectView(@Param("ew") Wrapper<WodehuodongEntity> wrapper);
	
}
