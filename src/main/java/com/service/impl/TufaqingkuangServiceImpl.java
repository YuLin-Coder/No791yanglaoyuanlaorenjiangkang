package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.TufaqingkuangDao;
import com.entity.TufaqingkuangEntity;
import com.service.TufaqingkuangService;
import com.entity.view.TufaqingkuangView;

/**
 * 突发情况 服务实现类
 * @since 2021-04-08
 */
@Service("tufaqingkuangService")
@Transactional
public class TufaqingkuangServiceImpl extends ServiceImpl<TufaqingkuangDao, TufaqingkuangEntity> implements TufaqingkuangService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<TufaqingkuangView> page =new Query<TufaqingkuangView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
