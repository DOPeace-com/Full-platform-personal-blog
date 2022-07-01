<template >
  <div id="MyHeader">
    <div class="type-area">
      <div id="login">
        <img class="logoImg" src="../assets/logo.png" ondragstart @click="sendSmallView(true)">
      </div>
      <div class="MaxMenu">
        <Main_menu/>
      </div>
      <h1 style="display:inline-block;">{{fontFile.WebName}}</h1>
      <!--This is the burger menu on a small screen-->
      <svg class="bi-three-dots-vertical" fill="currentColor" >
        <use :xlink:href="iconPath+'#three-dots-vertical'" />
      </svg>
    </div>
  </div>
</template>

<script>
import Main_menu from '@/components/menus/Main_menu'
import iconPath from 'bootstrap-icons/bootstrap-icons.svg'
import bus from "@/util/Bus";

export default {
  name: 'MyHeader',
  components:{
    Main_menu
  },
  data(){
    return {
      smallView:false,
      fontFile:require('@/json/zh-CN_font.json'),
      iconPath,
      windowsWidth:document.body.clientWidth
    }
  },
  computed:{
    fontlanguage:{
      get(val){
        return val
      },
      set(val){
        this.fontFile = require('@/json/'+val+'_font.json')
        this.sendFontFile()
      }
    }
  },
  created() {
    /*监听语言切换*/
    this.setLanguage()
    /*判断用户历史切换*/
    var userLanguage = localStorage.getItem("UserLanguage")?true:false
    if (userLanguage){
      this.fontlanguage = localStorage.getItem("UserLanguage")
    }
  },
  mounted(){
    const _this = this
    //监听window.body
    window.onresize = () => {
      _this.windowsWidth = document.body.clientWidth
      this.sendWidnowWidth()
    }
    /*广播默认的语言*/
    this.sendFontFile()
  },
  methods:{
    /*
    * 将使用的文字语言发送到Bus总线上
    * */
    sendFontFile(){
      bus.emit('getFontFile',this.fontFile)
    },
    /*
    * 接收语言切换方法
    * */
    setLanguage(){
      const _this = this
      bus.on('setLanguage',(val)=>{
        _this.fontlanguage = val
        localStorage.setItem("UserLanguage",val)
      })
    },
    /*
    * 发送屏幕大小
    * */
    sendWidnowWidth(){
      bus.emit('getWindwoWidth',this.windowsWidth)
    },
    /*
    * 发送SmallView的显示与控制
    * */
    sendSmallView(val){
      bus.emit('setSmallVirw',val)
      this.smallView = !this.smallView
    }
  }
}
</script>

<style lang="less" scoped>
@import "../less/main";
@media (min-width: 768px) {
  .bi-three-dots-vertical:hover{
    color: @hover-color;
  }
  .logoImg:hover{
    transform: rotate(15deg);
    filter: drop-shadow(0px 0px 5px @white);
  }
}
#MyHeader{
  .WebConfig(@row);
  background-color:@bgColor_main;
  padding: 0% 3%;
  width: 94%;
}
.type-area{
  .WebConfig(@row);
  justify-content: space-between;
  width: 100%;
  max-width: @Max-type-with;
}
h1{
  color:@white ;
}
.logoImg{
  width: @logoSize;
  height: @logoSize;
}
.logoImg:active{
  transform: rotate(-15deg);
  filter: drop-shadow(0px 0px 5px @shadow-blue);
}
.bi-three-dots-vertical{
  width: @three-dots-vertical-size;
  height: @three-dots-vertical-size;
  color: @white;
}
.bi-three-dots-vertical:active{
  color: @active-color;
  transition: all .1s ease-out;
}
.MaxMenu{
  flex-grow: 2;
}
@media (max-width: 768px) {
  .logoImg{
    width: @logoSize-small;
    height: @logoSize-small;
  }
}
</style>
