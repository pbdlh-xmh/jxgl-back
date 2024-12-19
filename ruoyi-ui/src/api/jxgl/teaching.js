import request from '@/utils/request'

// 查询教学任务列表
export function listTeaching(query) {
  return request({
    url: '/jxgl/teaching/list',
    method: 'get',
    params: query
  })
}
//查询我的教学任务列表
export function listMyTeaching(query){
  return request(
    {url:'/jxgl/teaching/my',
      method:'get',params:query
    })
  }

// 查询教学任务详细
export function getTeaching(sid) {
  return request({
    url: '/jxgl/teaching/' + sid,
    method: 'get'
  })
}

// 新增教学任务
export function addTeaching(data) {
  return request({
    url: '/jxgl/teaching',
    method: 'post',
    data: data
  })
}

// 修改教学任务
export function updateTeaching(data) {
  return request({
    url: '/jxgl/teaching',
    method: 'put',
    data: data
  })
}

// 删除教学任务
export function delTeaching(sid) {
  return request({
    url: '/jxgl/teaching/' + sid,
    method: 'delete'
  })
}
