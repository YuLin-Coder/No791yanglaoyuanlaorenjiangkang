package com.dao;

import com.entity.ShiyaojiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShiyaojiluView;

/**
 * 食药记录 Dao 接口
 *
 * @since 2021-04-08
 */
public interface ShiyaojiluDao extends BaseMapper<ShiyaojiluEntity> {

   List<ShiyaojiluView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
