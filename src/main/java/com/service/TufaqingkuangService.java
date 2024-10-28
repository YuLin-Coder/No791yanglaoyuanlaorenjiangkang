package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TufaqingkuangEntity;
import java.util.Map;

/**
 * 突发情况 服务类
 * @since 2021-04-08
 */
public interface TufaqingkuangService extends IService<TufaqingkuangEntity> {

     PageUtils queryPage(Map<String, Object> params);

}