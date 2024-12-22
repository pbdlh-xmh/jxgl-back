package com.ruoyi.jxgl.mapper;

import com.ruoyi.jxgl.domain.*;

import java.util.List;
import java.util.Map;

/**
 * 课程管理Mapper接口
 * 
 * @author zxx
 * @date 2024-09-26
 */
public interface JxglDvMapper
{
    public List<JxglDvSummer> selectJxglDvSummerList();

    public List<JxglDvSdeptParcent> selectJxglDvSdeptParcentList();

    List<JxglDvCtermScNum> selectJxglDvCtermScNumList(Map<String, String> map);

    List<Map<String, String> > selectJxglDvAeParcentList();
    List<JxglDvTeachingParcent> selectJxglDvTeachingParcentList();
    List<Map<String,String>> selectJxglDvTheTermInfoList(int theTerm);
    List<Map<String,String>>  selectJxglStudentPointList();

    List<Map<String,String>> selectJxglPsList();
    List<Map<String,String>> selectJxglCourseList();
    List<Map<String,String>> selectJxglClassList();
    List<Map<String,String>> selectJxglpinlvList();
    List<Map<String,String>> selectJxglScoreList();
    List<Map<String,String>> selectJxglGuaKeList();
    List<Map<String,String>> selectJxglWorkList();
    List<Map<String,String>> selectJxglScoreTop50List();
    List<Map<String,String>> selectJxglYiChangList();
    List<Map<String,String>> selectJxglWorkTop20List();




}
