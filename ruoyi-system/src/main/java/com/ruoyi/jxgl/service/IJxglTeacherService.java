package com.ruoyi.jxgl.service;

import java.util.List;
import com.ruoyi.jxgl.domain.JxglTeacher;

/**
 * 教师管理Service接口
 * 
 * @author zxx
 * @date 2024-09-26
 */
public interface IJxglTeacherService 
{
    /**
     * 查询教师管理
     * 
     * @param tno 教师管理主键
     * @return 教师管理
     */
    public JxglTeacher selectJxglTeacherByTno(String tno);

    /**
     * 查询教师管理列表
     * 
     * @param jxglTeacher 教师管理
     * @return 教师管理集合
     */
    public List<JxglTeacher> selectJxglTeacherList(JxglTeacher jxglTeacher);

    /**
     * 新增教师管理
     * 
     * @param jxglTeacher 教师管理
     * @return 结果
     */
    public int insertJxglTeacher(JxglTeacher jxglTeacher);

    /**
     * 修改教师管理
     * 
     * @param jxglTeacher 教师管理
     * @return 结果
     */
    public int updateJxglTeacher(JxglTeacher jxglTeacher);

    /**
     * 批量删除教师管理
     * 
     * @param tnos 需要删除的教师管理主键集合
     * @return 结果
     */
    public int deleteJxglTeacherByTnos(String[] tnos);

    /**
     * 删除教师管理信息
     * 
     * @param tno 教师管理主键
     * @return 结果
     */
    public int deleteJxglTeacherByTno(String tno);
}
