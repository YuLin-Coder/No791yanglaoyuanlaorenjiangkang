package com.entity.model;

import com.entity.ShiyaojiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 食药记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-04-08
 */
public class ShiyaojiluModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 老人
     */
    private Integer laorenTypes;


    /**
     * 名称 Search
     */
    private String shiyaojiluName;


    /**
     * 类型
     */
    private Integer shiyaojiluTypes;


    /**
     * 详情
     */
    private String shiyaojiluContent;


    /**
     * 食用时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shiyaojiluTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 设置：名称 Search
	 */
    public String getShiyaojiluName() {
        return shiyaojiluName;
    }


    /**
	 * 获取：名称 Search
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

    }
