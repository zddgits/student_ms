function getReleaseList (params) {
  return $axios({
    url: '/notice/page',
    method: 'get',
    params
  })
}


// 新增---添加教师
function addRelease (params) {
  return $axios({
    url: '/notice',
    method: 'post',
    data: { ...params }
  })
}

// 修改---添加员工
function editRelease (params) {
  return $axios({
    url: '/notice',
    method: 'put',
    data: { ...params }
  })
}

// 修改页面反查详情接口
function queryReleaseById (id) {
  return $axios({
    url: `/notice/${id}`,
    method: 'get'
  })
}