package com.ruoyi.jxgl.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生档案对象 jxgl_student
 * 
 * @author zxx
 * @date 2024-09-26
 */
public class JxglStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学号 */
    private String sno;

    /** 姓名 */
    @Excel(name = "姓名")
    private String sname;

    /** 班级 */
    @Excel(name = "班级")
    private String sclass;

    /** 性别 */
    @Excel(name = "性别")
    private String ssex;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bday;

    /** 生源地 */
    @Excel(name = "生源地")
    private String bplace;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String IDNum;

    /** 学院 */
    @Excel(name = "学院")
    private String sdept;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phone;

    public void setSno(String sno) 
    {
        this.sno = sno;
    }

    public String getSno() 
    {
        return sno;
    }
    public void setSname(String sname) 
    {
        this.sname = sname;
    }

    public String getSname() 
    {
        return sname;
    }
    public void setSclass(String sclass) 
    {
        this.sclass = sclass;
    }

    public String getSclass() 
    {
        return sclass;
    }
    public void setSsex(String ssex) 
    {
        this.ssex = ssex;
    }

    public String getSsex() 
    {
        return ssex;
    }
    public void setBday(Date bday) 
    {
        this.bday = bday;
    }

    public Date getBday() 
    {
        return bday;
    }
    public void setBplace(String bplace) 
    {
        this.bplace = bplace;
    }

    public String getBplace() 
    {
        return bplace;
    }
    public void setIDNum(String IDNum) 
    {
        this.IDNum = IDNum;
    }

    public String getIDNum() 
    {
        return IDNum;
    }
    public void setSdept(String sdept) 
    {
        this.sdept = sdept;
    }

    public String getSdept() 
    {
        return sdept;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sno", getSno())
            .append("sname", getSname())
            .append("sclass", getSclass())
            .append("ssex", getSsex())
            .append("bday", getBday())
            .append("bplace", getBplace())
            .append("IDNum", getIDNum())
            .append("sdept", getSdept())
            .append("phone", getPhone())
            .toString();
    }
}
