package com.ruoyi.jxgl.service.impl;

import com.ruoyi.jxgl.domain.JxglScView;
import com.ruoyi.jxgl.mapper.JxglScMapper;
import com.ruoyi.jxgl.service.IJxglScService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 班级成员管理Service接口
 *
 * @author zxx
 * @date 2024-09-26
 */
@Service
public class JxglScServiceImpi implements IJxglScService {

    @Autowired
    private JxglScMapper jxglScMapper;

    public List<JxglScView> selectJxglScList(Map<String, String> map) {
        return jxglScMapper.selectJxglScViewList(map);
    }

    /***修改选课**@parammap选课*@return结果*/
    @Override
    public int updateJxglSc(Map<String, String> map) {
        return jxglScMapper.updateJxglSc(map);
    }

    /***新增选课**@paramjxglSc选课*@return结果*/

    @Override
    public int insertJxglSc(JxglScView jxglSc) {
        return jxglScMapper.insertJxglSc(jxglSc);
    }

    /***删除选课**@parammap选课参数*@return结果*/
    @Override
    public int deleteJxglSc(Map<String, String> map) {
        return jxglScMapper.deleteJxglSc(map);
    }

    /***查询我的课程成绩**@parammap学号*@return我的课程成绩集合*
     *
     */
    @Override
    public List<Map<String, String>> selectJxglMyScList(Map<String, String> map) {
        return jxglScMapper.selectJxglMyScList(map);
    }

}
