import request from '@/utils/request'

// 查询课程管理列表
export function listCourse(query) {
  return request({
    url: '/jxgl/course/list',
    method: 'get',
    params: query
  })
}

// 查询课程管理详细
export function getCourse(cno) {
  return request({
    url: '/jxgl/course/' + cno,
    method: 'get'
  })
}

// 新增课程管理
export function addCourse(data) {
  return request({
    url: '/jxgl/course',
    method: 'post',
    data: data
  })
}

// 修改课程管理
export function updateCourse(data) {
  return request({
    url: '/jxgl/course',
    method: 'put',
    data: data
  })
}

// 删除课程管理
export function delCourse(cno) {
  return request({
    url: '/jxgl/course/' + cno,
    method: 'delete'
  })
}

//查询所有课程档案列表
export function listAllCourse(){
  return request({
    url:'/jxgl/course/allList',
    method:'get'
  })
}