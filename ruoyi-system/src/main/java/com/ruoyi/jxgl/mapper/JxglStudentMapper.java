package com.ruoyi.jxgl.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.jxgl.domain.JxglStudent;

/**
 * 学生档案Mapper接口
 *
 * @author zxx
 * @date 2024-09-26
 */
public interface JxglStudentMapper {
    /**
     * 查询学生档案
     *
     * @param sno 学生档案主键
     * @return 学生档案
     */
    public JxglStudent selectJxglStudentBySno(String sno);

    /**
     * 查询学生档案列表
     *
     * @param jxglStudent 学生档案
     * @return 学生档案集合
     */
    public List<JxglStudent> selectJxglStudentList(JxglStudent jxglStudent);

    /**
     * 新增学生档案
     *
     * @param jxglStudent 学生档案
     * @return 结果
     */
    public int insertJxglStudent(JxglStudent jxglStudent);

    /**
     * 修改学生档案
     *
     * @param jxglStudent 学生档案
     * @return 结果
     */
    public int updateJxglStudent(JxglStudent jxglStudent);

    /**
     * 删除学生档案
     *
     * @param sno 学生档案主键
     * @return 结果
     */
    public int deleteJxglStudentBySno(String sno);

    /**
     * 批量删除学生档案
     *
     * @param snos 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJxglStudentBySnos(String[] snos);

    /***查询学生档案列表**@paramkey学号或姓名关键字*@return学生档案集合*/
    public List<Map<String, String>> selectJxglStudentLikeList(String key);
}
