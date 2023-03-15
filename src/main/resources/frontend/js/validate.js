
function isValidUsername (str) {
  return ['admin', 'editor'].indexOf(str.trim()) >= 0;
}

function isExternal (path) {
  return /^(https?:|mailto:|tel:)/.test(path);
}

function isCellPhone (val) {
  if (!/^1(3|4|5|6|7|8)\d{9}$/.test(val)) {
    return false
  } else {
    return true
  }
}

//校验账号
function checkUserName (rule, value, callback){
  if (value == "") {
    callback(new Error("请输入账号"))
  } else if (value.length > 20 || value.length <3) {
    callback(new Error("账号长度应是3-20"))
  } else {
    callback()
  }
}

//校验姓名
function checkName (rule, value, callback){
  if (value == "") {
    callback(new Error("请输入姓名"))
  } else {
    callback()
  }
}

function checkPhone (rule, value, callback){
  // let phoneReg = /(^1[3|4|5|6|7|8|9]\d{9}$)|(^09\d{8}$)/;
  if (value == "") {
    callback(new Error("请输入手机号"))
  } else if (!isCellPhone(value)) {//引入methods中封装的检查手机格式的方法
    callback(new Error("请输入正确的手机号!"))
  } else {
    callback()
  }
}


function validMail (rule,value,callback) {
  // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
  let reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/
  if(value == '') {
    callback(new Error('请输入邮箱'))
  } else if (reg.test(value)) {
    callback()
  } else {
    callback(new Error('邮箱格式不正确'))
  }
}
function validMajor (rule,value,callback) {
  if(value == '') {
    callback(new Error('请输入专业名称'))
  } else {
    callback()
  }
}

function validClassName (rule,value,callback) {
  if(value == '') {
    callback(new Error('请输入班级名称'))
  } else {
    callback()
  }
}
function validCate (rule,value,callback) {
  if(value == '') {
    callback(new Error('请输入分类'))
  } else {
    callback()
  }
}
function validBegin (rule,value,callback) {
  if(value == '') {
    callback(new Error('请输入开始时间'))
  } else {
    callback()
  }
}
function validPlace (rule,value,callback) {
  if(value == '') {
    callback(new Error('请输入授课地点'))
  } else {
    callback()
  }
}
function validEnd (rule,value,callback) {
  if(value == '') {
    callback(new Error('请输入结束时间'))
  } else {
    callback()
  }
}
function validContent (rule,value,callback) {
  if(value == '') {
    callback(new Error('请输入通知内容'))
  } else {
    callback()
  }
}
function validAcceptor (rule,value,callback) {
  if(value == '') {
    callback(new Error('请输入接收对象'))
  } else {
    callback()
  }
}
