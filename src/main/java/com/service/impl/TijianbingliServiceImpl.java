package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.TijianbingliDao;
import com.entity.TijianbingliEntity;
import com.service.TijianbingliService;
import com.entity.view.TijianbingliView;

/**
 * 体检病例 服务实现类
 * @since 2021-04-08
 */
@Service("tijianbingliService")
@Transactional
public class TijianbingliServiceImpl extends ServiceImpl<TijianbingliDao, TijianbingliEntity> implements TijianbingliService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<TijianbingliView> page =new Query<TijianbingliView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
