package com.ruoyi.jxgl.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.jxgl.domain.JxglScView;

/***
 * 班级成员管理Service接口
 * **@authorruoyi*@date2023-11-29*/
public interface JxglScMapper {
    /***查询班级成员管理列表**@parammap查询参数*@return班级成员管理集合*/
    public List<JxglScView> selectJxglScList(Map<String, String> map);

    public List<JxglScView> selectJxglScViewList(Map<String, String> map);

    public int updateJxglSc(Map<String, String> map);
    /***新增选课**
    @paramjxglSc选课*
    @return结果*/

    public int insertJxglSc(JxglScView jxglSc);

    /***删除选课**@parammap选课参数*@return结果*/
    public int deleteJxglSc(Map<String, String> map);
    /***查询我的课程成绩**@parammap学号*@return我的课程成绩集合*/
    public List<Map<String,String>>selectJxglMyScList(Map<String,String>map);
}
