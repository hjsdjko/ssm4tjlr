package com.dao;

import com.entity.CanpinzhongleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CanpinzhongleiVO;
import com.entity.view.CanpinzhongleiView;


/**
 * 餐品种类
 * 
 * @author 
 * @email 
 * @date 2021-04-15 22:52:57
 */
public interface CanpinzhongleiDao extends BaseMapper<CanpinzhongleiEntity> {
	
	List<CanpinzhongleiVO> selectListVO(@Param("ew") Wrapper<CanpinzhongleiEntity> wrapper);
	
	CanpinzhongleiVO selectVO(@Param("ew") Wrapper<CanpinzhongleiEntity> wrapper);
	
	List<CanpinzhongleiView> selectListView(@Param("ew") Wrapper<CanpinzhongleiEntity> wrapper);

	List<CanpinzhongleiView> selectListView(Pagination page,@Param("ew") Wrapper<CanpinzhongleiEntity> wrapper);
	
	CanpinzhongleiView selectView(@Param("ew") Wrapper<CanpinzhongleiEntity> wrapper);
	
}
