import { createApp } from 'vue'
import App from './App.vue'
const app = createApp(App);

/*
* 导入路由组件
* */
import router from "@/router";
app.use(router)
/*
* 导入axios组件
* */
import axios from "axios";
axios.defaults.baseURL = "http://localhost:8080"
app.config.globalProperties.$axios = axios


/*
* 配置动画的网页标题
* */
router.beforeEach((to)=>{
    document.title = to.meta.title + " - Do Of Peace"
})

app.mount('#app')
