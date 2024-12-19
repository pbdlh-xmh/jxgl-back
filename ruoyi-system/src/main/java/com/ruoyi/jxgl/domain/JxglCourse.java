package com.ruoyi.jxgl.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程管理对象 jxgl_course
 * 
 * @author zxx
 * @date 2024-09-26
 */
public class JxglCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程编号 */
    private String cno;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String cname;

    /** 先修课号 */
    @Excel(name = "先修课号")
    private String cpno;

    /** 学分 */
    @Excel(name = "学分")
    private Integer ccredit;

    public void setCno(String cno) 
    {
        this.cno = cno;
    }

    public String getCno() 
    {
        return cno;
    }
    public void setCname(String cname) 
    {
        this.cname = cname;
    }

    public String getCname() 
    {
        return cname;
    }
    public void setCpno(String cpno) 
    {
        this.cpno = cpno;
    }

    public String getCpno() 
    {
        return cpno;
    }
    public void setCcredit(Integer ccredit) 
    {
        this.ccredit = ccredit;
    }

    public Integer getCcredit() 
    {
        return ccredit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cno", getCno())
            .append("cname", getCname())
            .append("cpno", getCpno())
            .append("ccredit", getCcredit())
            .toString();
    }
}
