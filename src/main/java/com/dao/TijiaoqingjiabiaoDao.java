package com.dao;

import com.entity.TijiaoqingjiabiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TijiaoqingjiabiaoVO;
import com.entity.view.TijiaoqingjiabiaoView;


/**
 * 提交请假表
 * 
 * @author 
 * @email 
 * @date 2021-05-08 02:39:08
 */
public interface TijiaoqingjiabiaoDao extends BaseMapper<TijiaoqingjiabiaoEntity> {
	
	List<TijiaoqingjiabiaoVO> selectListVO(@Param("ew") Wrapper<TijiaoqingjiabiaoEntity> wrapper);
	
	TijiaoqingjiabiaoVO selectVO(@Param("ew") Wrapper<TijiaoqingjiabiaoEntity> wrapper);
	
	List<TijiaoqingjiabiaoView> selectListView(@Param("ew") Wrapper<TijiaoqingjiabiaoEntity> wrapper);

	List<TijiaoqingjiabiaoView> selectListView(Pagination page,@Param("ew") Wrapper<TijiaoqingjiabiaoEntity> wrapper);
	
	TijiaoqingjiabiaoView selectView(@Param("ew") Wrapper<TijiaoqingjiabiaoEntity> wrapper);
	
}
