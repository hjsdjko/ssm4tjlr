package com.dao;

import com.entity.DiscussshangjiacanpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussshangjiacanpinVO;
import com.entity.view.DiscussshangjiacanpinView;


/**
 * 商家餐品评论表
 * 
 * @author 
 * @email 
 * @date 2021-04-15 22:52:57
 */
public interface DiscussshangjiacanpinDao extends BaseMapper<DiscussshangjiacanpinEntity> {
	
	List<DiscussshangjiacanpinVO> selectListVO(@Param("ew") Wrapper<DiscussshangjiacanpinEntity> wrapper);
	
	DiscussshangjiacanpinVO selectVO(@Param("ew") Wrapper<DiscussshangjiacanpinEntity> wrapper);
	
	List<DiscussshangjiacanpinView> selectListView(@Param("ew") Wrapper<DiscussshangjiacanpinEntity> wrapper);

	List<DiscussshangjiacanpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshangjiacanpinEntity> wrapper);
	
	DiscussshangjiacanpinView selectView(@Param("ew") Wrapper<DiscussshangjiacanpinEntity> wrapper);
	
}
