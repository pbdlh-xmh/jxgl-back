package com.ruoyi.jxgl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.jxgl.mapper.JxglStudentMapper;
import com.ruoyi.jxgl.domain.JxglStudent;
import com.ruoyi.jxgl.service.IJxglStudentService;

/**
 * 学生档案Service业务层处理
 *
 * @author zxx
 * @date 2024-09-26
 */
@Service
public class JxglStudentServiceImpl implements IJxglStudentService {
    @Autowired
    private JxglStudentMapper jxglStudentMapper;

    /**
     * 查询学生档案
     *
     * @param sno 学生档案主键
     * @return 学生档案
     */
    @Override
    public JxglStudent selectJxglStudentBySno(String sno) {
        return jxglStudentMapper.selectJxglStudentBySno(sno);
    }

    /**
     * 查询学生档案列表
     *
     * @param jxglStudent 学生档案
     * @return 学生档案
     */
    @Override
    public List<JxglStudent> selectJxglStudentList(JxglStudent jxglStudent) {
        return jxglStudentMapper.selectJxglStudentList(jxglStudent);
    }

    /**
     * 新增学生档案
     *
     * @param jxglStudent 学生档案
     * @return 结果
     */
    @Override
    public int insertJxglStudent(JxglStudent jxglStudent) {
        return jxglStudentMapper.insertJxglStudent(jxglStudent);
    }

    /**
     * 修改学生档案
     *
     * @param jxglStudent 学生档案
     * @return 结果
     */
    @Override
    public int updateJxglStudent(JxglStudent jxglStudent) {
        return jxglStudentMapper.updateJxglStudent(jxglStudent);
    }

    /**
     * 批量删除学生档案
     *
     * @param snos 需要删除的学生档案主键
     * @return 结果
     */
    @Override
    public int deleteJxglStudentBySnos(String[] snos) {
        return jxglStudentMapper.deleteJxglStudentBySnos(snos);
    }

    /**
     * 删除学生档案信息
     *
     * @param sno 学生档案主键
     * @return 结果
     */
    @Override
    public int deleteJxglStudentBySno(String sno) {
        return jxglStudentMapper.deleteJxglStudentBySno(sno);
    }

    /***查询学生档案列表**@paramkey学号或姓名关键字*@return学生档案集合*/
    @Override
    public List<Map<String, String>> selectJxglStudentLikeList(String key) {
        return jxglStudentMapper.selectJxglStudentLikeList(key);
    }
}
