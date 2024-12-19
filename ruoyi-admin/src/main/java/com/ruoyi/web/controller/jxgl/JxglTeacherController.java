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
import com.ruoyi.jxgl.domain.JxglTeacher;
import com.ruoyi.jxgl.service.IJxglTeacherService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教师管理Controller
 * 
 * @author zxx
 * @date 2024-09-26
 */
@RestController
@RequestMapping("/jxgl/teacher")
public class JxglTeacherController extends BaseController
{
    @Autowired
    private IJxglTeacherService jxglTeacherService;

    /**
     * 查询教师管理列表
     */
    @PreAuthorize("@ss.hasPermi('jxgl:teacher:list')")
    @GetMapping("/list")
    public TableDataInfo list(JxglTeacher jxglTeacher)
    {
        startPage();
        List<JxglTeacher> list = jxglTeacherService.selectJxglTeacherList(jxglTeacher);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('jxgl:teacher:list')")
    @GetMapping("/allList")
    public TableDataInfo allList() {
        List<JxglTeacher> list = jxglTeacherService.selectJxglTeacherList(null);
        return getDataTable(list);
    }

    /**
     * 导出教师管理列表
     */
    @PreAuthorize("@ss.hasPermi('jxgl:teacher:export')")
    @Log(title = "教师管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JxglTeacher jxglTeacher)
    {
        List<JxglTeacher> list = jxglTeacherService.selectJxglTeacherList(jxglTeacher);
        ExcelUtil<JxglTeacher> util = new ExcelUtil<JxglTeacher>(JxglTeacher.class);
        util.exportExcel(response, list, "教师管理数据");
    }

    /**
     * 获取教师管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('jxgl:teacher:query')")
    @GetMapping(value = "/{tno}")
    public AjaxResult getInfo(@PathVariable("tno") String tno)
    {
        return success(jxglTeacherService.selectJxglTeacherByTno(tno));
    }

    /**
     * 新增教师管理
     */
    @PreAuthorize("@ss.hasPermi('jxgl:teacher:add')")
    @Log(title = "教师管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JxglTeacher jxglTeacher)
    {
        return toAjax(jxglTeacherService.insertJxglTeacher(jxglTeacher));
    }

    /**
     * 修改教师管理
     */
    @PreAuthorize("@ss.hasPermi('jxgl:teacher:edit')")
    @Log(title = "教师管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JxglTeacher jxglTeacher)
    {
        return toAjax(jxglTeacherService.updateJxglTeacher(jxglTeacher));
    }

    /**
     * 删除教师管理
     */
    @PreAuthorize("@ss.hasPermi('jxgl:teacher:remove')")
    @Log(title = "教师管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{tnos}")
    public AjaxResult remove(@PathVariable String[] tnos)
    {
        return toAjax(jxglTeacherService.deleteJxglTeacherByTnos(tnos));
    }
}
