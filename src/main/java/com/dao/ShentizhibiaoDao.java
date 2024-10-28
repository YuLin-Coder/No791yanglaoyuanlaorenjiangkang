package com.dao;

import com.entity.ShentizhibiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShentizhibiaoView;

/**
 * 身体指标 Dao 接口
 *
 * @since 2021-04-08
 */
public interface ShentizhibiaoDao extends BaseMapper<ShentizhibiaoEntity> {

   List<ShentizhibiaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
