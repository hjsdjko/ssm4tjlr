package com.dao;

import com.entity.DangkouhaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DangkouhaoVO;
import com.entity.view.DangkouhaoView;


/**
 * 档口号
 * 
 * @author 
 * @email 
 * @date 2021-04-15 22:52:57
 */
public interface DangkouhaoDao extends BaseMapper<DangkouhaoEntity> {
	
	List<DangkouhaoVO> selectListVO(@Param("ew") Wrapper<DangkouhaoEntity> wrapper);
	
	DangkouhaoVO selectVO(@Param("ew") Wrapper<DangkouhaoEntity> wrapper);
	
	List<DangkouhaoView> selectListView(@Param("ew") Wrapper<DangkouhaoEntity> wrapper);

	List<DangkouhaoView> selectListView(Pagination page,@Param("ew") Wrapper<DangkouhaoEntity> wrapper);
	
	DangkouhaoView selectView(@Param("ew") Wrapper<DangkouhaoEntity> wrapper);
	
}
