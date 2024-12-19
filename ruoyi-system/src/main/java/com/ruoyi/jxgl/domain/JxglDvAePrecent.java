package com.ruoyi.jxgl.domain;

import com.ruoyi.common.core.domain.BaseEntity;

public class JxglDvAePrecent extends BaseEntity {
    private int snum;
    private int tnum;
    private int cnum;
    private double tcr;
    private double scr;

    public int getSnum() {
        return snum;
    }

    public void setSnum(int snum) {
        this.snum = snum;
    }

    public double getScr() {
        return scr;
    }

    public void setScr(double scr) {
        this.scr = scr;
    }

    public double getTcr() {
        return tcr;
    }

    public void setTcr(double tcr) {
        this.tcr = tcr;
    }

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    public int getTnum() {
        return tnum;
    }

    public void setTnum(int tnum) {
        this.tnum = tnum;
    }

    @Override
    public String toString() {
        return "JxglDvAePrecent{" +
                "snum=" + snum +
                ", tnum=" + tnum +
                ", cnum=" + cnum +
                ", tcr=" + tcr +
                ", scr=" + scr +
                '}';
    }
}
