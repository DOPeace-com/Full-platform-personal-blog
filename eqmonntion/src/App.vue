<template>
  <MyHeader/>
  <br>
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
@media (min-width: 768px) {
  button:hover{
    background-color: @hover-color;
  }
}
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
#app:extend(.type-area){
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
button{
  width: 100%;
  border: 0px;
  padding: 10px 0px;
  margin: 5px 0px;
  border-radius: 5px;
  letter-spacing: 20px;
  text-indent: 1em;
}
@media (max-width: 768px) {
  button:active{
    background-color: @active-color;
  }
}
</style>
