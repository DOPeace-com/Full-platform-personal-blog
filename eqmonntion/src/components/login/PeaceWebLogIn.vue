<template>
  <div class="loginPageBox">
    <div class="Box">
      <div class="BoxLeft" v-if="windowsWidth>768">
        <img src="../../assets/logo.png">
        <h1>{{fontFile.WebName}}</h1>
      </div>
      <div class="smallBox">
        <h1>{{fontFile.Hello}}</h1>
      </div>
      <div class="BoxRight">
        <form>
          <ul>
            <li>
              <span>{{fontFile.loginPage.userid}}:</span>
              <input type="text" :placeholder="fontFile.loginPage.userid" v-model="username">
            </li>
            <li>
              <span>{{fontFile.loginPage.password}}:</span>
              <input type="password" :placeholder="fontFile.loginPage.password" v-model="password">
            </li>
            <li>
            <!--滑块验证-->
            <MySlid/>
            </li>
          </ul>
          <button type="button" @click="loginmethods">{{fontFile.loginPage.submit}}</button>
          <br/>
          <button type="reset" @click="clearData">{{fontFile.loginPage.reset}}</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import bus from '@/util/Bus'
import axios from 'axios'
//引入自己制作的滑块
import MySlid from "@/components/mysliding/MySlid";
export default {
  name: "LogIn",
  components:{MySlid},
  /**
   * 返回的数据用于软件的登录信息管理
   * remember:用于记录是否存储用户密码
   * checked：保持用户登录，而不需要每次都查询用户数据库，减少用户名密码被劫持的风险
   * @returns {{remember: string, password: string, checked: string, username: string}}
   */
  data(){
    return{
      fontFile:require('@/json/zh-CN_font.json'),
      windowsWidth:document.body.clientWidth,
      username:"",
      password:"",
      securitycode:"",
      remember:"",
      checked:""
    }
  },
  mounted() {
    window.onresize = () =>{
      console.log(document.body.clientWidth)
    }
    this.acceptFontFile()
    this.setsecuritycode()
  },
  methods:{
    /*
    * 获取页面FontFild
    * */
    acceptFontFile() {
      bus.on("getFontFile", (val) => {
        this.fontFile = val
      })
    },
    /*
    * 清除输入内容
    * */
    clearData(){
      this.username=""
      this.password=""
      this.securitycode=""
    },
    /*
    * 验证成功
    * */
    setsecuritycode(){
      bus.on("security",(val)=>{
        this.securitycode = val
      })
    },
    /*
    * 登录请求axios
    * */
    loginmethods(){
      if (this.securitycode){
        axios.get("/api/login?userid="+this.username+"&userpassword="+this.password).then((resp)=>{
          if (resp.data=="success"){
            alert("登录成功")
          }else{
            alert("用户名密码输入不正确")
          }
        })
      }else{
        alert("请完成验证")
      }

    }
  }
}
</script>

<style scoped lang="less">
@import "src/less/main";
body{
  background-color: @bgColor_main;
}
.loginPageBox{
  position: absolute;
  .WebFlex(@column,center,center);
  width: 100%;
  height: calc(100vh - @logoSize);
  top: @logoSize;
  background-image: linear-gradient( @bgColor_main, @shadow-blue);
}
.Box{
  .WebFlex(@row,flex-start,center);
  background-color: @white;
  border-radius: 8px;
  box-shadow: 0px 0px 30px @shadow-blue;
  overflow: hidden;
}
.BoxLeft{
  .WebFlex(@column,center,center);
  img{
    width: @logoSize*3;
    margin: 5px;
  }
  color: @white;
  padding: 50px 10px;
  background-color: @bgColor_main;
}
.BoxRight{
  .WebFlex(@column,center,center);
  margin: 50px;
  li{
    line-height: 30px;
    span{
      padding-right: 10px;
    }
  }
  ul{
    margin-bottom: 30px;
  }
  input{
    outline:none;
    border: 0px;
    border-bottom: 1px solid @shadow;
  }
}
.smallBox{
  display: none;
}
@media (max-width: 768px) {
  .loginPageBox{
    height: calc(100vh - @logoSize-small);
    top: @logoSize-small;
  }
  .Box{
    .WebFlex(@column,center,center);
    background-color: #00000000;
    box-shadow: none;
    position: relative;
    top: -50px;
    width: 80%;
  }
  .BoxRight{
    .WebFlex(@column,center,center);
    font-size: 1.5em;
    form{
      width: 100%;
      span{
        display: none;
      }
      input{
        font-size: 1em;
        border-radius: 10px;
        padding: 2%;
        width: 96%;
        background-color: #ffffff77;
        margin-bottom: 20px;
      }
      button{
        background-color: @white;
      }
      button:active{
        background-color: @active-color;
        color: @white;
      }
    }
    width: 100%;
    margin: 50px 10px;
  }
  .smallBox{
    display: inline-block;
    color: @white;
    font-size: 2em;
    text-shadow: 0px 2px 2px @shadow;
  }
}
</style>
