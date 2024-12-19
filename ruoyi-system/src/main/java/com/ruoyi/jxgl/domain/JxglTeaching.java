package com.ruoyi.jxgl.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教学任务对象 jxgl_teaching
 * 
 * @author ruoyi
 * @date 2024-11-14
 */
public class JxglTeaching extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务号 */
    private Long sid;

    /** 学期 */
    @Excel(name = "学期")
    private Integer cterm;

    /** 课号 */
    @Excel(name = "课号")
    private String cno;

    /** 教工号 */
    @Excel(name = "教工号")
    private String tno;

    /** 学时 */
    @Excel(name = "学时")
    private Integer period;

    /** 开放选课？ */
    @Excel(name = "开放选课？")
    private Integer isOpen;

    /** 开放录分 */
    @Excel(name = "开放录分")
    private Integer isOpenScore;

    public void setSid(Long sid) 
    {
        this.sid = sid;
    }

    public Long getSid() 
    {
        return sid;
    }
    public void setCterm(Integer cterm) 
    {
        this.cterm = cterm;
    }

    public Integer getCterm() 
    {
        return cterm;
    }
    public void setCno(String cno) 
    {
        this.cno = cno;
    }

    public String getCno() 
    {
        return cno;
    }
    public void setTno(String tno) 
    {
        this.tno = tno;
    }

    public String getTno() 
    {
        return tno;
    }
    public void setPeriod(Integer period) 
    {
        this.period = period;
    }

    public Integer getPeriod() 
    {
        return period;
    }
    public void setIsOpen(Integer isOpen) 
    {
        this.isOpen = isOpen;
    }

    public Integer getIsOpen() 
    {
        return isOpen;
    }
    public void setIsOpenScore(Integer isOpenScore) 
    {
        this.isOpenScore = isOpenScore;
    }

    public Integer getIsOpenScore() 
    {
        return isOpenScore;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sid", getSid())
            .append("cterm", getCterm())
            .append("cno", getCno())
            .append("tno", getTno())
            .append("period", getPeriod())
            .append("isOpen", getIsOpen())
            .append("isOpenScore", getIsOpenScore())
            .toString();
    }
}
