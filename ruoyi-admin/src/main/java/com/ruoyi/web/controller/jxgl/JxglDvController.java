package com.ruoyi.web.controller.jxgl;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.jxgl.domain.JxglCourse;
import com.ruoyi.jxgl.domain.JxglDvCtermScNum;
import com.ruoyi.jxgl.domain.JxglDvTeachingParcent;
import com.ruoyi.jxgl.service.IJxglCourseService;
import com.ruoyi.jxgl.service.IJxglDvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 课程管理Controller
 * 
 * @author zxx
 * @date 2024-09-26
 */
@RestController
@RequestMapping("/jxgl/dv")
public class JxglDvController extends BaseController
{
    @Autowired
    private IJxglDvService jxglDvService;

    /**
     *
     * 数据总览
     * @return
     */
    @GetMapping("/summmary")
    public AjaxResult getSummary(){
        return AjaxResult.success(jxglDvService.selectJxglDvSummerList());
    }

    /**
     *
     * @return
     */
    @GetMapping("/sdept")
    public TableDataInfo getSdept(){
        return getDataTable(jxglDvService.selectJxglDvSdeptParcentList());
    }

    @GetMapping("/scNum")
    public TableDataInfo getScNum(@RequestParam Map<String,String> map){
        List<JxglDvCtermScNum> list = jxglDvService.selectJxglDvCtermScNumList(map);
        return getDataTable(list);
    }



    @GetMapping("/aeParcent")
    public TableDataInfo getAeParcent(){
        List<Map<String,String>> list = jxglDvService.selectJxglDvAeParcentList();
        return getDataTable(list);
    }

    @GetMapping("/teaching")
    public AjaxResult getTeaching(){
        List<JxglDvTeachingParcent> list = jxglDvService.selectJxglDvTeachingParcentList();
        return AjaxResult.success(list);
    }

    @GetMapping("/theTermInfo/{theTerm}")
    public TableDataInfo getTheTermIndoList(@PathVariable int theTerm){
        List<Map<String,String>> list = jxglDvService.selectJxglDvTheTermInfoList(theTerm);
        return getDataTable(list);
    }

    @GetMapping("/stuPoint")
    public TableDataInfo getStuPointList(){
        List<Map<String,String>> list = jxglDvService.selectJxglStudentPointList();
        return getDataTable(list);
    }

    /**
     *  ##教师职称比例（饼图）
     * @return
     */
    @GetMapping("/ps")
    public TableDataInfo getPsList(){
        List<Map<String,String>> list = jxglDvService.selectJxglPsList();
        return getDataTable(list);
    }

    /**
     *课程种类统计（饼图）-
     * @return
     */
    @GetMapping("/course")
    public TableDataInfo getCourseList(){
        List<Map<String,String>> list = jxglDvService.selectJxglCourseList();
        return getDataTable(list);
    }

    /**
     *#学生年级分布（柱状图）
     * @return
     */
    @GetMapping("/sruClass")
    public TableDataInfo getClassList(){
        List<Map<String,String>> list = jxglDvService.selectJxglClassList();
        return getDataTable(list);
    }
    /**
     *#课程开课频率排行（柱状图）
     * @return
     */
    @GetMapping("/pinlv")
    public TableDataInfo getpinlvList(){
        List<Map<String,String>> list = jxglDvService.selectJxglpinlvList();
        return getDataTable(list);
    }
    /**
     * #成绩分布图（折线图）
     * @return
     */
    @GetMapping("/score")
    public TableDataInfo getScoreList(){
        List<Map<String,String>> list = jxglDvService.selectJxglScoreList();
        return getDataTable(list);
    }
    /**
     * #挂科率统计（折线图）
     * @return
     */
    @GetMapping("/guake")
    public TableDataInfo getGuaKeList(){
        List<Map<String,String>> list = jxglDvService.selectJxglGuaKeList();
        return getDataTable(list);
    }
    /**
     *教学任务完成率分析 横向
     * @return
     */
    @GetMapping("/work")
    public TableDataInfo getWorkList(){
        List<Map<String,String>> list = jxglDvService.selectJxglWorkList();
        return getDataTable(list);
    }
    /**
     *#成绩排名前50 表格
     * @return
     */
    @GetMapping("/score50")
    public TableDataInfo getScoreTop50List(){
        List<Map<String,String>> list = jxglDvService.selectJxglScoreTop50List();
        return getDataTable(list);
    }
    /**
     *异常课程统计 横向
     * @return
     */
    @GetMapping("/errorWork")
    public TableDataInfo getYiChangList(){
        List<Map<String,String>> list = jxglDvService.selectJxglYiChangList();
        return getDataTable(list);
    }
    /**
     * #教学任务量排名前20  表格
     * @return
     */
    @GetMapping("/work20")
    public TableDataInfo getWorkTop20List(){
        List<Map<String,String>> list = jxglDvService.selectJxglWorkTop20List();
        return getDataTable(list);
    }






}
