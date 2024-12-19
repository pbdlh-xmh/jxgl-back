<template>
  <div class="app-container">
    <el-row :gutter="10" class="mb8">
      <el-col :span="12">
        <div class="member-toolbar">
          <div class="member-toolbar-course">
            <span>{{ theTeaching.cno }}|{{ theTeaching.cname }}|{{ theTeaching.period }}学时</span>
          </div>
          <div class="member-toolbar-tea"><span>{{ Math.floor(theTeaching.cterm / 10) }}年.</span><span
              v-if="theTeaching.cterm % 10 == 0">春</span><span v-else-if="theTeaching.cterm % 10 == 1">秋</span><span>{{
                theTeaching.tname }}</span><span>{{ theTeaching.ps }}</span>
          </div>
        </div>
        <div class="member-toolbar">
          <div class="member-toolbar-course"><span>选课</span>
          </div>
          <div class="member-toolbar-tea"><span v-if="theTeaching.isOpen" style="color:#67C23A;font-weight:bold">开启
            </span><span v-else style="color:#DCDFE6">关闭</span></div>
        </div>
        <div class="member-toolbar">
          <div class="member-toolbar-course"><span>录分</span></div>
          <div class="member-toolbar-tea"><span v-if="theTeaching.isOpenScore"
              style="color:#67C23A;font-weight:bold">开启</span><span v-else style="color: #DCDFE6">关闭</span>
          </div>
        </div>
      </el-col>
      <el-col :span="7.5"><el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch"
          label-width="68px"><el-form-item label="学生姓名" prop="cname"><el-input v-model="queryParams.sname"
              placeholder="请输入学生姓名" clearable @keyup.enter.native="handleQuery" />
          </el-form-item>
          <el-form-item><el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
          </el-form-item>
        </el-form>
      </el-col>
      <el-col :span="1.5"><el-button type="info" plainicon="el-icon-download" size="mini" @click="handleSc"
          v-hasPermi="['jxgl:sc:by']" >代填选课</el-button><el-button type="warning" plainicon="el-icon-download" size="mini"
          @click="handleExport" v-hasPermi="['jxgl:sc:export']">导出</el-button></el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"> </right-toolbar>
    </el-row>
    <el-table v-loading="loading" :data="stuList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="学号" align="center" prop="sno" />
      <el-table-column label="姓名" align="center" prop="sname" />
      <el-table-column label="班级" align="center" prop="sclass" />
      <el-table-column label="性别" align="center" prop="ssex" />
      <el-table-column label="分数" align="center" prop="score" />
      <el-table-column label="绩点" align="center" prop="point" />
      <el-table-column label="操作" align="center" class-name="small-paddingfixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" :disabled="!theTeaching.isOpenScore"
            @click="handleMembersc(scope.row)" v-hasPermi="['jxgl:sc:edit']">
            编辑成绩</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />
    <!--编辑学生成绩对话框-->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学期" prop="cterm"><span>{{ Math.floor(theTeaching.cterm / 10) }}年.</span>
          <span v-if="theTeaching.cterm % 10 == 0">春</span>
          <span v-else-if="theTeaching.cterm % 10 == 1">秋</span>
        </el-form-item>
        <el-form-item label="课程" prop="cname">
          <span>{{ theTeaching.cno }}|{{ theTeaching.cname }}|{{ theTeaching.period }}学时</span>
        </el-form-item><el-form-item label="成绩" prop="score"><el-input v-model="form.score" placeholder="请输入" />
        </el-form-item><el-form-item label="绩点" prop="point"><el-input v-model="form.point"
            placeholder="请输入" /></el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer"><el-button type="primary" @click="submitForm">确定</el-button>
        <el-button @click="cancel">取消</el-button>
      </div>
    </el-dialog>
    <!--代填选课对话框-->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body><el-form ref="form" :model="form"
        :rules="rules" label-width="80px">
        <el-form-item label="选课学生"prop="sno">
          <el-select v-model="form.sno" placeholder="请选择" @change="handleStuChange"
            clearablestyle="width:380px"><el-option v-for="dict in stuList" :key="dict.sno"
              :label="dict.sno + '|' + dict.sname + '|' + dict.sclass"
              :value="dict.sno"></el-option></el-select></el-form-item><el-form-item label="选课任务" prop="tid"><el-select
            v-model="form.tid" placeholder="请选择" clearablestyle="width:380px"><el-option
              v-for="dict in openTeachingList" :key="dict.id"
              :label="parseTermString(dict.cterm) + '|' + dict.cno + '' + dict.cname + '' + dict.period + '学时|' + dict.tname + '' + dict.ps"
              :value="dict.id"></el-option></el-select></el-form-item></el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确定</el-button><el-button @click="cancel">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listScMember, updateSc } from "@/api/jxgl/sc";
import { getTeaching } from "@/api/jxgl/teaching";
import { listMyScTeaching } from "@/api/jxgl/sc"

export default {
  name: "Student",
  dicts: ['sys_user_sex'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 学生档案表格数据
      stuList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      //是否禁用主键输入
      disabledFlag: false,
      //教师数据
      theTeaching: {},
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        sname: null,
        sclass: null,
      },
       //当前可选的教学任务
       openTeachingList: [],
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
    };

  },
  created() {
    this.getList();
    this.getTheTeaching();
  },
  methods: {
    
    handleStuChange(sno) {
      if (this.form.sno) {
        var query = { sno: this.form.sno, pageSize: 100, scStatus: 0, };
        listMyScTeaching(query).then(response => { this.openTeachingList = response.rows; });
      }
    },
    /**查询学生档案列表*/
    getList() {
      this.loading = true;
      listScMember(this.$route.params.tid, this.queryParams).then(response => {
        this.stuList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    getTheTeaching() {
      this.loading = true;//this.$route代码当前路由，params代表传入的参数
      getTeaching(this.$route.params.tid).then(response => {
        this.theTeaching = response.data;
        console.log(this.theTeaching);
        this.loading = false;
      });
    },
    /**修改成员成绩操作*/
    handleMembersc(row) {
      this.open = true;
      this.form = row;
      this.title = "编辑成绩";
    },
    /**处理代填选课*/
    handleSc() { 
      this.reset();
      this.title = "代填选课";
      this.open = true;
    },
    // 表单重置
    reset() {
      this.form = {
        sid: null,
        cterm: null,
        cno: null,
        tno: null,
        period: null,
        isOpen: null,
        isOpenScore: null
      };
      this.resetForm("form");
    },
    /**导出按钮操作*/
    handleExport() { },
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
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.sno)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /**弹层提交操作*/
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) { varobj = { sno: this.form.sno, tid: this.form.tid, cno: this.form.cno, score: this.form.score, point: this.form.point }; 
        updateSc(obj).then(response => { this.$modal.msgSuccess("修改成功"); this.open = false; this.getList(); }); } 
        else { alert("验证不通过！") }
        168
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
  }
};
</script>
<style>
.member-toolbar {
  margin-left: 20px;
  display: inline-block;
}

.member-toolbar-course {
  font-size: 14px;
  font-weight: bold;
}

.member-toolbar-tea {
  font-size: 12px;
  font-weight: bold;
}

.member-toolbar-tea span {
  margin-top: 5px;
}
</style>