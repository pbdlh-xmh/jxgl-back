package com.ruoyi.web.controller.jxgl;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.jxgl.domain.JxglCourse;
import com.ruoyi.jxgl.service.IJxglCourseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 课程管理Controller
 * 
 * @author zxx
 * @date 2024-09-26
 */
@RestController
@RequestMapping("/jxgl/course")
public class JxglCourseController extends BaseController
{
    @Autowired
    private IJxglCourseService jxglCourseService;

    /**
     * 查询课程管理列表
     */
    @PreAuthorize("@ss.hasPermi('jxgl:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(JxglCourse jxglCourse)
    {
        startPage();
        List<JxglCourse> list = jxglCourseService.selectJxglCourseList(jxglCourse);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('jxgl:course:list')")
    @GetMapping("/allList")
    public TableDataInfo allList(){
        List<JxglCourse>list=jxglCourseService.selectJxglCourseList(null);
        return getDataTable(list);
    }

    /**
     * 导出课程管理列表
     */
    @PreAuthorize("@ss.hasPermi('jxgl:course:export')")
    @Log(title = "课程管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JxglCourse jxglCourse)
    {
        List<JxglCourse> list = jxglCourseService.selectJxglCourseList(jxglCourse);
        ExcelUtil<JxglCourse> util = new ExcelUtil<JxglCourse>(JxglCourse.class);
        util.exportExcel(response, list, "课程管理数据");
    }

    /**
     * 获取课程管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('jxgl:course:query')")
    @GetMapping(value = "/{cno}")
    public AjaxResult getInfo(@PathVariable("cno") String cno)
    {
        return success(jxglCourseService.selectJxglCourseByCno(cno));
    }

    /**
     * 新增课程管理
     */
    @PreAuthorize("@ss.hasPermi('jxgl:course:add')")
    @Log(title = "课程管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JxglCourse jxglCourse)
    {
        return toAjax(jxglCourseService.insertJxglCourse(jxglCourse));
    }

    /**
     * 修改课程管理
     */
    @PreAuthorize("@ss.hasPermi('jxgl:course:edit')")
    @Log(title = "课程管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JxglCourse jxglCourse)
    {
        return toAjax(jxglCourseService.updateJxglCourse(jxglCourse));
    }

    /**
     * 删除课程管理
     */
    @PreAuthorize("@ss.hasPermi('jxgl:course:remove')")
    @Log(title = "课程管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{cnos}")
    public AjaxResult remove(@PathVariable String[] cnos)
    {
        return toAjax(jxglCourseService.deleteJxglCourseByCnos(cnos));
    }

}
