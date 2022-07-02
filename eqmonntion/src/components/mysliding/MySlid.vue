<template>
  <div ref="box" class="box">
    <!--滑块-->
    <div ref="btn" :class="ok?'btn2':'btn'" :style="'left:'+moveX+'px'">&gt;&gt;</div>
    <!--文字-->
    <span class="text">请向右滑动滑块</span>
    <!--背景-->
    <div ref="bg" class="bg" :style="'width:' +(moveX+10)+'px'"></div>
  </div>
</template>

<script>
import bus from "@/util/Bus";
export default {
  name: "MySlid",
  data(){
    return{
      ok:false,
      flag:false,
      oldX:0,
      moveX:0,
    }
  },
  mounted() {
    this.binding()
  },
  methods:{
    down(event){
      this.ok=false
      bus.emit("security",this.ok)
      this.flag = true
      var touch = event
      if (event.touches){
        touch = event.touches[0]
      }
      this.oldX = touch.clientX
    },
    up(){
      this.flag = false
    },
    movement(event){
      /**
       * 如果鼠标没有按下直接停止
       */
      if(!this.flag){
        return
      }
      var touch = event
      if (event.touches){
        touch = event.touches[0]
      }
      var checkmove = touch.clientX-this.oldX
      if (checkmove<=0){
        this.moveX =40
        this.up()
      }
      if (this.moveX>this.$refs.box.clientWidth-40){
        this.ok=true
        bus.emit("security",this.ok)
        this.up()
      }
      this.moveX = checkmove
    },
    /*
    * 绑定事件
    * */
    binding(){
        /*
        * 触摸事件
        * */
        this.$refs.btn.addEventListener('touchstart',this.down,false)
        this.$refs.btn.addEventListener('touchend',this.up,false)
        this.$refs.btn.addEventListener('touchmove',this.movement,false)
        /*
        * 鼠标事件
        * */
        this.$refs.btn.addEventListener('mousedown',this.down,false)
        document.body.addEventListener('mouseup',this.up,false)
        this.$refs.box.addEventListener('mousemove',this.movement,false)
    }
  }
}

</script>

<style scoped lang="less">
@import "src/less/main";
.okcl{
  position: absolute;
  width: 40px;
  height: 32px;
  z-index: 3;
  color: @white;
  border: 1px #2ac845 solid;
  background-color: #2ac845;
}
.box{
  position: relative;
  height: 34px;
  text-align: center;
  background-color: #eeeeee;
}
.btn{
  position: absolute;
  width: 40px;
  height: 32px;
  z-index: 3;
  background-color:@white;
  border: 1px @shadow solid;
}
.btn2{
  position: absolute;
  width: 40px;
  height: 32px;
  z-index: 3;
  background-color:#2ac845;
  border: 1px #2ac845 solid;
}
.text{
  position: relative;
  z-index: 2;
}
.bg{
  position: absolute;
  top: 0;
  z-index: 1;
  width: 0px;
  height: 34px;
  background-color: @bgColor_main;
}
@media (max-width: 768px) {
  .box{
    .WebFlex(@column,center,center);
    overflow: hidden;
    border-radius: 8px;
    height: 50px;
    background-color: #eeeeee77;
  }
  .btn{
    .WebFlex(@column,center,center);
    border-radius: 8px;
    height: 50px;
  }
  .btn2{
    .WebFlex(@column,center,center);
    border-radius: 8px;
    height: 50px;
  }
  .bg{
    top: 0;
    left: 0;
    height: 50px;

  }
}
</style>
