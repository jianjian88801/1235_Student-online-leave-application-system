package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QuekejiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QuekejiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QuekejiluView;


/**
 * 缺课记录
 *
 * @author 
 * @email 
 * @date 2021-05-08 02:39:08
 */
public interface QuekejiluService extends IService<QuekejiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QuekejiluVO> selectListVO(Wrapper<QuekejiluEntity> wrapper);
   	
   	QuekejiluVO selectVO(@Param("ew") Wrapper<QuekejiluEntity> wrapper);
   	
   	List<QuekejiluView> selectListView(Wrapper<QuekejiluEntity> wrapper);
   	
   	QuekejiluView selectView(@Param("ew") Wrapper<QuekejiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QuekejiluEntity> wrapper);
   	
}

