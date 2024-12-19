package com.ruoyi.jxgl.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class JxglDvCtermScNum extends BaseEntity {
    private int cterm ;
    private int num ;

    public int getCterm() {
        return cterm;
    }

    public void setCterm(int cterm) {
        this.cterm = cterm;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "JxglDvCtermScNum{" +
                "cterm=" + cterm +
                ", num=" + num +
                '}';
    }
}
