<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch"
      label-width="68px"><el-form-item label="学期" prop="cterm"><el-select v-model="queryParams.cterm"
          placeholder="请选择学期" clearablestyle="width:160px"><el-option v-for="dict in initTermList" :key="dict.value"
            :label="dict.label" :value="dict.value" /></el-select></el-form-item><el-form-item label="课程名称"
        prop="cname"><el-input v-model="queryParams.cname" placeholder="请输入课程名称" clearable
          @keyup.enter.native="handleQuery" /></el-form-item><el-form-item label="教师姓名" prop="cname"><el-input
          v-model="queryParams.tname" placeholder="请输入教师姓名" clearable
          @keyup.enter.native="handleQuery" /></el-form-item><el-form-item label="学号" prop="cname"><el-input
          v-model="queryParams.sno" placeholder="请输入学号" clearable
          @keyup.enter.native="handleQuery" /></el-form-item><el-form-item label="学生姓名" prop="cname"><el-input
          v-model="queryParams.sname" placeholder="请输入学生姓名" clearable
          @keyup.enter.native="handleQuery" /></el-form-item><el-form-item><el-button type="primary"
          icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button></el-form-item></el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="20"><el-button type="primary" plainicon="el-icon-plus" size="mini" @click="handleAdd"
          v-hasPermi="['jxgl:teaching:add']">代填选课</el-button></el-col><right-toolbar :showSearch.sync="showSearch"
        @queryTable="getList"></right-toolbar></el-row>

    <el-table v-loading="loading" :data="teachingList"><el-table-column type="selection" width="55"
        align="center" /><el-table-column label="学期" align="center" prop="cterm"><template slot-scope="scope">
          <div v-if="scope.row.cterm > 10000"><span>{{ Math.floor(scope.row.cterm /
            10) }}年.</span><span v-if="scope.row.cterm % 10 == 0">春</span><span
              v-else-if="scope.row.cterm % 10 == 1">秋</span>
          </div>
          <div v-else>-</div>
        </template></el-table-column><el-table-column label="学生信息" align="left" width="240"><template
          slot-scope="scope">{{
            scope.row.sno }}|{{ scope.row.sname }}|{{ scope.row.sclass }}
        </template></el-table-column><el-table-column label="课程信息" align="left" width="240"><template
          slot-scope="scope">{{ scope.row.cno }}|{{ scope.row.cname
          }}</template></el-table-column><el-table-column label="学时" align="center" prop="period"
        width="160" /><el-table-column label="教工信息" width="120"><template slot-scope="scope">
          <div v-if="scope.row.tno">{{
            scope.row.tno }}|{{ scope.row.tname }}
          </div>
        </template>
      </el-table-column><el-table-column label="职称" align="center" prop="ps"><template slot-scope="scope"><dict-tag
            :options="dict.type.jxgl_tea_ps" :value="scope.row.ps" />
        </template></el-table-column><el-table-column label="成绩" align="center" prop="score"
        width="160" /><el-table-column label="绩点" align="center" prop="point" width="160" /><el-table-column label="操作"
        align="center" class-name="small-paddingfixed-width"><template slot-scope="scope"><el-button size="mini"
            type="text" icon="el-icon-edit" @click="handleTerm(scope.row)"
            v-hasPermi="['jxgl:sc:term']">编辑学期</el-button>
        </template></el-table-column></el-table>
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!--编辑选课学期-->
    <el-dialog :title="title" :visible.sync="openTerm" width="500px" append-to-body><el-form ref="formTerm"
        :model="formTerm" :rules="termRules" label-width="80px"><el-form-item label="学生" prop="cname">{{ stuInfo
          }}</el-form-item>
        <el-form-item label="选择课程" prop="cname">{{ courseInfo }}</el-form-item><el-form-item label="选课学期"
          prop="cterm"><el-select v-model="formTerm.tid" placeholder="请选择学期" clearablestyle="width:380px"><el-option
              v-for="dict in forTermList" :key="dict.value"
              :label="parseTermString(dict.cterm) + '|' + dict.period + '学时|' + dict.tname"
              :value="dict.sid"></el-option></el-select></el-form-item></el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确定</el-button><el-button @click="cancel">取消</el-button>
      </div>
    </el-dialog>
    <!--代填选课对话框-->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body><el-form ref="form" :model="form"
        :rules="rules" label-width="80px"><el-form-item label="查学生" prop="stuKey"><el-col :span="20"><el-input
              v-model="stuKey" placeholder="请输入学号或姓名" />
          </el-col><el-col :span="1"><el-button type="primary" plainicon="el-icon-search"
              @click="handleQueryStu">查询</el-button></el-col></el-form-item><el-form-item label="选课学生"
          prop="sno"><el-select v-model="form.sno" placeholder="请选择" @change="handleStuChange"
            clearablestyle="width:380px"><el-option v-for="dict in stuList" :key="dict.sno"
              :label="dict.sno + '|' + dict.sname + '|' + dict.sclass"
              :value="dict.sno"></el-option></el-select></el-form-item><el-form-item label="选课任务" prop="tid"><el-select
            v-model="form.tid" placeholder="请选择" clearablestyle="width:380px"><el-option
              v-for="dict in openTeachingList" :key="dict.id"
              :label="parseTermString(dict.cterm) + '|' + dict.cno + '' + dict.cname + '' + dict.period + '学时|' + dict.tname + '' + dict.ps"
              :value="dict.sid"></el-option></el-select></el-form-item></el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm1">确定</el-button><el-button @click="cancel">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listTeachingSc, updateSc, addSc, delSc, listTeachingTerm ,listMyScTeaching } from "@/api/jxgl/sc";
