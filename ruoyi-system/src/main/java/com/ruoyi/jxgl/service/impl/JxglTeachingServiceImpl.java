package com.ruoyi.jxgl.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.jxgl.mapper.JxglTeachingMapper;
import com.ruoyi.jxgl.domain.JxglTeaching;
import com.ruoyi.jxgl.service.IJxglTeachingService;

/**
 * 教学任务Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-14
 */
@Service
public class JxglTeachingServiceImpl implements IJxglTeachingService 
{
    @Autowired
    private JxglTeachingMapper jxglTeachingMapper;

    /**
     * 查询教学任务
     * 
     * @param sid 教学任务主键
     * @return 教学任务
     */
    @Override
    public JxglTeaching selectJxglTeachingBySid(Long sid)
    {
        return jxglTeachingMapper.selectJxglTeachingBySid(sid);
    }

    /**
     * 查询教学任务列表
     * 
     * @param jxglTeaching 教学任务
     * @return 教学任务
     */
    @Override
    public List<JxglTeaching> selectJxglTeachingList(JxglTeaching jxglTeaching)
    {
        return jxglTeachingMapper.selectJxglTeachingList(jxglTeaching);
    }

    /**
     * 新增教学任务
     * 
     * @param jxglTeaching 教学任务
     * @return 结果
     */
    @Override
    public int insertJxglTeaching(JxglTeaching jxglTeaching)
    {
        return jxglTeachingMapper.insertJxglTeaching(jxglTeaching);
    }

    /**
     * 修改教学任务
     * 
     * @param jxglTeaching 教学任务
     * @return 结果
     */
    @Override
    public int updateJxglTeaching(JxglTeaching jxglTeaching)
    {
        return jxglTeachingMapper.updateJxglTeaching(jxglTeaching);
    }

    /**
     * 批量删除教学任务
     * 
     * @param sids 需要删除的教学任务主键
     * @return 结果
     */
    @Override
    public int deleteJxglTeachingBySids(Long[] sids)
    {
        return jxglTeachingMapper.deleteJxglTeachingBySids(sids);
    }

    /**
     * 删除教学任务信息
     * 
     * @param sid 教学任务主键
     * @return 结果
     */
    @Override
    public int deleteJxglTeachingBySid(Long sid)
    {
        return jxglTeachingMapper.deleteJxglTeachingBySid(sid);
    }
}
