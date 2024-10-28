package com.entity.model;

import com.entity.TufaqingkuangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 突发情况
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-04-08
 */
public class TufaqingkuangModel implements Serializable {
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
     * 突发情况
     */
    private String tijianbingliName;


    /**
     * 详情信息
     */
    private String tijianbingliContent;


    /**
     * 发生时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date tijianbingliTime;


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

    }