import { listLikeStudent } from "@/api/jxgl/student";

export default {
  name: "Teaching",
  dicts: ['jxgl_sc_status', 'jxgl_tea_ps'],
  data() {
    return {
      //遮罩层
      loading: true,
      //选中数组
      ids: [],
      //非单个禁用
      single: true,
      //非多个禁用
      multiple: true,
      //显示搜索条件
      showSearch: true,
      //总条数
      total: 0,
      //教学任务表格数据
      teachingList: [],
      initTermList: [],
      //弹出层标题
      title: "",
      //是否显示弹出层
      open: false,
      //是否显示编辑学期弹出层
      openTerm: false,
      stuInfo: '',
      courseInfo: '',
      forTermList: [],
      //查询参数
      queryParams: { pageNum: 1, pageSize: 10, cterm: null, cname: null, scStatus: null, },
      //当前可选的教学任务
      openTeachingList: [],
      //是否显示编辑学期弹出层
      //学期表单
      formTerm: {},
      //当前可选的教学任务
      //学生查询关键字
      stuKey: null,
      //待选的学生列表
      stuList: [],
      //表单参数
      form: {},
      //表单校验
      rules: {
        sno: [
          { required: true, message: "学号不能为空", trigger: "blur" }
        ],
        tid: [
          { required: true, message: "教学任务不能为空", trigger: "blur" }
        ],
      },

      //表单校验
      termRules: {
        tid: [
          { required: true, message: "id不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.makeInitTerms();
  },
  methods: {
    parseTermString(termInt) {
      var res = '-';
      if (termInt >= 10000) {
        var year = Math.round(termInt / 10, 0);
        var seasons = ['春', '秋'];
        res = year + '年.' + seasons[termInt % 10];
      }
      return res;
    },
    makeInitTerms() {
      var terms = [];
      var date = new Date();
      var yyyy = date.getFullYear();
      for (var i = yyyy + 3; i >= yyyy - 15; i--) {
        terms.push({ label: i + '年.秋', value: i * 10 + 1 });
        terms.push({ label: i + '年.春', value: i * 10 });
      }
      this.initTermList = terms;
    },
    /** 查询教学任务列表 */
    getList() {
      this.loading = true;
      listTeachingSc(this.queryParams).then(response => {
        this.teachingList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        cterm: null,
        cno: null,
        cname: null,
        period: null,
        tno: null,
        tname: null,
        ps: null,
        isOpen: null,
        isOpenScore: null
      };
      this.resetForm("form");
    },
    /**代填选课操作*/
    handleAdd(row) {
      this.reset();
      this.title = "代填选课";
      this.open = true;
    },
    handleQueryStu() {
      if (this.stuKey) {
        listLikeStudent(this.stuKey).then(response => {
          this.stuList = response.data;
        }
        )
      }
    },
    handleStuChange(sno) {
      if (this.form.sno) {
        var query = { sno: this.form.sno, pageSize: 100, scStatus: 0, };
        listMyScTeaching(query).then(response => { this.openTeachingList = response.rows; });
      }
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /**处理学期操作*/
    handleTerm(row) {
      this.reset();
      this.formTerm.id = row.id;
      listTeachingTerm(row.cno).then(response => {
        this.forTermList = response.data; this.openTerm = true;
        this.stuInfo = row.sno + '|' + row.sname; this.courseInfo = row.cno + '|' + row.cname;
        this.title = "编辑选课学期";
      })
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.sid)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },

    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const sid = row.sid || this.ids
      getTeaching(sid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改教学任务";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["formTerm"].validate(valid => {
        if (valid) {
          var obj = {
            tid: this.formTerm.tid,
            id: this.formTerm.id
          };
          updateSc(obj).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.openTerm = false;
            this.getList();
          });
        }
      });
    },
    submitForm1() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          addSc(this.form).then(response => {
            this.$modal.msgSuccess("代选成功");
            this.open = false; this.getList();
          });
        } else {
          alert("验证不通过！");
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const sids = row.sid || this.ids;
      this.$modal.confirm('是否确认删除教学任务编号为"' + sids + '"的数据项？').then(function () {
        return delTeaching(sids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => { });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('jxgl/teaching/export', {
        ...this.queryParams
      }, `teaching_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
