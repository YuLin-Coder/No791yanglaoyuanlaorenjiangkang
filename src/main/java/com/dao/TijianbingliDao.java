package com.dao;

import com.entity.TijianbingliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TijianbingliView;

/**
 * 体检病例 Dao 接口
 *
 * @since 2021-04-08
 */
public interface TijianbingliDao extends BaseMapper<TijianbingliEntity> {

   List<TijianbingliView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
