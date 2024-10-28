package com.dao;

import com.entity.TufaqingkuangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TufaqingkuangView;

/**
 * 突发情况 Dao 接口
 *
 * @since 2021-04-08
 */
public interface TufaqingkuangDao extends BaseMapper<TufaqingkuangEntity> {

   List<TufaqingkuangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
