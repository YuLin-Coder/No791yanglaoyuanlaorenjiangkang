package com.entity.view;

import com.entity.TufaqingkuangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 突发情况
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-04-08
 */
@TableName("tufaqingkuang")
public class TufaqingkuangView extends TufaqingkuangEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public TufaqingkuangView() {

	}

	public TufaqingkuangView(TufaqingkuangEntity tufaqingkuangEntity) {
		try {
			BeanUtils.copyProperties(this, tufaqingkuangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
