package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussshangjiacanpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussshangjiacanpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussshangjiacanpinView;


/**
 * 商家餐品评论表
 *
 * @author 
 * @email 
 * @date 2021-04-15 22:52:57
 */
public interface DiscussshangjiacanpinService extends IService<DiscussshangjiacanpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshangjiacanpinVO> selectListVO(Wrapper<DiscussshangjiacanpinEntity> wrapper);
   	
   	DiscussshangjiacanpinVO selectVO(@Param("ew") Wrapper<DiscussshangjiacanpinEntity> wrapper);
   	
   	List<DiscussshangjiacanpinView> selectListView(Wrapper<DiscussshangjiacanpinEntity> wrapper);
   	
   	DiscussshangjiacanpinView selectView(@Param("ew") Wrapper<DiscussshangjiacanpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshangjiacanpinEntity> wrapper);
   	
}

