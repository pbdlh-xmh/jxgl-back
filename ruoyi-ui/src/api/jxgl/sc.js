import request from '@/utils/request'

//查询选课班级成员列表
export function listScMember(tid, query) {
    return request({
        url: '/jxgl/sc/list/' + tid,
        method: 'get',
        params: query
    })
}

//修改成绩
export function updateSc(data) {
    return request({
        url: '/jxgl/sc', method: 'put', data: data
    })
}
//查询选课列表
export function listMyScTeaching(query) {
    return request({
        url: '/jxgl/sc/teaching',
        method: 'get',
        params: query
    })
}

//新增选课
export function addSc(data) { return request({ url: '/jxgl/sc', method: 'post', data: data }) }
//删除选课
export function delSc(tid) { return request({ url: '/jxgl/sc/' + tid, method: 'delete' }) }
//查询选课列表
export function listTeachingSc(query){return request({url:'/jxgl/teaching/sc',method:'get',params:query})}
//查询选课列表
export function listTeachingTerm(cno){return request({url:'/jxgl/teaching/term/'+cno, method:'get'})}
//查询我的课程成绩
export function listMySc(query){return request({url:'/jxgl/sc/myscore',method:'get',params:query})}

