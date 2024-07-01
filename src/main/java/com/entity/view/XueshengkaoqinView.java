package com.entity.view;

import com.entity.XueshengkaoqinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 学生考勤
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-08 02:39:08
 */
@TableName("xueshengkaoqin")
public class XueshengkaoqinView  extends XueshengkaoqinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XueshengkaoqinView(){
	}
 
 	public XueshengkaoqinView(XueshengkaoqinEntity xueshengkaoqinEntity){
 	try {
			BeanUtils.copyProperties(this, xueshengkaoqinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
