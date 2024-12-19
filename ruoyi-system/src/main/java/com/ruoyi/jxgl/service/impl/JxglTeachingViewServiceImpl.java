package com.ruoyi.jxgl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.jxgl.mapper.JxglTeachingViewMapper;
import com.ruoyi.jxgl.domain.JxglTeachingView;
import com.ruoyi.jxgl.service.IJxglTeachingViewService;

/**
 * 教学任务Service业务层处理
 *
 * @author ruoyi
 * @date 2024-11-14
 */
@Service
public class JxglTeachingViewServiceImpl implements IJxglTeachingViewService {
    @Autowired
    private JxglTeachingViewMapper jxglTeachingViewMapper;

    /**
     * 查询教学任务
     *
     * @param sid 教学任务主键
     * @return 教学任务
     */
    @Override
    public JxglTeachingView selectJxglTeachingViewBySid(Long sid) {
        return jxglTeachingViewMapper.selectJxglTeachingViewBySid(sid);
    }

    /**
     * 查询教学任务列表
     *
     * @param jxglTeachingView 教学任务
     * @return 教学任务
     */
    @Override
    public List<JxglTeachingView> selectJxglTeachingViewList(JxglTeachingView jxglTeachingView) {
        return jxglTeachingViewMapper.selectJxglTeachingViewList(jxglTeachingView);
    }

    /***查询教学任务**@paramid教学任务主键*@return教学任务*/
    @Override
    public JxglTeachingView selectJxglTeachingViewById(Long id) {
        return jxglTeachingViewMapper.selectJxglTeachingViewById(id);
    }

    /***查询我的选课任务列表**@parammap教学任务*@return教学任务集合*/
    @Override
    public List<JxglTeachingView> selectJxglMyScTeachingList(Map<String, String> map) {
        return jxglTeachingViewMapper.selectJxglMyScTeachingList(map);
    }

    /**
     * 新增教学任务
     *
     * @param jxglTeachingView 教学任务
     * @return 结果
     */
    @Override
    public int insertJxglTeachingView(JxglTeachingView jxglTeachingView) {
        return jxglTeachingViewMapper.insertJxglTeachingView(jxglTeachingView);
    }

    /**
     * 修改教学任务
     *
     * @param jxglTeachingView 教学任务
     * @return 结果
     */
    @Override
    public int updateJxglTeachingView(JxglTeachingView jxglTeachingView) {
        return jxglTeachingViewMapper.updateJxglTeachingView(jxglTeachingView);
    }

    /**
     * 批量删除教学任务
     *
     * @param sids 需要删除的教学任务主键
     * @return 结果
     */
    @Override
    public int deleteJxglTeachingViewBySids(Long[] sids) {
        return jxglTeachingViewMapper.deleteJxglTeachingViewBySids(sids);
    }

    /**
     * 删除教学任务信息
     *
     * @param sid 教学任务主键
     * @return 结果
     */
    @Override
    public int deleteJxglTeachingViewBySid(Long sid) {
        return jxglTeachingViewMapper.deleteJxglTeachingViewBySid(sid);
    }

    /***选课管理*@parammap查询参数*@return*/
    @Override
    public List<Map<String, String>> selectJxglScTeachingList(Map<String, String> map) {
        return jxglTeachingViewMapper.selectJxglScTeachingList(map);
    }

    /***根据课程号查开课学期**@paramcno学号*@return*/
    @Override
    public List<Map<String, String>> selectJxglScTermByCno(String cno) {
        return jxglTeachingViewMapper.selectJxglScTermByCno(cno);
    }
}
