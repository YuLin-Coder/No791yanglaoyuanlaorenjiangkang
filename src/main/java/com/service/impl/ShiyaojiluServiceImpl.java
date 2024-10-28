package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.ShiyaojiluDao;
import com.entity.ShiyaojiluEntity;
import com.service.ShiyaojiluService;
import com.entity.view.ShiyaojiluView;

/**
 * 食药记录 服务实现类
 * @since 2021-04-08
 */
@Service("shiyaojiluService")
@Transactional
public class ShiyaojiluServiceImpl extends ServiceImpl<ShiyaojiluDao, ShiyaojiluEntity> implements ShiyaojiluService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ShiyaojiluView> page =new Query<ShiyaojiluView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
