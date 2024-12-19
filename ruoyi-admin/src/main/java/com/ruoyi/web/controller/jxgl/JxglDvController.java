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
    public AjaxResult getSdept(){
        return AjaxResult.success(jxglDvService.selectJxglDvSdeptParcentList());
    }

    @GetMapping("/scNum")
    public TableDataInfo getScNum(@RequestParam Map<String,String> map){
        List<JxglDvCtermScNum> list = jxglDvService.selectJxglDvCtermScNumList(map);
        return getDataTable(list);
    }



    @GetMapping("/aeParcent")
    public TableDataInfo getAeParcent(@RequestParam Map<String,String> map){
        List<JxglDvCtermScNum> list = jxglDvService.selectJxglDvAeParcentList(map);
        return getDataTable(list);
    }

    @GetMapping("/teaching")
    public TableDataInfo getTeaching(){
        List<JxglDvTeachingParcent> list = jxglDvService.selectJxglDvTeachingParcentList();
        return getDataTable(list);
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



}
