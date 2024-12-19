<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学期" prop="cterm">
        <el-select v-model="queryParams.cterm"placeholder="请选择学期"clearablestyle="width:160px">
          <el-option v-for="dict in initTermList"
          :key="dict.value"
          :label="dict.label"
          :value="dict.value"/>
        </el-select>
      </el-form-item>
      <el-form-item label="课程名称" prop="cname">
        <el-input
          v-model="queryParams.cname"
          placeholder="请输入课程名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="选课状态" prop="isOpen"> <el-select v-model ="queryParams.isOpen"placeholder="请选择"clearablestyle="width:160px">
        <el-option v-for="dict in dict.type.jxgl_open_close"
        :key="dict.value"
        :label="dict.label"
        :value="dict.value"/>
      </el-select>
    </el-form-item>
    <el-form-item label="录分状态" prop="isOpenScore">
      <el-select v-model="queryParams.isOpenScore"placeholder="请选择"clearablestyle="width:160px">
        <el-option v-for="dict in dict.type.jxgl_open_close"
        :key="dict.value"
        :label="dict.label"
        :value="dict.value"/>
      </el-select>
    </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['jxgl:teaching:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="teachingList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="学期" align="center" prop="cterm">
        <template slot-scope="scope">
          <span>{{Math.floor(scope.row.cterm/10)}}年.</span>
          <span v-if="scope.row.cterm%10==0">春</span>
          <span v-else-if="scope.row.cterm%10==1">秋</span>
        </template>
       </el-table-column>
       <el-table-column label="课程信息"align="left"width="240">
        <template slot-scope="scope">
          {{scope.row.cno}}|{{scope.row.cname}}
        </template>
      </el-table-column>
      <el-table-column label="学时" align="center" prop="period" width="160"/>
      <el-table-column label="教工信息"  width="120">
        <template slot-scope="scope">
          {{scope.row.tno}}|{{scope.row.tname}}
        </template>
      </el-table-column>
      <el-table-column label="职称" align="center" prop="ps">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.jxgl_tea_ps" :value="scope.row.ps"/>
        </template>
      </el-table-column>
      <el-table-column label="开放选课？" align="center" prop="isOpen">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.jxgl_open_close" :value="scope.row.isOpen"/>
        </template>
      </el-table-column>
      <el-table-column label="开放录分" align="center" prop="isOpenScore">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.jxgl_open_close" :value="scope.row.isOpenScore"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit"
           @click="handleMember(scope.row)"  
          v-hasPermi="['jxgl:member:list']" >
          学员管理
        </el-button>
        </template>
        
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改教学任务对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学期" prop="cterm">
        <el-select v-model="queryParams.cterm"placeholder="请选择学期"clearablestyle="width:160px">
          <el-option v-for="dict in initTermList"
          :key="dict.value"
          :label="dict.label"
          :value="dict.value"/>
        </el-select>
      </el-form-item>
      <el-form-item label="课程名称" prop="cname">
        <el-select v-model="form.cno"placeholder="请选择课程"style="width:380px">
          <el-option v-for ="dict in courseList"
          :key="dict.cno"
          :label="dict.cno+'|'+dict.cname"
          :value="dict.cno">
          </el-option>
      </el-select></el-form-item>
      <el-form-item label="学时" prop="period">
          <el-input v-model="form.period" placeholder="请输入学时" />
        </el-form-item>
      <el-form-item label="任课教师" prop="tno">
        <el-select v-model="form.tno" placeholder="请选择教师"style="width:380px">
          <el-option v-for="dict in teacherList"
          :key="dict.tno"
          :label="dict.tno+'|'+dict.tname"
          :value="dict.tno"></el-option>
        </el-select>
      </el-form-item>   
        <el-form-item label="开放选课？" prop="isOpen">
          <el-radio-group v-model="form.isOpen">
            <el-radio
              v-for="dict in dict.type.jxgl_open_close"
              :key="dict.value"
              :label="parseInt(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="开放录分" prop="isOpenScore">
          <el-radio-group v-model="form.isOpenScore">
            <el-radio
              v-for="dict in dict.type.jxgl_open_close"
              :key="dict.value"
              :label="parseInt(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {listMyTeaching,getTeaching}from"@/api/jxgl/teaching";

export default {
  name: "Teaching",
  dicts: ['jxgl_tea_ps','jxgl_open_close'],
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
      // 教学任务表格数据
      teachingList: [],
      // 弹出层标题
      title: "",
      //初始学期
      initTermList:[],
      //课程列表
      courseList:[],
      //教师列表
      teacherList:[],
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        cterm: null,
        cno: null,
        tno: null,
        period: null,
        isOpen: null,
        isOpenScore: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        sid: [
          { required: true, message: "任务号不能为空", trigger: "blur" }
        ],
        cno: [
          { required: true, message: "课号不能为空", trigger: "blur" }
        ],
        isOpen: [
          { required: true, message: "开放选课？不能为空", trigger: "change" }
        ],
        isOpenScore: [
          { required: true, message: "开放录分不能为空", trigger: "change" }
        ]
      }
    };
  },
  created() {
    this.getList();
    this.makeInitTerms();
  },
  methods: {
    makeInitTerms(){
      var terms=[]; 
      var date=new Date();
      var yyyy=date.getFullYear();
      for(var i=yyyy+3;i>=yyyy-15;i--){
        terms.push({label:i+'年.秋',value:i*10+1});
        terms.push({label:i+'年.春',value:i*10});
      }
      this.initTermList=terms;
    },
    /** 查询教学任务列表 */
    getList() {
      this.loading = true;
      listMyTeaching(this.queryParams).then(response => {
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
      this.ids = selection.map(item => item.sid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加教学任务";
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
    handleMember(row){
      // console.log(row)
      // alert(row.sid)
        // url = '/jxgl/v-teaching/member/'+row.id;
        // alert(url);
        this.$router.push('/jxgl/v-teaching/member/'+row.sid);
    },  
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.sid != null) {
            updateTeaching(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTeaching(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const sids = row.sid || this.ids;
      this.$modal.confirm('是否确认删除教学任务编号为"' + sids + '"的数据项？').then(function() {
        return delTeaching(sids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
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
