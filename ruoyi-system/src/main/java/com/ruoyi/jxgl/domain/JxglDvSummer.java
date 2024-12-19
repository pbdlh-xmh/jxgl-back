package com.ruoyi.jxgl.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class JxglDvSummer extends BaseEntity {
    private int stu_num;
    private int teachter_num;
    private int coure_num;
    private int teaching_num;

    public int getStu_num() {
        return stu_num;
    }

    public void setStu_num(int stu_num) {
        this.stu_num = stu_num;
    }

    public int getTeaching_num() {
        return teaching_num;
    }

    public void setTeaching_num(int teaching_num) {
        this.teaching_num = teaching_num;
    }

    public int getCoure_num() {
        return coure_num;
    }

    public void setCoure_num(int coure_num) {
        this.coure_num = coure_num;
    }

    public int getTeachter_num() {
        return teachter_num;
    }

    public void setTeachter_num(int teachter_num) {
        this.teachter_num = teachter_num;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("stu_num", getStu_num())
                .append("teachter_num", getTeachter_num())
                .append("coure_num", getCoure_num())
                .append("teaching_num", getTeaching_num())
                .toString();
    }
}
