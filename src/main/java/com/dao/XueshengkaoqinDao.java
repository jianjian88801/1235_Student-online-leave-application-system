package com.dao;

import com.entity.XueshengkaoqinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XueshengkaoqinVO;
import com.entity.view.XueshengkaoqinView;


/**
 * 学生考勤
 * 
 * @author 
 * @email 
 * @date 2021-05-08 02:39:08
 */
public interface XueshengkaoqinDao extends BaseMapper<XueshengkaoqinEntity> {
	
	List<XueshengkaoqinVO> selectListVO(@Param("ew") Wrapper<XueshengkaoqinEntity> wrapper);
	
	XueshengkaoqinVO selectVO(@Param("ew") Wrapper<XueshengkaoqinEntity> wrapper);
	
	List<XueshengkaoqinView> selectListView(@Param("ew") Wrapper<XueshengkaoqinEntity> wrapper);

	List<XueshengkaoqinView> selectListView(Pagination page,@Param("ew") Wrapper<XueshengkaoqinEntity> wrapper);
	
	XueshengkaoqinView selectView(@Param("ew") Wrapper<XueshengkaoqinEntity> wrapper);
	
}
