package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LaorenEntity;
import java.util.Map;

/**
 * 老人 服务类
 * @since 2021-04-08
 */
public interface LaorenService extends IService<LaorenEntity> {

     PageUtils queryPage(Map<String, Object> params);

}