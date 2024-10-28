package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShiyaojiluEntity;
import java.util.Map;

/**
 * 食药记录 服务类
 * @since 2021-04-08
 */
public interface ShiyaojiluService extends IService<ShiyaojiluEntity> {

     PageUtils queryPage(Map<String, Object> params);

}