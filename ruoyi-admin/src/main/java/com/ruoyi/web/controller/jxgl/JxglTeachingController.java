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
import com.ruoyi.jxgl.domain.JxglTeaching;
import com.ruoyi.jxgl.service.IJxglTeachingService;
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
public class JxglTeachingController extends BaseController {
    @Autowired
    private IJxglTeachingService jxglTeachingService;

    /**
     * 新增教学任务
     */
    @PreAuthorize("@ss.hasPermi('jxgl:teaching:add')")
    @Log(title = "教学任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JxglTeaching jxglTeaching) {
        return toAjax(jxglTeachingService.insertJxglTeaching(jxglTeaching));
    }

    /**
     * 修改教学任务
     */
    @PreAuthorize("@ss.hasPermi('jxgl:teaching:edit')")
    @Log(title = "教学任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JxglTeaching jxglTeaching) {
        return toAjax(jxglTeachingService.updateJxglTeaching(jxglTeaching));
    }

    /**
     * 删除教学任务
     */
    @PreAuthorize("@ss.hasPermi('jxgl:teaching:remove')")
    @Log(title = "教学任务", businessType = BusinessType.DELETE)
    @DeleteMapping("/{sids}")
    public AjaxResult remove(@PathVariable Long[] sids) {
        return toAjax(jxglTeachingService.deleteJxglTeachingBySids(sids));
    }
}
