function getTeacherList (params) {
  return $axios({
    url: '/teacher/page',
    method: 'get',
    params
  })
}


// 新增---添加教师
function addTeacher (params) {
  return $axios({
    url: '/teacher',
    method: 'post',
    data: { ...params }
  })
}

// 修改---添加员工
function editTeacher (params) {
  return $axios({
    url: '/teacher',
    method: 'put',
    data: { ...params }
  })
}

// 修改页面反查详情接口
function queryTeacherById (id) {
  return $axios({
    url: `/teacher/${id}`,
    method: 'get'
  })
}