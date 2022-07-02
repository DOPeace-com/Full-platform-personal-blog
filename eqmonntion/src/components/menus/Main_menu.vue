<template>
  <transition name="slide-fade">
    <div class="Main_manu" v-show="smallView || windowsWidth>768">
      <div class="SmailMenuTop" v-if="windowsWidth<768">
        <div class="but" @click="toLogIN">
          <img src="../../assets/logo.png" class="UserHeader"/>
          <span>{{userName==""?fontFile.login:userName}}</span>
        </div>
        <svg class="bi-x but" fill="currentColor" v-if="windowsWidth<768" @click="smallView = false">
          <use :xlink:href="iconPath+'#x'" />
        </svg>
      </div>
      <ul>
        <li class="but" v-for="(item,key) in fontFile.MainMenu" :key="key" @click="toPage(item.url)">
          <svg class="bi-icon-menu" fill="currentColor" v-if="windowsWidth<768" >
            <use :xlink:href="iconPath+ item.icoUse" />
          </svg>
          <div class="Menu_item">
            <span>{{ item.name }}</span>
            <svg class="bi-chevron-right" fill="currentColor" v-if="windowsWidth<768" >
              <use :xlink:href="iconPath+ '#chevron-right'" />
            </svg>
          </div>
        </li>
      </ul>
      <div class="SmailMenuDown">
        <div class="cahngeLanguage">
          <span @click="setLanguage('zh-CN')" class="but">中文</span>
          <svg class="toggle" fill="currentColor">
            <use :xlink:href="iconPath+'#toggle-'+'off'" v-if="fontFile.MainMenu[0].name=='首页'"/>
            <use :xlink:href="iconPath+'#toggle-'+'on'" v-if="fontFile.MainMenu[0].name=='Home'"/>
          </svg>
          <span @click="setLanguage('en-US')" class="but">English</span>
        </div>
      </div>
    </div>
  </transition>
</template>

<script>
import bus from '@/util/Bus'
//导入Bootstrop-icon
import iconPath from 'bootstrap-icons/bootstrap-icons.svg'
export default {
  name: "Main_menu",
  data(){
    return{
      smallView:false,
      windowsWidth:document.body.clientWidth,
      iconPath,
      fontFile:require('@/json/zh-CN_font.json'),
      userName:""
    }
  },
  created() {
  },
  mounted() {
    window.onresize = () =>{
      console.log(document.body.clientWidth)
    }
    this.acceptFontFile()
    this.accrptWindowWidth()
    this.accrptSetSmallView()
  },
  methods: {
    /*
    * 获取页面FontFild
    * */
    acceptFontFile() {
      bus.on("getFontFile", (val) => {
        this.fontFile = val
      })
    },
    /*
    * 发送网站显示的语言
    * */
    setLanguage(val) {
      bus.emit('setLanguage', val)
    },
    /*
    * 获取页面大小
    * */
    accrptWindowWidth() {
      bus.on("getWindwoWidth", (val) => {
        this.windowsWidth = val
      })
    },
    /*
    * 监听控制小屏幕窗口的显示控制方法
    * */
    accrptSetSmallView(){
      bus.on("setSmallVirw",(val)=>{
        this.smallView = val
      })
    },
    /*
    * 跳转到登录页
    * */
    toLogIN(){
      this.$router.push("/login")
      this.smallView = false
    },
    /*
    * 菜单跳转
    * */
    toPage(url){
      this.$router.push(url)
      this.smallView = false
    }
  }
}
</script>

<style lang="less" scoped>
@import "../../less/main";
@media (min-width: 768px) {
  .Main_manu{
    li:hover{
      font-weight: bold;
      text-shadow: 0px 0px 5px @shadow-blue;
    }
  }

}
.Main_manu{
  .WebFlex(@row,flex-start,center);
  padding-left: 20px;
  ul{
    .WebFlex(@row,flex-start,center)
  }
  li{
    font-size: 1.5em;
    font-weight: 400;
    color: @white;
    padding: 0px 10px;
    letter-spacing: 1px;
  }
}
.cahngeLanguage{
  .WebFlex(@row,flex-start,center);
  font-size: 1.2em;
  color: @white;
  .toggle{
    width: @toggle-size;
    height: @toggle-size;
    padding: 0px 5px;
  }
}
@media (max-width: 768px) {
  .SmailMenuTop{
    margin-top: 50px;
    .bi-x{
      color: @white;
      width: @ico-size;
      height: @ico-size;
    }
    div{
      .WebFlex(@row,center,center);
      font-size: 2em;
      font-weight: 800;
      color: @white;
    }
    width: 90%;
    .WebFlex(@row,space-between,center);
    .UserHeader{
      width: @logoSize;
      height: @logoSize;
    }
    .UserHeader:active{
      color: @active-color;
    }
  }
  .SmailMenuDown{
    position: absolute;
    bottom: 50px;
  }

  .Main_manu{
    .WebFlex(@column,flex-start,center);
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    z-index: 99;
    padding: 0;
    background-color: @bgColor_main;
    ul{
      .WebFlex(@column,flex-start,flex-start);
      width: 90%;
      .Menu_item{
        width: 81%;
        .WebFlex(@row,space-between,center);
        .bi-chevron-right{
          width: @ico-size*0.5;
          height: @ico-size*0.5;
        }
      }
    }
    li{
      .WebFlex(@row,flex-start,center);
      width: 100%;
    }
  }

}
</style>
