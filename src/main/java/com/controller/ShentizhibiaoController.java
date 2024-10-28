package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.YonghuEntity;
import com.service.YonghuService;
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

import com.entity.ShentizhibiaoEntity;

import com.service.ShentizhibiaoService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 身体指标
 * 后端接口
 * @author
 * @email
 * @date 2021-04-08
*/
@RestController
@Controller
@RequestMapping("/shentizhibiao")
public class ShentizhibiaoController {
    private static final Logger logger = LoggerFactory.getLogger(ShentizhibiaoController.class);

    @Autowired
    private ShentizhibiaoService shentizhibiaoService;

    @Autowired
    private YonghuService yonghuService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        YonghuEntity userId = yonghuService.selectById((Integer) request.getSession().getAttribute("userId"));
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        if(request.getSession().getAttribute("role").equals("用户")){
            params.put("laorenTypes",userId.getLaorenTypes());
        }
        PageUtils page = shentizhibiaoService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        ShentizhibiaoEntity shentizhibiao = shentizhibiaoService.selectById(id);
        if(shentizhibiao!=null){
            return R.ok().put("data", shentizhibiao);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShentizhibiaoEntity shentizhibiao, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<ShentizhibiaoEntity> queryWrapper = new EntityWrapper<ShentizhibiaoEntity>()
            .eq("laoren_types", shentizhibiao.getLaorenTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShentizhibiaoEntity shentizhibiaoEntity = shentizhibiaoService.selectOne(queryWrapper);
            shentizhibiao.setShentizhibiaoTime(new Date());
        if(shentizhibiaoEntity==null){
            shentizhibiaoService.insert(shentizhibiao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShentizhibiaoEntity shentizhibiao, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<ShentizhibiaoEntity> queryWrapper = new EntityWrapper<ShentizhibiaoEntity>()
            .notIn("id",shentizhibiao.getId())
            .eq("laoren_types", shentizhibiao.getLaorenTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShentizhibiaoEntity shentizhibiaoEntity = shentizhibiaoService.selectOne(queryWrapper);
                shentizhibiao.setShentizhibiaoTime(new Date());
        if(shentizhibiaoEntity==null){
            shentizhibiaoService.updateById(shentizhibiao);//根据id更新
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
        shentizhibiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

