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
 * 身体指标
 *
 * @email
 * @date 2021-04-08
 */
@TableName("shentizhibiao")
public class ShentizhibiaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public ShentizhibiaoEntity() {

    }

    public ShentizhibiaoEntity(T t) {
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
     * 体温
     */
    @TableField(value = "shentizhibiao_tiwen")

    private String shentizhibiaoTiwen;


    /**
     * 血压
     */
    @TableField(value = "shentizhibiao_xieya")

    private String shentizhibiaoXieya;


    /**
     * 血糖
     */
    @TableField(value = "shentizhibiao_xietang")

    private String shentizhibiaoXietang;


    /**
     * 心率
     */
    @TableField(value = "shentizhibiao_xinlu")

    private String shentizhibiaoXinlu;


    /**
     * 测试时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "shentizhibiao_time",fill = FieldFill.UPDATE)

    private Date shentizhibiaoTime;


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
	 * 设置：体温
	 */
    public String getShentizhibiaoTiwen() {
        return shentizhibiaoTiwen;
    }


    /**
	 * 获取：体温
	 */

    public void setShentizhibiaoTiwen(String shentizhibiaoTiwen) {
        this.shentizhibiaoTiwen = shentizhibiaoTiwen;
    }
    /**
	 * 设置：血压
	 */
    public String getShentizhibiaoXieya() {
        return shentizhibiaoXieya;
    }


    /**
	 * 获取：血压
	 */

    public void setShentizhibiaoXieya(String shentizhibiaoXieya) {
        this.shentizhibiaoXieya = shentizhibiaoXieya;
    }
    /**
	 * 设置：血糖
	 */
    public String getShentizhibiaoXietang() {
        return shentizhibiaoXietang;
    }


    /**
	 * 获取：血糖
	 */

    public void setShentizhibiaoXietang(String shentizhibiaoXietang) {
        this.shentizhibiaoXietang = shentizhibiaoXietang;
    }
    /**
	 * 设置：心率
	 */
    public String getShentizhibiaoXinlu() {
        return shentizhibiaoXinlu;
    }


    /**
	 * 获取：心率
	 */

    public void setShentizhibiaoXinlu(String shentizhibiaoXinlu) {
        this.shentizhibiaoXinlu = shentizhibiaoXinlu;
    }
    /**
	 * 设置：测试时间
	 */
    public Date getShentizhibiaoTime() {
        return shentizhibiaoTime;
    }


    /**
	 * 获取：测试时间
	 */

    public void setShentizhibiaoTime(Date shentizhibiaoTime) {
        this.shentizhibiaoTime = shentizhibiaoTime;
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
    return "Shentizhibiao{" +
            "id=" + id +
            ", laorenTypes=" + laorenTypes +
            ", shentizhibiaoTiwen=" + shentizhibiaoTiwen +
            ", shentizhibiaoXieya=" + shentizhibiaoXieya +
            ", shentizhibiaoXietang=" + shentizhibiaoXietang +
            ", shentizhibiaoXinlu=" + shentizhibiaoXinlu +
            ", shentizhibiaoTime=" + shentizhibiaoTime +
            ", createTime=" + createTime +
    "}";
    }
    }
