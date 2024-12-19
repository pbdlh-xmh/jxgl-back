package com.ruoyi.web.controller.jxgl;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.jxgl.domain.JxglCourse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.jxgl.domain.JxglTeachingView;
import com.ruoyi.jxgl.service.IJxglTeachingViewService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教学任务Controller
 *
 * @author ruoyi
 * @date 2024-11-14
 */
@RestController
@RequestMapping("/jxgl/teaching")
public class JxglTeachingViewController extends BaseController {
    @Autowired
    private IJxglTeachingViewService jxglTeachingViewService;

    /**
     * 查询教学任务列表
     */
    @PreAuthorize("@ss.hasPermi('jxgl:teaching:list')")
    @GetMapping("/list")
    public TableDataInfo list(JxglTeachingView jxglTeachingView) {
        startPage();
        List<JxglTeachingView> list = jxglTeachingViewService.selectJxglTeachingViewList(jxglTeachingView);
        return getDataTable(list);
    }


    /**
     * 导出教学任务列表
     */
    @PreAuthorize("@ss.hasPermi('jxgl:teaching:export')")
    @Log(title = "教学任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JxglTeachingView jxglTeachingView) {
        List<JxglTeachingView> list = jxglTeachingViewService.selectJxglTeachingViewList(jxglTeachingView);
        ExcelUtil<JxglTeachingView> util = new ExcelUtil<JxglTeachingView>(JxglTeachingView.class);
        util.exportExcel(response, list, "教学任务数据");
    }

    /**
     * 获取教学任务详细信息
     */
    @PreAuthorize("@ss.hasPermi('jxgl:teaching:query')")
    @GetMapping(value = "/{sid}")
    public AjaxResult getInfo(@PathVariable("sid") Long sid) {
        return success(jxglTeachingViewService.selectJxglTeachingViewBySid(sid));
    }

    /***查询我的任务列表*/
    @PreAuthorize("@ss.hasPermi('jxgl:teaching:my')")
    @GetMapping("/my")
    public TableDataInfo mylist(JxglTeachingView jxglTeachingView) {
        startPage();
        jxglTeachingView.setTno(this.getLoginUser().getUsername());
        List<JxglTeachingView> list = jxglTeachingViewService.selectJxglTeachingViewList(jxglTeachingView);
        return getDataTable(list);
    }

    /***获取教学任务详细信息*/
    @PreAuthorize("@ss.hasPermi('jxgl:sc:query')")
    @GetMapping("/sc")
    public TableDataInfo getTeachingList(@RequestParam Map<String, String> map) {
        startPage();
        List<Map<String, String>> list = jxglTeachingViewService.selectJxglScTeachingList(map);
        return getDataTable(list);
    }

    /***根据课号查询选课学期*/
    @PreAuthorize("@ss.hasPermi('jxgl:teaching:term')")
    @GetMapping("/term/{cno}")
    public AjaxResult getTeachingTermList(@PathVariable("cno") String cno) {
        List<Map<String, String>> list = jxglTeachingViewService.selectJxglScTermByCno(cno);
        return success(list);
    }

}
