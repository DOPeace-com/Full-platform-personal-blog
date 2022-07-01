<template>
  <MyHeader/>
  <br>
  <img width="120" alt="MaxLogo" src="./assets/logo.png"/>


  <router-view/>
</template>

<script>
//引入组件
import MyHeader from "@/components/MyHeader"
export default {
  name: 'App',
  components:{MyHeader},
  data(){
    return{

    }
  },
  created() {

  },
  methods:{

  },
  beforeMount() {

  },
  mounted() {

  }
}
</script>

<style lang="less">
@import "less/main";
*{
  user-drag: none;
  -webkit-user-drag:none;
  font-family: MiSans;
  user-select: none;
  padding: 0px;
  margin: 0px;
  transition: all .2s ease-out;
}
body{
  font-size: @OneEm-fontSize;
}
.type-area{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  align-content: center;

}
#app:extend(.type-area){

}
</style>
