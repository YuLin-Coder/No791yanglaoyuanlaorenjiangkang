package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TijianbingliEntity;
import java.util.Map;

/**
 * 体检病例 服务类
 * @since 2021-04-08
 */
public interface TijianbingliService extends IService<TijianbingliEntity> {

     PageUtils queryPage(Map<String, Object> params);

}