function getStudentList (params) {
  return $axios({
    url: '/student/page',
    method: 'get',
    params
  })
}


// 新增---添加教师
function addStudent (params) {
  return $axios({
    url: '/student',
    method: 'post',
    data: { ...params }
  })
}

// 修改---添加员工
function editStudent (params) {
  return $axios({
    url: '/student',
    method: 'put',
    data: { ...params }
  })
}

// 修改页面反查详情接口
function queryStudentById (id) {
  return $axios({
    url: `/student/${id}`,
    method: 'get'
  })
}