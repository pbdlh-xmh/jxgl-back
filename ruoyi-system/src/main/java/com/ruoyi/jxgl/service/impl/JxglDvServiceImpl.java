package com.ruoyi.jxgl.service.impl;

import com.ruoyi.jxgl.domain.*;
import com.ruoyi.jxgl.mapper.JxglCourseMapper;
import com.ruoyi.jxgl.mapper.JxglDvMapper;
import com.ruoyi.jxgl.service.IJxglCourseService;
import com.ruoyi.jxgl.service.IJxglDvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 课程管理Service业务层处理
 * 
 * @author zxx
 * @date 2024-09-26
 */
@Service
public class JxglDvServiceImpl implements IJxglDvService{
    @Autowired
    private JxglDvMapper jxglDvMapper;

    @Override
    public List<JxglDvSummer> selectJxglDvSummerList() {
        return jxglDvMapper.selectJxglDvSummerList();
    }

    @Override
    public List<JxglDvSdeptParcent> selectJxglDvSdeptParcentList() {
        return jxglDvMapper.selectJxglDvSdeptParcentList();
    }

    @Override
    public List<JxglDvCtermScNum> selectJxglDvCtermScNumList(Map<String, String> map) {
        return jxglDvMapper.selectJxglDvCtermScNumList(map);
    }

    @Override
    public List<Map<String,String>> selectJxglDvAeParcentList() {
        return jxglDvMapper.selectJxglDvAeParcentList();
    }

    @Override
    public List<JxglDvTeachingParcent> selectJxglDvTeachingParcentList() {
        return jxglDvMapper.selectJxglDvTeachingParcentList();
    }

    @Override
    public List<Map<String, String>> selectJxglDvTheTermInfoList(int theTerm) {
        return jxglDvMapper.selectJxglDvTheTermInfoList(theTerm);
    }

    @Override
    public List<Map<String, String>> selectJxglStudentPointList() {
        return jxglDvMapper.selectJxglStudentPointList();
    }

    @Override
    public List<Map<String, String>> selectJxglPsList() {
        return jxglDvMapper.selectJxglPsList();
    }

    @Override
    public List<Map<String, String>> selectJxglCourseList() {
        return jxglDvMapper.selectJxglCourseList();
    }

    @Override
    public List<Map<String, String>> selectJxglClassList() {
        return jxglDvMapper.selectJxglClassList();
    }

    @Override
    public List<Map<String, String>> selectJxglpinlvList() {
        return jxglDvMapper.selectJxglpinlvList();
    }

    @Override
    public List<Map<String, String>> selectJxglScoreList() {
        return jxglDvMapper.selectJxglScoreList();
    }

    @Override
    public List<Map<String, String>> selectJxglGuaKeList() {
        return jxglDvMapper.selectJxglGuaKeList();
    }

    @Override
    public List<Map<String, String>> selectJxglWorkList() {
        return jxglDvMapper.selectJxglWorkList();
    }

    @Override
    public List<Map<String, String>> selectJxglScoreTop50List() {
        return jxglDvMapper.selectJxglScoreTop50List();
    }

    @Override
    public List<Map<String, String>> selectJxglYiChangList() {
        return jxglDvMapper.selectJxglYiChangList();
    }

    @Override
    public List<Map<String, String>> selectJxglWorkTop20List() {
        return jxglDvMapper.selectJxglWorkTop20List();
    }
}
