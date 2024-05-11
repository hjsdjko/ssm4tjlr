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

import com.entity.WodehuodongEntity;
import com.entity.view.WodehuodongView;

import com.service.WodehuodongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 我的活动
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-15 22:52:57
 */
@RestController
@RequestMapping("/wodehuodong")
public class WodehuodongController {
    @Autowired
    private WodehuodongService wodehuodongService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WodehuodongEntity wodehuodong, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wodehuodong.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WodehuodongEntity> ew = new EntityWrapper<WodehuodongEntity>();
		PageUtils page = wodehuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wodehuodong), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WodehuodongEntity wodehuodong, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wodehuodong.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WodehuodongEntity> ew = new EntityWrapper<WodehuodongEntity>();
		PageUtils page = wodehuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wodehuodong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WodehuodongEntity wodehuodong){
       	EntityWrapper<WodehuodongEntity> ew = new EntityWrapper<WodehuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wodehuodong, "wodehuodong")); 
        return R.ok().put("data", wodehuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WodehuodongEntity wodehuodong){
        EntityWrapper< WodehuodongEntity> ew = new EntityWrapper< WodehuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wodehuodong, "wodehuodong")); 
		WodehuodongView wodehuodongView =  wodehuodongService.selectView(ew);
		return R.ok("查询我的活动成功").put("data", wodehuodongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WodehuodongEntity wodehuodong = wodehuodongService.selectById(id);
        return R.ok().put("data", wodehuodong);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WodehuodongEntity wodehuodong = wodehuodongService.selectById(id);
        return R.ok().put("data", wodehuodong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WodehuodongEntity wodehuodong, HttpServletRequest request){
    	wodehuodong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wodehuodong);

        wodehuodongService.insert(wodehuodong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WodehuodongEntity wodehuodong, HttpServletRequest request){
    	wodehuodong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wodehuodong);
    	wodehuodong.setUserid((Long)request.getSession().getAttribute("userId"));

        wodehuodongService.insert(wodehuodong);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WodehuodongEntity wodehuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wodehuodong);
        wodehuodongService.updateById(wodehuodong);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wodehuodongService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<WodehuodongEntity> wrapper = new EntityWrapper<WodehuodongEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = wodehuodongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
