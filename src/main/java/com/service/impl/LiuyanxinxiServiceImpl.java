package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.LiuyanxinxiDao;
import com.entity.LiuyanxinxiEntity;
import com.service.LiuyanxinxiService;
import com.entity.view.LiuyanxinxiView;

/**
 * 留言 服务实现类
 * @since 2021-04-08
 */
@Service("liuyanxinxiService")
@Transactional
public class LiuyanxinxiServiceImpl extends ServiceImpl<LiuyanxinxiDao, LiuyanxinxiEntity> implements LiuyanxinxiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<LiuyanxinxiView> page =new Query<LiuyanxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
