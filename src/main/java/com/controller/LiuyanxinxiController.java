package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.LiuyanxinxiEntity;

import com.service.LiuyanxinxiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 留言
 * 后端接口
 * @author
 * @email
 * @date 2021-04-08
*/
@RestController
@Controller
@RequestMapping("/liuyanxinxi")
public class LiuyanxinxiController {
    private static final Logger logger = LoggerFactory.getLogger(LiuyanxinxiController.class);

    @Autowired
    private LiuyanxinxiService liuyanxinxiService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = liuyanxinxiService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        LiuyanxinxiEntity liuyanxinxi = liuyanxinxiService.selectById(id);
        if(liuyanxinxi!=null){
            return R.ok().put("data", liuyanxinxi);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody LiuyanxinxiEntity liuyanxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<LiuyanxinxiEntity> queryWrapper = new EntityWrapper<LiuyanxinxiEntity>()
            .eq("note", liuyanxinxi.getNote())
            .eq("yhnote", liuyanxinxi.getYhnote())
            .eq("reply", liuyanxinxi.getReply())
            .eq("glreply", liuyanxinxi.getGlreply())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LiuyanxinxiEntity liuyanxinxiEntity = liuyanxinxiService.selectOne(queryWrapper);
            liuyanxinxi.setNoteTime(new Date());
            liuyanxinxi.setYhnote((String)request.getSession().getAttribute("username"));
        if(liuyanxinxiEntity==null){
            liuyanxinxiService.insert(liuyanxinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LiuyanxinxiEntity liuyanxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<LiuyanxinxiEntity> queryWrapper = new EntityWrapper<LiuyanxinxiEntity>()
            .notIn("id",liuyanxinxi.getId())
            .eq("note", liuyanxinxi.getNote())
            .eq("yhnote", liuyanxinxi.getYhnote())
            .eq("reply", liuyanxinxi.getReply())
            .eq("glreply", liuyanxinxi.getGlreply())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LiuyanxinxiEntity liuyanxinxiEntity = liuyanxinxiService.selectOne(queryWrapper);
                liuyanxinxi.setReplyTime(new Date());
                liuyanxinxi.setGlreply((String)request.getSession().getAttribute("username"));
        if(liuyanxinxiEntity==null){
            liuyanxinxiService.updateById(liuyanxinxi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        liuyanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

