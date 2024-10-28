package com.entity.view;

import com.entity.TijianbingliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 体检病例
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-04-08
 */
@TableName("tijianbingli")
public class TijianbingliView extends TijianbingliEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public TijianbingliView() {

	}

	public TijianbingliView(TijianbingliEntity tijianbingliEntity) {
		try {
			BeanUtils.copyProperties(this, tijianbingliEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
