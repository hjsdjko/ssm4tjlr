package com.entity.view;

import com.entity.DangkouhaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 档口号
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-15 22:52:57
 */
@TableName("dangkouhao")
public class DangkouhaoView  extends DangkouhaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DangkouhaoView(){
	}
 
 	public DangkouhaoView(DangkouhaoEntity dangkouhaoEntity){
 	try {
			BeanUtils.copyProperties(this, dangkouhaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
