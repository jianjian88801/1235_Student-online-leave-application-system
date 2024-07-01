package com.dao;

import com.entity.QuekejiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QuekejiluVO;
import com.entity.view.QuekejiluView;


/**
 * 缺课记录
 * 
 * @author 
 * @email 
 * @date 2021-05-08 02:39:08
 */
public interface QuekejiluDao extends BaseMapper<QuekejiluEntity> {
	
	List<QuekejiluVO> selectListVO(@Param("ew") Wrapper<QuekejiluEntity> wrapper);
	
	QuekejiluVO selectVO(@Param("ew") Wrapper<QuekejiluEntity> wrapper);
	
	List<QuekejiluView> selectListView(@Param("ew") Wrapper<QuekejiluEntity> wrapper);

	List<QuekejiluView> selectListView(Pagination page,@Param("ew") Wrapper<QuekejiluEntity> wrapper);
	
	QuekejiluView selectView(@Param("ew") Wrapper<QuekejiluEntity> wrapper);
	
}
