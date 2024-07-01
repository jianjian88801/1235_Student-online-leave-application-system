package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QingjiabiaogeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QingjiabiaogeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QingjiabiaogeView;


/**
 * 请假表格
 *
 * @author 
 * @email 
 * @date 2021-05-08 02:39:08
 */
public interface QingjiabiaogeService extends IService<QingjiabiaogeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QingjiabiaogeVO> selectListVO(Wrapper<QingjiabiaogeEntity> wrapper);
   	
   	QingjiabiaogeVO selectVO(@Param("ew") Wrapper<QingjiabiaogeEntity> wrapper);
   	
   	List<QingjiabiaogeView> selectListView(Wrapper<QingjiabiaogeEntity> wrapper);
   	
   	QingjiabiaogeView selectView(@Param("ew") Wrapper<QingjiabiaogeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QingjiabiaogeEntity> wrapper);
   	
}

