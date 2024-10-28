package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 突发情况
 *
 * @email
 * @date 2021-04-08
 */
@TableName("tufaqingkuang")
public class TufaqingkuangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public TufaqingkuangEntity() {

    }

    public TufaqingkuangEntity(T t) {
    try {
    BeanUtils.copyProperties(this, t);
    } catch (IllegalAccessException | InvocationTargetException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    }


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 老人
     */
    @TableField(value = "laoren_types")

    private Integer laorenTypes;


    /**
     * 突发情况
     */
    @TableField(value = "tijianbingli_name")

    private String tijianbingliName;


    /**
     * 详情信息
     */
    @TableField(value = "tijianbingli_content")

    private String tijianbingliContent;


    /**
     * 发生时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "tijianbingli_time",fill = FieldFill.UPDATE)

    private Date tijianbingliTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：老人
	 */
    public Integer getLaorenTypes() {
        return laorenTypes;
    }


    /**
	 * 获取：老人
	 */

    public void setLaorenTypes(Integer laorenTypes) {
        this.laorenTypes = laorenTypes;
    }
    /**
	 * 设置：突发情况
	 */
    public String getTijianbingliName() {
        return tijianbingliName;
    }


    /**
	 * 获取：突发情况
	 */

    public void setTijianbingliName(String tijianbingliName) {
        this.tijianbingliName = tijianbingliName;
    }
    /**
	 * 设置：详情信息
	 */
    public String getTijianbingliContent() {
        return tijianbingliContent;
    }


    /**
	 * 获取：详情信息
	 */

    public void setTijianbingliContent(String tijianbingliContent) {
        this.tijianbingliContent = tijianbingliContent;
    }
    /**
	 * 设置：发生时间
	 */
    public Date getTijianbingliTime() {
        return tijianbingliTime;
    }


    /**
	 * 获取：发生时间
	 */

    public void setTijianbingliTime(Date tijianbingliTime) {
        this.tijianbingliTime = tijianbingliTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
    return "Tufaqingkuang{" +
            "id=" + id +
            ", laorenTypes=" + laorenTypes +
            ", tijianbingliName=" + tijianbingliName +
            ", tijianbingliContent=" + tijianbingliContent +
            ", tijianbingliTime=" + tijianbingliTime +
            ", createTime=" + createTime +
    "}";
    }
    }
