import request from '@/utils/request'

// 查询教学任务列表
export function listTeaching_view(query) {
  return request({
    url: '/jxgl/teaching_view/list',
    method: 'get',
    params: query
  })
}

// 查询教学任务详细
export function getTeaching_view(sid) {
  return request({
    url: '/jxgl/teaching_view/' + sid,
    method: 'get'
  })
}

// 新增教学任务
export function addTeaching_view(data) {
  return request({
    url: '/jxgl/teaching_view',
    method: 'post',
    data: data
  })
}

// 修改教学任务
export function updateTeaching_view(data) {
  return request({
    url: '/jxgl/teaching_view',
    method: 'put',
    data: data
  })
}

// 删除教学任务
export function delTeaching_view(sid) {
  return request({
    url: '/jxgl/teaching_view/' + sid,
    method: 'delete'
  })
}
