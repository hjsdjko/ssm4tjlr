package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GouwucheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GouwucheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GouwucheView;


/**
 * 购物车
 *
 * @author 
 * @email 
 * @date 2021-04-15 22:52:57
 */
public interface GouwucheService extends IService<GouwucheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GouwucheVO> selectListVO(Wrapper<GouwucheEntity> wrapper);
   	
   	GouwucheVO selectVO(@Param("ew") Wrapper<GouwucheEntity> wrapper);
   	
   	List<GouwucheView> selectListView(Wrapper<GouwucheEntity> wrapper);
   	
   	GouwucheView selectView(@Param("ew") Wrapper<GouwucheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GouwucheEntity> wrapper);
   	
}

