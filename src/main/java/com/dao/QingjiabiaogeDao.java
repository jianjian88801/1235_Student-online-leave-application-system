package com.dao;

import com.entity.QingjiabiaogeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QingjiabiaogeVO;
import com.entity.view.QingjiabiaogeView;


/**
 * 请假表格
 * 
 * @author 
 * @email 
 * @date 2021-05-08 02:39:08
 */
public interface QingjiabiaogeDao extends BaseMapper<QingjiabiaogeEntity> {
	
	List<QingjiabiaogeVO> selectListVO(@Param("ew") Wrapper<QingjiabiaogeEntity> wrapper);
	
	QingjiabiaogeVO selectVO(@Param("ew") Wrapper<QingjiabiaogeEntity> wrapper);
	
	List<QingjiabiaogeView> selectListView(@Param("ew") Wrapper<QingjiabiaogeEntity> wrapper);

	List<QingjiabiaogeView> selectListView(Pagination page,@Param("ew") Wrapper<QingjiabiaogeEntity> wrapper);
	
	QingjiabiaogeView selectView(@Param("ew") Wrapper<QingjiabiaogeEntity> wrapper);
	
}
