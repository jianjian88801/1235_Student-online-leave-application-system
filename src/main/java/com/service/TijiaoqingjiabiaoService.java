package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TijiaoqingjiabiaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TijiaoqingjiabiaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TijiaoqingjiabiaoView;


/**
 * 提交请假表
 *
 * @author 
 * @email 
 * @date 2021-05-08 02:39:08
 */
public interface TijiaoqingjiabiaoService extends IService<TijiaoqingjiabiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TijiaoqingjiabiaoVO> selectListVO(Wrapper<TijiaoqingjiabiaoEntity> wrapper);
   	
   	TijiaoqingjiabiaoVO selectVO(@Param("ew") Wrapper<TijiaoqingjiabiaoEntity> wrapper);
   	
   	List<TijiaoqingjiabiaoView> selectListView(Wrapper<TijiaoqingjiabiaoEntity> wrapper);
   	
   	TijiaoqingjiabiaoView selectView(@Param("ew") Wrapper<TijiaoqingjiabiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TijiaoqingjiabiaoEntity> wrapper);
   	
}

