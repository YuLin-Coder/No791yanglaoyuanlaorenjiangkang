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
 * 食药记录
 *
 * @email
 * @date 2021-04-08
 */
@TableName("shiyaojilu")
public class ShiyaojiluEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public ShiyaojiluEntity() {

    }

    public ShiyaojiluEntity(T t) {
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
     * 名称
     */
    @TableField(value = "shiyaojilu_name")

    private String shiyaojiluName;


    /**
     * 类型
     */
    @TableField(value = "shiyaojilu_types")

    private Integer shiyaojiluTypes;


    /**
     * 详情
     */
    @TableField(value = "shiyaojilu_content")

    private String shiyaojiluContent;


    /**
     * 食用时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "shiyaojilu_time",fill = FieldFill.UPDATE)

    private Date shiyaojiluTime;


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
	 * 设置：名称
	 */
    public String getShiyaojiluName() {
        return shiyaojiluName;
    }


    /**
	 * 获取：名称
	 */

    public void setShiyaojiluName(String shiyaojiluName) {
        this.shiyaojiluName = shiyaojiluName;
    }
    /**
	 * 设置：类型
	 */
    public Integer getShiyaojiluTypes() {
        return shiyaojiluTypes;
    }


    /**
	 * 获取：类型
	 */

    public void setShiyaojiluTypes(Integer shiyaojiluTypes) {
        this.shiyaojiluTypes = shiyaojiluTypes;
    }
    /**
	 * 设置：详情
	 */
    public String getShiyaojiluContent() {
        return shiyaojiluContent;
    }


    /**
	 * 获取：详情
	 */

    public void setShiyaojiluContent(String shiyaojiluContent) {
        this.shiyaojiluContent = shiyaojiluContent;
    }
    /**
	 * 设置：食用时间
	 */
    public Date getShiyaojiluTime() {
        return shiyaojiluTime;
    }


    /**
	 * 获取：食用时间
	 */

    public void setShiyaojiluTime(Date shiyaojiluTime) {
        this.shiyaojiluTime = shiyaojiluTime;
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
    return "Shiyaojilu{" +
            "id=" + id +
            ", laorenTypes=" + laorenTypes +
            ", shiyaojiluName=" + shiyaojiluName +
            ", shiyaojiluTypes=" + shiyaojiluTypes +
            ", shiyaojiluContent=" + shiyaojiluContent +
            ", shiyaojiluTime=" + shiyaojiluTime +
            ", createTime=" + createTime +
    "}";
    }
    }
