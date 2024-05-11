package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShangjiacanpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShangjiacanpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangjiacanpinView;


/**
 * 商家餐品
 *
 * @author 
 * @email 
 * @date 2021-04-15 22:52:57
 */
public interface ShangjiacanpinService extends IService<ShangjiacanpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShangjiacanpinVO> selectListVO(Wrapper<ShangjiacanpinEntity> wrapper);
   	
   	ShangjiacanpinVO selectVO(@Param("ew") Wrapper<ShangjiacanpinEntity> wrapper);
   	
   	List<ShangjiacanpinView> selectListView(Wrapper<ShangjiacanpinEntity> wrapper);
   	
   	ShangjiacanpinView selectView(@Param("ew") Wrapper<ShangjiacanpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangjiacanpinEntity> wrapper);
   	
}

