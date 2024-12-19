package com.ruoyi.web.controller.jxgl;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.jxgl.domain.JxglScView;
import com.ruoyi.jxgl.domain.JxglTeachingView;
import com.ruoyi.jxgl.service.IJxglScService;
import com.ruoyi.jxgl.service.IJxglTeachingViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 159*教学任务Controller**@authorruoyi*@date2024-05-22
 */
@RestController
@RequestMapping("/jxgl/sc")
public class JxglScController extends BaseController {
    @Autowired
    private IJxglScService jxglScService;
    @Autowired
    private IJxglTeachingViewService jxglTeachingViewService;

    /***查询班级成员管理列表*/
    @PreAuthorize("@ss.hasPermi('jxgl:member:list')")
    @GetMapping("/list/{tid}")
    public TableDataInfo list(@PathVariable Long tid, @RequestParam Map<String, String> map) {
        startPage();
        map.put("tid", tid.toString());
        List<JxglScView> list = jxglScService.selectJxglScList(map);
        return getDataTable(list);
    }

    /***编辑成绩*/
    @PreAuthorize("@ss.hasPermi('jxgl:sc:edit')")
    @Log(title = "编辑成绩", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Map<String, String> map) {
        return toAjax(jxglScService.updateJxglSc(map));
    }

    /***查询我的选课任务列表
     182*/
    @PreAuthorize("@ss.hasPermi('jxgl:sc:teaching')")
    @GetMapping("/teaching")
    public TableDataInfo getScTeaching(@RequestParam Map<String, String> map) {
        startPage();
        if (map.get("sno") == null) {
            map.put("sno", this.getUsername());
        }
        map.put("sno", this.getUsername());
        List<JxglTeachingView> list = jxglTeachingViewService.selectJxglMyScTeachingList(map);
        return getDataTable(list);
    }

    /***增加选课*/
    @PreAuthorize("@ss.hasPermi('jxgl:sc:add')")
    @Log(title = "增加选课", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JxglScView view) {
        if (view.getSno() == null) {
            view.setSno(this.getUsername());
        }
        if (view.getCno() == null) {
            String cno = jxglTeachingViewService.selectJxglTeachingViewById(view.getTid()).getCno();
            view.setCno(cno);
        }
        return toAjax(jxglScService.insertJxglSc(view));
    }

    /***删除选课*/
    @PreAuthorize("@ss.hasPermi('jxgl:sc:remove')")
    @Log(title = "删除选课", businessType = BusinessType.DELETE)
    @DeleteMapping("/{tid}")
    public AjaxResult remove(@PathVariable Integer tid) {
        Map<String, String> map = new HashMap<>();
        map.put("sno", this.getUsername());
        map.put("tid", tid.toString());
        return toAjax(jxglScService.deleteJxglSc(map));
    }

    @PreAuthorize("@ss.hasPermi('jxgl:sc:myscore')")
    @GetMapping("/myscore")
    public TableDataInfo list(@RequestParam Map<String, String>map) {
        startPage();
        if (map.get("sno") == null) {
            map.put("sno", this.getUsername());
        }
        List<Map<String, String>> list = jxglScService.selectJxglMyScList(map);
        return getDataTable(list);
    }

}