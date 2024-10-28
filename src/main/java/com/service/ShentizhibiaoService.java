package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShentizhibiaoEntity;
import java.util.Map;

/**
 * 身体指标 服务类
 * @since 2021-04-08
 */
public interface ShentizhibiaoService extends IService<ShentizhibiaoEntity> {

     PageUtils queryPage(Map<String, Object> params);

}