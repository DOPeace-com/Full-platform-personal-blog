<template>
  <h1>This is MyHome</h1>
  <svg class="bi" width="32" height="32" fill="currentColor">
    <use :xlink:href="iconPath+'#heart-fill'"/>
  </svg>
  <svg class="bi" width="32" height="32" fill="currentColor">
    <use :xlink:href="iconPath+'#toggles'"/>
  </svg>
  <svg class="bi" width="32" height="32" fill="currentColor">
    <use :xlink:href="iconPath+'#shop'"/>
  </svg>
</template>

<script>
//导入Bootstrop-icon
import iconPath from 'bootstrap-icons/bootstrap-icons.svg'
import bus from "@/util/Bus"
export default {
  name: "MyHome",
  data(){
    return{
      iconPath
    }
  },
  created() {
    bus.emit("getTitle","myHome")
  }
}
</script>

<style scoped>

</style>
