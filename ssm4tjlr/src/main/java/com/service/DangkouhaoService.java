package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DangkouhaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DangkouhaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DangkouhaoView;


/**
 * 档口号
 *
 * @author 
 * @email 
 * @date 2021-04-15 22:52:57
 */
public interface DangkouhaoService extends IService<DangkouhaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DangkouhaoVO> selectListVO(Wrapper<DangkouhaoEntity> wrapper);
   	
   	DangkouhaoVO selectVO(@Param("ew") Wrapper<DangkouhaoEntity> wrapper);
   	
   	List<DangkouhaoView> selectListView(Wrapper<DangkouhaoEntity> wrapper);
   	
   	DangkouhaoView selectView(@Param("ew") Wrapper<DangkouhaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DangkouhaoEntity> wrapper);
   	
}

