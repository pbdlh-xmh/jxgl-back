package com.ruoyi.jxgl.mapper;

import java.util.List;
import com.ruoyi.jxgl.domain.JxglTeaching;

/**
 * 教学任务Mapper接口
 * 
 * @author ruoyi
 * @date 2024-11-14
 */
public interface JxglTeachingMapper 
{
    /**
     * 查询教学任务
     * 
     * @param sid 教学任务主键
     * @return 教学任务
     */
    public JxglTeaching selectJxglTeachingBySid(Long sid);

    /**
     * 查询教学任务列表
     * 
     * @param jxglTeaching 教学任务
     * @return 教学任务集合
     */
    public List<JxglTeaching> selectJxglTeachingList(JxglTeaching jxglTeaching);

    /**
     * 新增教学任务
     * 
     * @param jxglTeaching 教学任务
     * @return 结果
     */
    public int insertJxglTeaching(JxglTeaching jxglTeaching);

    /**
     * 修改教学任务
     * 
     * @param jxglTeaching 教学任务
     * @return 结果
     */
    public int updateJxglTeaching(JxglTeaching jxglTeaching);

    /**
     * 删除教学任务
     * 
     * @param sid 教学任务主键
     * @return 结果
     */
    public int deleteJxglTeachingBySid(Long sid);

    /**
     * 批量删除教学任务
     * 
     * @param sids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJxglTeachingBySids(Long[] sids);
}
