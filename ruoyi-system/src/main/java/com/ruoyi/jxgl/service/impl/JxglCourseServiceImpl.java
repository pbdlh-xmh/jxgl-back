package com.ruoyi.jxgl.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.jxgl.mapper.JxglCourseMapper;
import com.ruoyi.jxgl.domain.JxglCourse;
import com.ruoyi.jxgl.service.IJxglCourseService;

/**
 * 课程管理Service业务层处理
 * 
 * @author zxx
 * @date 2024-09-26
 */
@Service
public class JxglCourseServiceImpl implements IJxglCourseService 
{
    @Autowired
    private JxglCourseMapper jxglCourseMapper;

    /**
     * 查询课程管理
     * 
     * @param cno 课程管理主键
     * @return 课程管理
     */
    @Override
    public JxglCourse selectJxglCourseByCno(String cno)
    {
        return jxglCourseMapper.selectJxglCourseByCno(cno);
    }

    /**
     * 查询课程管理列表
     * 
     * @param jxglCourse 课程管理
     * @return 课程管理
     */
    @Override
    public List<JxglCourse> selectJxglCourseList(JxglCourse jxglCourse)
    {
        return jxglCourseMapper.selectJxglCourseList(jxglCourse);
    }

    /**
     * 新增课程管理
     * 
     * @param jxglCourse 课程管理
     * @return 结果
     */
    @Override
    public int insertJxglCourse(JxglCourse jxglCourse)
    {
        return jxglCourseMapper.insertJxglCourse(jxglCourse);
    }

    /**
     * 修改课程管理
     * 
     * @param jxglCourse 课程管理
     * @return 结果
     */
    @Override
    public int updateJxglCourse(JxglCourse jxglCourse)
    {
        return jxglCourseMapper.updateJxglCourse(jxglCourse);
    }

    /**
     * 批量删除课程管理
     * 
     * @param cnos 需要删除的课程管理主键
     * @return 结果
     */
    @Override
    public int deleteJxglCourseByCnos(String[] cnos)
    {
        return jxglCourseMapper.deleteJxglCourseByCnos(cnos);
    }

    /**
     * 删除课程管理信息
     * 
     * @param cno 课程管理主键
     * @return 结果
     */
    @Override
    public int deleteJxglCourseByCno(String cno)
    {
        return jxglCourseMapper.deleteJxglCourseByCno(cno);
    }
}
