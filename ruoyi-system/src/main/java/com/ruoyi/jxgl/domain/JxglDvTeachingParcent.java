package com.ruoyi.jxgl.domain;

import com.ruoyi.common.core.domain.BaseEntity;

public class JxglDvTeachingParcent extends BaseEntity {
    private int tno;
    private String tname;
    private int gzl;

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public int getGzl() {
        return gzl;
    }

    public void setGzl(int gzl) {
        this.gzl = gzl;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "JxglDvTeachingParcent{" +
                "tno=" + tno +
                ", tname='" + tname + '\'' +
                ", gzl=" + gzl +
                '}';
    }
}
