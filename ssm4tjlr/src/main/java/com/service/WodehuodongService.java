package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WodehuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WodehuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WodehuodongView;


/**
 * 我的活动
 *
 * @author 
 * @email 
 * @date 2021-04-15 22:52:57
 */
public interface WodehuodongService extends IService<WodehuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WodehuodongVO> selectListVO(Wrapper<WodehuodongEntity> wrapper);
   	
   	WodehuodongVO selectVO(@Param("ew") Wrapper<WodehuodongEntity> wrapper);
   	
   	List<WodehuodongView> selectListView(Wrapper<WodehuodongEntity> wrapper);
   	
   	WodehuodongView selectView(@Param("ew") Wrapper<WodehuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WodehuodongEntity> wrapper);
   	
}

