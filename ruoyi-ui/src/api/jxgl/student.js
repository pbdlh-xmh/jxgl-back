import request from '@/utils/request'

// 查询学生档案列表
export function listStudent(query) {
  return request({
    url: '/jxgl/student/list',
    method: 'get',
    params: query
  })
}

// 查询学生档案详细
export function getStudent(sno) {
  return request({
    url: '/jxgl/student/' + sno,
    method: 'get'
  })
}

// 新增学生档案
export function addStudent(data) {
  return request({
    url: '/jxgl/student',
    method: 'post',
    data: data
  })
}

// 修改学生档案
export function updateStudent(data) {
  return request({
    url: '/jxgl/student',
    method: 'put',
    data: data
  })
}

// 删除学生档案
export function delStudent(sno) {
  return request({
    url: '/jxgl/student/' + sno,
    method: 'delete'
  })
}
//查询学生档案列表
export function listLikeStudent(key){return request({url:'/jxgl/student/like/'+key,method:'get'})}