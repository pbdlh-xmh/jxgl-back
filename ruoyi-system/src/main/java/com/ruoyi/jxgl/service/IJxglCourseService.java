package com.ruoyi.jxgl.service;

import java.util.List;
import com.ruoyi.jxgl.domain.JxglCourse;

/**
 * 课程管理Service接口
 * 
 * @author zxx
 * @date 2024-09-26
 */
public interface IJxglCourseService 
{
    /**
     * 查询课程管理
     * 
     * @param cno 课程管理主键
     * @return 课程管理
     */
    public JxglCourse selectJxglCourseByCno(String cno);

    /**
     * 查询课程管理列表
     * 
     * @param jxglCourse 课程管理
     * @return 课程管理集合
     */
    public List<JxglCourse> selectJxglCourseList(JxglCourse jxglCourse);

    /**
     * 新增课程管理
     * 
     * @param jxglCourse 课程管理
     * @return 结果
     */
    public int insertJxglCourse(JxglCourse jxglCourse);

    /**
     * 修改课程管理
     * 
     * @param jxglCourse 课程管理
     * @return 结果
     */
    public int updateJxglCourse(JxglCourse jxglCourse);

    /**
     * 批量删除课程管理
     * 
     * @param cnos 需要删除的课程管理主键集合
     * @return 结果
     */
    public int deleteJxglCourseByCnos(String[] cnos);

    /**
     * 删除课程管理信息
     * 
     * @param cno 课程管理主键
     * @return 结果
     */
    public int deleteJxglCourseByCno(String cno);
}
