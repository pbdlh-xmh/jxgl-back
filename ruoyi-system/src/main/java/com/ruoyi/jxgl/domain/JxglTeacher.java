package com.ruoyi.jxgl.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教师管理对象 jxgl_teacher
 * 
 * @author zxx
 * @date 2024-09-26
 */
public class JxglTeacher extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 教工号 */
    private String tno;

    /** 教师姓名 */
    @Excel(name = "教师姓名")
    private String tname;

    /** 职称 */
    @Excel(name = "职称")
    private String ps;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tbirthday;

    /** 部门 */
    @Excel(name = "部门")
    private String tdept;

    /** 性别 */
    @Excel(name = "性别")
    private String tsex;

    public void setTno(String tno) 
    {
        this.tno = tno;
    }

    public String getTno() 
    {
        return tno;
    }
    public void setTname(String tname) 
    {
        this.tname = tname;
    }

    public String getTname() 
    {
        return tname;
    }
    public void setPs(String ps) 
    {
        this.ps = ps;
    }

    public String getPs() 
    {
        return ps;
    }
    public void setTbirthday(Date tbirthday) 
    {
        this.tbirthday = tbirthday;
    }

    public Date getTbirthday() 
    {
        return tbirthday;
    }
    public void setTdept(String tdept) 
    {
        this.tdept = tdept;
    }

    public String getTdept() 
    {
        return tdept;
    }
    public void setTsex(String tsex) 
    {
        this.tsex = tsex;
    }

    public String getTsex() 
    {
        return tsex;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tno", getTno())
            .append("tname", getTname())
            .append("ps", getPs())
            .append("tbirthday", getTbirthday())
            .append("tdept", getTdept())
            .append("tsex", getTsex())
            .toString();
    }
}
