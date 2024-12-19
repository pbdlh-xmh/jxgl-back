package com.ruoyi.jxgl.domain;

import com.ruoyi.common.core.domain.BaseEntity;

public class JxglDvSdeptParcent extends BaseEntity {
    private String sdept;
    private double percent;

    public String getSdept() {
        return sdept;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }

    @Override
    public String toString() {
        return "JxglDvSdeptParcent{" +
                "sdept='" + sdept + '\'' +
                ", percent=" + percent +
                '}';
    }
}
