package com.ruoyi.jxgl.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.jxgl.domain.JxglTeachingView;

/**
 * 教学任务Service接口
 *
 * @author ruoyi
 * @date 2024-11-14
 */
public interface IJxglTeachingViewService {
    /**
     * 查询教学任务
     *
     * @param sid 教学任务主键
     * @return 教学任务
     */
    public JxglTeachingView selectJxglTeachingViewBySid(Long sid);

    /**
     * 查询教学任务列表
     *
     * @param jxglTeachingView 教学任务
     * @return 教学任务集合
     */
    public List<JxglTeachingView> selectJxglTeachingViewList(JxglTeachingView jxglTeachingView);

    /**
     * 新增教学任务
     *
     * @param jxglTeachingView 教学任务
     * @return 结果
     */
    public int insertJxglTeachingView(JxglTeachingView jxglTeachingView);

    /**
     * 修改教学任务
     *
     * @param jxglTeachingView 教学任务
     * @return 结果
     */
    public int updateJxglTeachingView(JxglTeachingView jxglTeachingView);

    /**
     * 批量删除教学任务
     *
     * @param sids 需要删除的教学任务主键集合
     * @return 结果
     */
    public int deleteJxglTeachingViewBySids(Long[] sids);

    /**
     * 删除教学任务信息
     *
     * @param sid 教学任务主键
     * @return 结果
     */
    public int deleteJxglTeachingViewBySid(Long sid);

    /***查询教学任务**@paramid教学任务主键*@return教学任务*/
    public JxglTeachingView selectJxglTeachingViewById(Long id);


    /***查询我的选课任务列表**@paramjxglTeachingView教学任务*@return教学任务集合*/
    public List<JxglTeachingView> selectJxglMyScTeachingList(Map<String, String> map);

    public List<Map<String, String>> selectJxglScTeachingList(Map<String, String> map);
    /***根据课号查开课学期**@paramcno教学任务*@return开课学期集合*/
    public List<Map<String,String>>selectJxglScTermByCno(String cno);
}
