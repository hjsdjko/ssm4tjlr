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

import com.entity.ShangjiacanpinEntity;
import com.entity.view.ShangjiacanpinView;

import com.service.ShangjiacanpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 商家餐品
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-15 22:52:57
 */
@RestController
@RequestMapping("/shangjiacanpin")
public class ShangjiacanpinController {
    @Autowired
    private ShangjiacanpinService shangjiacanpinService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShangjiacanpinEntity shangjiacanpin, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			shangjiacanpin.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShangjiacanpinEntity> ew = new EntityWrapper<ShangjiacanpinEntity>();
		PageUtils page = shangjiacanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangjiacanpin), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShangjiacanpinEntity shangjiacanpin, HttpServletRequest request){
        EntityWrapper<ShangjiacanpinEntity> ew = new EntityWrapper<ShangjiacanpinEntity>();
		PageUtils page = shangjiacanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangjiacanpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShangjiacanpinEntity shangjiacanpin){
       	EntityWrapper<ShangjiacanpinEntity> ew = new EntityWrapper<ShangjiacanpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shangjiacanpin, "shangjiacanpin")); 
        return R.ok().put("data", shangjiacanpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShangjiacanpinEntity shangjiacanpin){
        EntityWrapper< ShangjiacanpinEntity> ew = new EntityWrapper< ShangjiacanpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shangjiacanpin, "shangjiacanpin")); 
		ShangjiacanpinView shangjiacanpinView =  shangjiacanpinService.selectView(ew);
		return R.ok("查询商家餐品成功").put("data", shangjiacanpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShangjiacanpinEntity shangjiacanpin = shangjiacanpinService.selectById(id);
		shangjiacanpin.setClicknum(shangjiacanpin.getClicknum()+1);
		shangjiacanpin.setClicktime(new Date());
		shangjiacanpinService.updateById(shangjiacanpin);
        return R.ok().put("data", shangjiacanpin);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShangjiacanpinEntity shangjiacanpin = shangjiacanpinService.selectById(id);
		shangjiacanpin.setClicknum(shangjiacanpin.getClicknum()+1);
		shangjiacanpin.setClicktime(new Date());
		shangjiacanpinService.updateById(shangjiacanpin);
        return R.ok().put("data", shangjiacanpin);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        ShangjiacanpinEntity shangjiacanpin = shangjiacanpinService.selectById(id);
        if(type.equals("1")) {
        	shangjiacanpin.setThumbsupnum(shangjiacanpin.getThumbsupnum()+1);
        } else {
        	shangjiacanpin.setCrazilynum(shangjiacanpin.getCrazilynum()+1);
        }
        shangjiacanpinService.updateById(shangjiacanpin);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShangjiacanpinEntity shangjiacanpin, HttpServletRequest request){
    	shangjiacanpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangjiacanpin);

        shangjiacanpinService.insert(shangjiacanpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShangjiacanpinEntity shangjiacanpin, HttpServletRequest request){
    	shangjiacanpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangjiacanpin);

        shangjiacanpinService.insert(shangjiacanpin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ShangjiacanpinEntity shangjiacanpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangjiacanpin);
        shangjiacanpinService.updateById(shangjiacanpin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shangjiacanpinService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ShangjiacanpinEntity> wrapper = new EntityWrapper<ShangjiacanpinEntity>();
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

		int count = shangjiacanpinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ShangjiacanpinEntity shangjiacanpin, HttpServletRequest request,String pre){
        EntityWrapper<ShangjiacanpinEntity> ew = new EntityWrapper<ShangjiacanpinEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = shangjiacanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangjiacanpin), params), params));
        return R.ok().put("data", page);
    }


}
