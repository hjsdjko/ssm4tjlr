package com.entity.view;

import com.entity.DiscussshangjiacanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 商家餐品评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-15 22:52:57
 */
@TableName("discussshangjiacanpin")
public class DiscussshangjiacanpinView  extends DiscussshangjiacanpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussshangjiacanpinView(){
	}
 
 	public DiscussshangjiacanpinView(DiscussshangjiacanpinEntity discussshangjiacanpinEntity){
 	try {
			BeanUtils.copyProperties(this, discussshangjiacanpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
