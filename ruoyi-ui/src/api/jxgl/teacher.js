import request from '@/utils/request'

// 查询教师管理列表
export function listTeacher(query) {
  return request({
    url: '/jxgl/teacher/list',
    method: 'get',
    params: query
  })
}
//查询所有教师档案列表
export function listAllTeacher(){
  return request({
    url:'/jxgl/teacher/allList',
    method:'get'
  })
}

// 查询教师管理详细
export function getTeacher(tno) {
  return request({
    url: '/jxgl/teacher/' + tno,
    method: 'get'
  })
}

// 新增教师管理
export function addTeacher(data) {
  return request({
    url: '/jxgl/teacher',
    method: 'post',
    data: data
  })
}

// 修改教师管理
export function updateTeacher(data) {
  return request({
    url: '/jxgl/teacher',
    method: 'put',
    data: data
  })
}

// 删除教师管理
export function delTeacher(tno) {
  return request({
    url: '/jxgl/teacher/' + tno,
    method: 'delete'
  })
}
