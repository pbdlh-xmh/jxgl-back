package com.ruoyi.jxgl.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 课程管理对象 jxgl_course
 * 
 * @author zxx
 * @date 2024-09-26
 */
public class JxglScView extends BaseEntity
{
    private static final long serialVersionUID = 1L;



    /**任务号*/ @Excel(name="任务号")
    private Long tid;

    /** 学号 */
    @Excel(name = "学号")
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

    /** 课程编号 */
    @Excel(name = "课程编号")
    private String cno;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String cname;

    /** 分数 */
    @Excel(name = "分数")
    private BigDecimal score;

    /** 绩点 */
    @Excel(name = "绩点")
    private BigDecimal point;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }
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
    public void setScore(BigDecimal score)
    {
        this.score = score;
    }

    public BigDecimal getScore()
    {
        return score;
    }
    public void setPoint(BigDecimal point)
    {
        this.point = point;
    }

    public BigDecimal getPoint()
    {
        return point;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("tid",getTid())
                .append("sno", getSno())
                .append("sname", getSname())
                .append("sclass", getSclass())
                .append("ssex", getSsex())
                .append("cno", getCno())
                .append("cname", getCname())
                .append("score", getScore())
                .append("point", getPoint())
                .toString();
    }
}
