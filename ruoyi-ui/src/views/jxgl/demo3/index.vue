<template>
    <div id="app-container">
        <h2>{{ stuNmae }}</h2>
        <p>{{ redText }}</p>
        <p v-html="redText"></p>
        <hr>
        <el-row :gutter="20">
            <el-col :span="1.5">
                <button v-bind:disabled="disabledFlag"
                v-on:click="btnClickHandler">可以点我</button>
            </el-col>
            <el-col :span="1.5">
                <button v-bind:disabled="!disabledFlag">可以点我</button>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :span="1.5">
                <button :disabled="disabledFlag"
                @click="btnClickHandler">可以点我</button>
            </el-col>
        </el-row>
        <hr>
        <h2 v-if="showFlag">{{ stuNmae }}</h2>
        <h2 v-else v-html="xiaohong"></h2>
        <button @click="switchClickHandler">切换</button>
        <hr>
        <ul>
            <li v-for="item in stuList" :key="item.sno">
                {{ item.sno }}|{{ item.sname }}
            </li>
        </ul>
    </div>
</template>

<script>
    export default {
        name:'dwmo3',
        data(){
            return{
                stuNmae:'张三',
                redText:'<span style="color:red">这是一段红色文本</span>',
                disabledFlag:false,
                showFlag:true,
                xiaohong:'<span style="color:red">小红</span>',
                stuList:[
                    {sno:'1001',sname:"张三"},
                    {sno:'1002',sname:"李三"},
                    {sno:'1003',sname:"王三"},
                ]
                
                
            }
        },
       methods:{
            btnClickHandler(){
                alert('hello world');
            },
            switchClickHandler(){
                this.showFlag=!this.showFlag;
            }
       }
    }
</script>

<style lang="scss" scoped>

</style>