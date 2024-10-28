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

import com.entity.LaorenEntity;

import com.service.LaorenService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 老人
 * 后端接口
 * @author
 * @email
 * @date 2021-04-08
*/
@RestController
@Controller
@RequestMapping("/laoren")
public class LaorenController {
    private static final Logger logger = LoggerFactory.getLogger(LaorenController.class);

    @Autowired
    private LaorenService laorenService;

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
            params.put("laorenId",userId.getLaorenTypes());
        }
        PageUtils page = laorenService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        LaorenEntity laoren = laorenService.selectById(id);
        if(laoren!=null){
            return R.ok().put("data", laoren);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody LaorenEntity laoren, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<LaorenEntity> queryWrapper = new EntityWrapper<LaorenEntity>()
            .eq("laoren_name", laoren.getLaorenName())
            .eq("sex_types", laoren.getSexTypes())
            .eq("laoren_age", laoren.getLaorenAge())
            .eq("laoren_phone", laoren.getLaorenPhone())
            .eq("laoren_id_number", laoren.getLaorenIdNumber())
            .eq("laoren_content", laoren.getLaorenContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaorenEntity laorenEntity = laorenService.selectOne(queryWrapper);
        if("".equals(laoren.getLaorenPhoto()) || "null".equals(laoren.getLaorenPhoto())){
            laoren.setLaorenPhoto(null);
        }
            laoren.setLaorenTime(new Date());
        if(laorenEntity==null){
            laorenService.insert(laoren);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LaorenEntity laoren, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<LaorenEntity> queryWrapper = new EntityWrapper<LaorenEntity>()
            .notIn("id",laoren.getId())
            .eq("laoren_name", laoren.getLaorenName())
            .eq("sex_types", laoren.getSexTypes())
            .eq("laoren_age", laoren.getLaorenAge())
            .eq("laoren_phone", laoren.getLaorenPhone())
            .eq("laoren_id_number", laoren.getLaorenIdNumber())
            .eq("laoren_content", laoren.getLaorenContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaorenEntity laorenEntity = laorenService.selectOne(queryWrapper);
        if("".equals(laoren.getLaorenPhoto()) || "null".equals(laoren.getLaorenPhoto())){
                laoren.setLaorenPhoto(null);
        }
                laoren.setLaorenTime(new Date());
        if(laorenEntity==null){
            laorenService.updateById(laoren);//根据id更新
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
        laorenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

