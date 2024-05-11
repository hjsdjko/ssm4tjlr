package com.dao;

import com.entity.ShangjiacanpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShangjiacanpinVO;
import com.entity.view.ShangjiacanpinView;


/**
 * 商家餐品
 * 
 * @author 
 * @email 
 * @date 2021-04-15 22:52:57
 */
public interface ShangjiacanpinDao extends BaseMapper<ShangjiacanpinEntity> {
	
	List<ShangjiacanpinVO> selectListVO(@Param("ew") Wrapper<ShangjiacanpinEntity> wrapper);
	
	ShangjiacanpinVO selectVO(@Param("ew") Wrapper<ShangjiacanpinEntity> wrapper);
	
	List<ShangjiacanpinView> selectListView(@Param("ew") Wrapper<ShangjiacanpinEntity> wrapper);

	List<ShangjiacanpinView> selectListView(Pagination page,@Param("ew") Wrapper<ShangjiacanpinEntity> wrapper);
	
	ShangjiacanpinView selectView(@Param("ew") Wrapper<ShangjiacanpinEntity> wrapper);
	
}
