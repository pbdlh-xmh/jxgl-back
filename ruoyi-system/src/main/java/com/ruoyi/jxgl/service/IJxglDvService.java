package com.ruoyi.jxgl.service;

import com.ruoyi.jxgl.domain.*;

import java.util.List;
import java.util.Map;

/**
 * 课程管理Service接口
 * 
 * @author zxx
 * @date 2024-09-26
 */
public interface IJxglDvService
{
    public List<JxglDvSummer> selectJxglDvSummerList();
    public List<JxglDvSdeptParcent> selectJxglDvSdeptParcentList();

    List<JxglDvCtermScNum> selectJxglDvCtermScNumList(Map<String, String> map);

    List<JxglDvCtermScNum> selectJxglDvAeParcentList(Map<String, String> map);
    List<JxglDvTeachingParcent> selectJxglDvTeachingParcentList();
    List<Map<String,String>> selectJxglDvTheTermInfoList(int theTerm);
    List<Map<String,String>>  selectJxglStudentPointList();
}
