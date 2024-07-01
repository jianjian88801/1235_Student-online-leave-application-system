package com.entity.view;

import com.entity.TijiaoqingjiabiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 提交请假表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-08 02:39:08
 */
@TableName("tijiaoqingjiabiao")
public class TijiaoqingjiabiaoView  extends TijiaoqingjiabiaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TijiaoqingjiabiaoView(){
	}
 
 	public TijiaoqingjiabiaoView(TijiaoqingjiabiaoEntity tijiaoqingjiabiaoEntity){
 	try {
			BeanUtils.copyProperties(this, tijiaoqingjiabiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
