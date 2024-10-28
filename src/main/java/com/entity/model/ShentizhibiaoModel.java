package com.entity.model;

import com.entity.ShentizhibiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 身体指标
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-04-08
 */
public class ShentizhibiaoModel implements Serializable {
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
     * 体温
     */
    private String shentizhibiaoTiwen;


    /**
     * 血压
     */
    private String shentizhibiaoXieya;


    /**
     * 血糖
     */
    private String shentizhibiaoXietang;


    /**
     * 心率
     */
    private String shentizhibiaoXinlu;


    /**
     * 测试时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shentizhibiaoTime;


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
