package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CanpinzhongleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CanpinzhongleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CanpinzhongleiView;


/**
 * 餐品种类
 *
 * @author 
 * @email 
 * @date 2021-04-15 22:52:57
 */
public interface CanpinzhongleiService extends IService<CanpinzhongleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CanpinzhongleiVO> selectListVO(Wrapper<CanpinzhongleiEntity> wrapper);
   	
   	CanpinzhongleiVO selectVO(@Param("ew") Wrapper<CanpinzhongleiEntity> wrapper);
   	
   	List<CanpinzhongleiView> selectListView(Wrapper<CanpinzhongleiEntity> wrapper);
   	
   	CanpinzhongleiView selectView(@Param("ew") Wrapper<CanpinzhongleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CanpinzhongleiEntity> wrapper);
   	
}

