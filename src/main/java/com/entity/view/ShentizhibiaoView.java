package com.entity.view;

import com.entity.ShentizhibiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 身体指标
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-04-08
 */
@TableName("shentizhibiao")
public class ShentizhibiaoView extends ShentizhibiaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public ShentizhibiaoView() {

	}

	public ShentizhibiaoView(ShentizhibiaoEntity shentizhibiaoEntity) {
		try {
			BeanUtils.copyProperties(this, shentizhibiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
