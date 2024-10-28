package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.ShentizhibiaoDao;
import com.entity.ShentizhibiaoEntity;
import com.service.ShentizhibiaoService;
import com.entity.view.ShentizhibiaoView;

/**
 * 身体指标 服务实现类
 * @since 2021-04-08
 */
@Service("shentizhibiaoService")
@Transactional
public class ShentizhibiaoServiceImpl extends ServiceImpl<ShentizhibiaoDao, ShentizhibiaoEntity> implements ShentizhibiaoService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ShentizhibiaoView> page =new Query<ShentizhibiaoView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
