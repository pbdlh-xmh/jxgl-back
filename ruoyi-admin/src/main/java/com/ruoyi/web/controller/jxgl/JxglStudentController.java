package com.ruoyi.web.controller.jxgl;

import java.util.List;
import java.util.Map;
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
import com.ruoyi.jxgl.domain.JxglStudent;
import com.ruoyi.jxgl.service.IJxglStudentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生档案Controller
 *
 * @author zxx
 * @date 2024-09-26
 */
@RestController
@RequestMapping("/jxgl/student")
public class JxglStudentController extends BaseController {
    @Autowired
    private IJxglStudentService jxglStudentService;

    /**
     * 查询学生档案列表
     */
    @PreAuthorize("@ss.hasPermi('jxgl:student:list')")
    @GetMapping("/list")
    public TableDataInfo list(JxglStudent jxglStudent) {
        startPage();
        List<JxglStudent> list = jxglStudentService.selectJxglStudentList(jxglStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生档案列表
     */
    @PreAuthorize("@ss.hasPermi('jxgl:student:export')")
    @Log(title = "学生档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JxglStudent jxglStudent) {
        List<JxglStudent> list = jxglStudentService.selectJxglStudentList(jxglStudent);
        ExcelUtil<JxglStudent> util = new ExcelUtil<JxglStudent>(JxglStudent.class);
        util.exportExcel(response, list, "学生档案数据");
    }

    /**
     * 获取学生档案详细信息
     */
    @PreAuthorize("@ss.hasPermi('jxgl:student:query')")
    @GetMapping(value = "/{sno}")
    public AjaxResult getInfo(@PathVariable("sno") String sno) {
        return success(jxglStudentService.selectJxglStudentBySno(sno));
    }

    /**
     * 新增学生档案
     */
    @PreAuthorize("@ss.hasPermi('jxgl:student:add')")
    @Log(title = "学生档案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JxglStudent jxglStudent) {
        return toAjax(jxglStudentService.insertJxglStudent(jxglStudent));
    }

    /**
     * 修改学生档案
     */
    @PreAuthorize("@ss.hasPermi('jxgl:student:edit')")
    @Log(title = "学生档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JxglStudent jxglStudent) {
        return toAjax(jxglStudentService.updateJxglStudent(jxglStudent));
    }

    /**
     * 删除学生档案
     */
    @PreAuthorize("@ss.hasPermi('jxgl:student:remove')")
    @Log(title = "学生档案", businessType = BusinessType.DELETE)
    @DeleteMapping("/{snos}")
    public AjaxResult remove(@PathVariable String[] snos) {
        return toAjax(jxglStudentService.deleteJxglStudentBySnos(snos));
    }

    @PreAuthorize("@ss.hasPermi('jxgl:student:list')")
    @GetMapping("/like/{key}")
    public AjaxResult likeList(@PathVariable("key")String key) {
        List<Map<String, String>> list = jxglStudentService.selectJxglStudentLikeList(key);
        return success(list);
    }
}
