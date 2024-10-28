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

import com.entity.TufaqingkuangEntity;

import com.service.TufaqingkuangService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 突发情况
 * 后端接口
 * @author
 * @email
 * @date 2021-04-08
*/
@RestController
@Controller
@RequestMapping("/tufaqingkuang")
public class TufaqingkuangController {
    private static final Logger logger = LoggerFactory.getLogger(TufaqingkuangController.class);

    @Autowired
    private TufaqingkuangService tufaqingkuangService;

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
        PageUtils page = tufaqingkuangService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        TufaqingkuangEntity tufaqingkuang = tufaqingkuangService.selectById(id);
        if(tufaqingkuang!=null){
            return R.ok().put("data", tufaqingkuang);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody TufaqingkuangEntity tufaqingkuang, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<TufaqingkuangEntity> queryWrapper = new EntityWrapper<TufaqingkuangEntity>()
            .eq("laoren_types", tufaqingkuang.getLaorenTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TufaqingkuangEntity tufaqingkuangEntity = tufaqingkuangService.selectOne(queryWrapper);
            tufaqingkuang.setTijianbingliTime(new Date());
        if(tufaqingkuangEntity==null){
            tufaqingkuangService.insert(tufaqingkuang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TufaqingkuangEntity tufaqingkuang, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<TufaqingkuangEntity> queryWrapper = new EntityWrapper<TufaqingkuangEntity>()
            .notIn("id",tufaqingkuang.getId())
            .eq("laoren_types", tufaqingkuang.getLaorenTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TufaqingkuangEntity tufaqingkuangEntity = tufaqingkuangService.selectOne(queryWrapper);
                tufaqingkuang.setTijianbingliTime(new Date());
        if(tufaqingkuangEntity==null){
            tufaqingkuangService.updateById(tufaqingkuang);//根据id更新
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
        tufaqingkuangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

