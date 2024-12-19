package com.ruoyi.jxgl.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.jxgl.mapper.JxglTeacherMapper;
import com.ruoyi.jxgl.domain.JxglTeacher;
import com.ruoyi.jxgl.service.IJxglTeacherService;

/**
 * 教师管理Service业务层处理
 * 
 * @author zxx
 * @date 2024-09-26
 */
@Service
public class JxglTeacherServiceImpl implements IJxglTeacherService 
{
    @Autowired
    private JxglTeacherMapper jxglTeacherMapper;

    /**
     * 查询教师管理
     * 
     * @param tno 教师管理主键
     * @return 教师管理
     */
    @Override
    public JxglTeacher selectJxglTeacherByTno(String tno)
    {
        return jxglTeacherMapper.selectJxglTeacherByTno(tno);
    }

    /**
     * 查询教师管理列表
     * 
     * @param jxglTeacher 教师管理
     * @return 教师管理
     */
    @Override
    public List<JxglTeacher> selectJxglTeacherList(JxglTeacher jxglTeacher)
    {
        return jxglTeacherMapper.selectJxglTeacherList(jxglTeacher);
    }

    /**
     * 新增教师管理
     * 
     * @param jxglTeacher 教师管理
     * @return 结果
     */
    @Override
    public int insertJxglTeacher(JxglTeacher jxglTeacher)
    {
        return jxglTeacherMapper.insertJxglTeacher(jxglTeacher);
    }

    /**
     * 修改教师管理
     * 
     * @param jxglTeacher 教师管理
     * @return 结果
     */
    @Override
    public int updateJxglTeacher(JxglTeacher jxglTeacher)
    {
        return jxglTeacherMapper.updateJxglTeacher(jxglTeacher);
    }

    /**
     * 批量删除教师管理
     * 
     * @param tnos 需要删除的教师管理主键
     * @return 结果
     */
    @Override
    public int deleteJxglTeacherByTnos(String[] tnos)
    {
        return jxglTeacherMapper.deleteJxglTeacherByTnos(tnos);
    }

    /**
     * 删除教师管理信息
     * 
     * @param tno 教师管理主键
     * @return 结果
     */
    @Override
    public int deleteJxglTeacherByTno(String tno)
    {
        return jxglTeacherMapper.deleteJxglTeacherByTno(tno);
    }
}
