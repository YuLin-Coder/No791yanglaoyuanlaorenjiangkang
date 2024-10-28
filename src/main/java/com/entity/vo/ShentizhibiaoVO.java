package com.entity.vo;

import com.entity.ShentizhibiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 身体指标
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-04-08
 */
@TableName("shentizhibiao")
public class ShentizhibiaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "shentizhibiao_time")
    private Date shentizhibiaoTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
