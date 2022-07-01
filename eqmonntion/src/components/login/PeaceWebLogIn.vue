<template>
  <div class="loginPageBox">
    <h1>This is login page</h1>
    <div>用户名</div>
    <div>密码</div>
  </div>
</template>

<script>
export default {
  name: "LogIn",
  /**
   * 返回的数据用于软件的登录信息管理
   * remember:用于记录是否存储用户密码
   * checked：保持用户登录，而不需要每次都查询用户数据库，减少用户名密码被劫持的风险
   * @returns {{remember: string, password: string, checked: string, username: string}}
   */
  data(){
    return{
      username:"",
      password:"",
      remember:"",
      checked:""
    }
  }
}
</script>

<style scoped lang="less">
@import "src/less/main";

.loginPageBox{
  .WebFlex(@column,flex-start,center)
}
</style>
