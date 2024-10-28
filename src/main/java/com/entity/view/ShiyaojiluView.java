package com.entity.view;

import com.entity.ShiyaojiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 食药记录
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-04-08
 */
@TableName("shiyaojilu")
public class ShiyaojiluView extends ShiyaojiluEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public ShiyaojiluView() {

	}

	public ShiyaojiluView(ShiyaojiluEntity shiyaojiluEntity) {
		try {
			BeanUtils.copyProperties(this, shiyaojiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
