package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LiuyanxinxiEntity;
import java.util.Map;

/**
 * 留言 服务类
 * @since 2021-04-08
 */
public interface LiuyanxinxiService extends IService<LiuyanxinxiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}