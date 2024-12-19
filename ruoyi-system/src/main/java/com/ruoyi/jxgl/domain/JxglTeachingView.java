package com.ruoyi.jxgl.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教学任务对象 jxgl_teaching_view
 *
 * @author ruoyi
 * @date 2024-11-14
 */
public class JxglTeachingView extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 任务号
     */
    private Long sid;

    /**
     * 学期
     */
    @Excel(name = "学期")
    private Integer cterm;

    /**
     * 课程编号
     */
    @Excel(name = "课程编号")
    private String cno;

    /**
     * 课程名称
     */
    @Excel(name = "课程名称")
    private String cname;

    /**
     * 学时
     */
    @Excel(name = "学时")
    private Integer period;

    /**
     * 教工号
     */
    @Excel(name = "教工号")
    private String tno;

    /**
     * 教师姓名
     */
    @Excel(name = "教师姓名")
    private String tname;

    /**
     * 职称
     */
    @Excel(name = "职称")
    private String ps;

    /**
     * 开放选课？
     */
    @Excel(name = "开放选课？")
    private Integer isOpen;
    /**
     * 选课状态
     */
    @Excel(name = "选课状态")
    private Integer scStatus;

    public Integer getScStatus() {
        return scStatus;
    }

    public void setScStatus(Integer scStatus) {
        this.scStatus = scStatus;
    }

    /**
     * 开放录分
     */
    @Excel(name = "开放录分")
    private Integer isOpenScore;

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getSid() {
        return sid;
    }

    public void setCterm(Integer cterm) {
        this.cterm = cterm;
    }

    public Integer getCterm() {
        return cterm;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCno() {
        return cno;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCname() {
        return cname;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTno() {
        return tno;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTname() {
        return tname;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getPs() {
        return ps;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpenScore(Integer isOpenScore) {
        this.isOpenScore = isOpenScore;
    }

    public Integer getIsOpenScore() {
        return isOpenScore;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("sid", getSid())
                .append("cterm", getCterm())
                .append("cno", getCno())
                .append("cname", getCname())
                .append("period", getPeriod())
                .append("tno", getTno())
                .append("tname", getTname())
                .append("ps", getPs())
                .append("isOpen", getIsOpen())
                .append("isOpenScore", getIsOpenScore())
                .toString();
    }
}
