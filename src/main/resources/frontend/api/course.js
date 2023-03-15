function getCourseList (params) {
  return $axios({
    url: '/course/page',
    method: 'get',
    params
  })
}


// 新增---添加教师
function addCourse (params) {
  return $axios({
    url: '/course',
    method: 'post',
    data: { ...params }
  })
}

// 修改---添加员工
function editCourse (params) {
  return $axios({
    url: '/course',
    method: 'put',
    data: { ...params }
  })
}

// 修改页面反查详情接口
function queryCourseById (id) {
  return $axios({
    url: `/course/${id}`,
    method: 'get'
  })
}