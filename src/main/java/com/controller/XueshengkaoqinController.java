package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.XueshengkaoqinEntity;
import com.entity.view.XueshengkaoqinView;

import com.service.XueshengkaoqinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 学生考勤
 * 后端接口
 * @author 
 * @email 
 * @date 2021-05-08 02:39:08
 */
@RestController
@RequestMapping("/xueshengkaoqin")
public class XueshengkaoqinController {
    @Autowired
    private XueshengkaoqinService xueshengkaoqinService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueshengkaoqinEntity xueshengkaoqin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xueshengkaoqin.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			xueshengkaoqin.setJiaoshizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XueshengkaoqinEntity> ew = new EntityWrapper<XueshengkaoqinEntity>();
		PageUtils page = xueshengkaoqinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengkaoqin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueshengkaoqinEntity xueshengkaoqin, 
		HttpServletRequest request){
        EntityWrapper<XueshengkaoqinEntity> ew = new EntityWrapper<XueshengkaoqinEntity>();
		PageUtils page = xueshengkaoqinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengkaoqin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueshengkaoqinEntity xueshengkaoqin){
       	EntityWrapper<XueshengkaoqinEntity> ew = new EntityWrapper<XueshengkaoqinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueshengkaoqin, "xueshengkaoqin")); 
        return R.ok().put("data", xueshengkaoqinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueshengkaoqinEntity xueshengkaoqin){
        EntityWrapper< XueshengkaoqinEntity> ew = new EntityWrapper< XueshengkaoqinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueshengkaoqin, "xueshengkaoqin")); 
		XueshengkaoqinView xueshengkaoqinView =  xueshengkaoqinService.selectView(ew);
		return R.ok("查询学生考勤成功").put("data", xueshengkaoqinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueshengkaoqinEntity xueshengkaoqin = xueshengkaoqinService.selectById(id);
        return R.ok().put("data", xueshengkaoqin);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueshengkaoqinEntity xueshengkaoqin = xueshengkaoqinService.selectById(id);
        return R.ok().put("data", xueshengkaoqin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueshengkaoqinEntity xueshengkaoqin, HttpServletRequest request){
    	xueshengkaoqin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengkaoqin);
        xueshengkaoqinService.insert(xueshengkaoqin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XueshengkaoqinEntity xueshengkaoqin, HttpServletRequest request){
    	xueshengkaoqin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengkaoqin);
        xueshengkaoqinService.insert(xueshengkaoqin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody XueshengkaoqinEntity xueshengkaoqin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueshengkaoqin);
        xueshengkaoqinService.updateById(xueshengkaoqin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueshengkaoqinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<XueshengkaoqinEntity> wrapper = new EntityWrapper<XueshengkaoqinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			wrapper.eq("jiaoshizhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = xueshengkaoqinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
