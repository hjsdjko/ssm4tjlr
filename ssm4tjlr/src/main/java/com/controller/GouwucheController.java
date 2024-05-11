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

import com.entity.GouwucheEntity;
import com.entity.view.GouwucheView;

import com.service.GouwucheService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 购物车
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-15 22:52:57
 */
@RestController
@RequestMapping("/gouwuche")
public class GouwucheController {
    @Autowired
    private GouwucheService gouwucheService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GouwucheEntity gouwuche, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			gouwuche.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			gouwuche.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GouwucheEntity> ew = new EntityWrapper<GouwucheEntity>();
		PageUtils page = gouwucheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gouwuche), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GouwucheEntity gouwuche, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			gouwuche.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			gouwuche.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GouwucheEntity> ew = new EntityWrapper<GouwucheEntity>();
		PageUtils page = gouwucheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gouwuche), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GouwucheEntity gouwuche){
       	EntityWrapper<GouwucheEntity> ew = new EntityWrapper<GouwucheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gouwuche, "gouwuche")); 
        return R.ok().put("data", gouwucheService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GouwucheEntity gouwuche){
        EntityWrapper< GouwucheEntity> ew = new EntityWrapper< GouwucheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gouwuche, "gouwuche")); 
		GouwucheView gouwucheView =  gouwucheService.selectView(ew);
		return R.ok("查询购物车成功").put("data", gouwucheView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GouwucheEntity gouwuche = gouwucheService.selectById(id);
        return R.ok().put("data", gouwuche);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GouwucheEntity gouwuche = gouwucheService.selectById(id);
        return R.ok().put("data", gouwuche);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GouwucheEntity gouwuche, HttpServletRequest request){
    	gouwuche.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gouwuche);

        gouwucheService.insert(gouwuche);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GouwucheEntity gouwuche, HttpServletRequest request){
    	gouwuche.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gouwuche);
    	gouwuche.setUserid((Long)request.getSession().getAttribute("userId"));

        gouwucheService.insert(gouwuche);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GouwucheEntity gouwuche, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gouwuche);
        gouwucheService.updateById(gouwuche);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gouwucheService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GouwucheEntity> wrapper = new EntityWrapper<GouwucheEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			wrapper.eq("shangjiazhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = gouwucheService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
