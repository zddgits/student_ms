function loginApi(data) {
  return $axios({
    'url': '/user/login',
    'method': 'post',
    data
  })
}

function logoutApi(){
  return $axios({
    'url': '/user/logout',
    'method': 'post',
  })
}
function sendMsgApi(data) {
  return $axios({
    'url': '/user/sendMsg',
    'method': 'post',
    data
  })
}

function changeApi(data) {
  return $axios({
    'url': '/user/changePwd',
    'method': 'post',
    data
  })
}
function updateApi(data) {
  return $axios({
    'url': '/user/updatePwd',
    'method': 'post',
    data
  })
}
