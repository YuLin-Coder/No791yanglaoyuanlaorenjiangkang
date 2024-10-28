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
 * 老人
 *
 * @email
 * @date 2021-04-08
 */
@TableName("laoren")
public class LaorenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public LaorenEntity() {

    }

    public LaorenEntity(T t) {
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
     * 老人名称
     */
    @TableField(value = "laoren_name")

    private String laorenName;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 年龄
     */
    @TableField(value = "laoren_age")

    private Integer laorenAge;


    /**
     * 家属联系方式
     */
    @TableField(value = "laoren_phone")

    private String laorenPhone;


    /**
     * 老人照片
     */
    @TableField(value = "laoren_photo")

    private String laorenPhoto;


    /**
     * 身份证号
     */
    @TableField(value = "laoren_id_number")

    private String laorenIdNumber;


    /**
     * 身体情况
     */
    @TableField(value = "laoren_content")

    private String laorenContent;


    /**
     * 入住时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "laoren_time",fill = FieldFill.UPDATE)

    private Date laorenTime;


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
	 * 设置：老人名称
	 */
    public String getLaorenName() {
        return laorenName;
    }


    /**
	 * 获取：老人名称
	 */

    public void setLaorenName(String laorenName) {
        this.laorenName = laorenName;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：年龄
	 */
    public Integer getLaorenAge() {
        return laorenAge;
    }


    /**
	 * 获取：年龄
	 */

    public void setLaorenAge(Integer laorenAge) {
        this.laorenAge = laorenAge;
    }
    /**
	 * 设置：家属联系方式
	 */
    public String getLaorenPhone() {
        return laorenPhone;
    }


    /**
	 * 获取：家属联系方式
	 */

    public void setLaorenPhone(String laorenPhone) {
        this.laorenPhone = laorenPhone;
    }
    /**
	 * 设置：老人照片
	 */
    public String getLaorenPhoto() {
        return laorenPhoto;
    }


    /**
	 * 获取：老人照片
	 */

    public void setLaorenPhoto(String laorenPhoto) {
        this.laorenPhoto = laorenPhoto;
    }
    /**
	 * 设置：身份证号
	 */
    public String getLaorenIdNumber() {
        return laorenIdNumber;
    }


    /**
	 * 获取：身份证号
	 */

    public void setLaorenIdNumber(String laorenIdNumber) {
        this.laorenIdNumber = laorenIdNumber;
    }
    /**
	 * 设置：身体情况
	 */
    public String getLaorenContent() {
        return laorenContent;
    }


    /**
	 * 获取：身体情况
	 */

    public void setLaorenContent(String laorenContent) {
        this.laorenContent = laorenContent;
    }
    /**
	 * 设置：入住时间
	 */
    public Date getLaorenTime() {
        return laorenTime;
    }


    /**
	 * 获取：入住时间
	 */

    public void setLaorenTime(Date laorenTime) {
        this.laorenTime = laorenTime;
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
    return "Laoren{" +
            "id=" + id +
            ", laorenName=" + laorenName +
            ", sexTypes=" + sexTypes +
            ", laorenAge=" + laorenAge +
            ", laorenPhone=" + laorenPhone +
            ", laorenPhoto=" + laorenPhoto +
            ", laorenIdNumber=" + laorenIdNumber +
            ", laorenContent=" + laorenContent +
            ", laorenTime=" + laorenTime +
            ", createTime=" + createTime +
    "}";
    }
    }
