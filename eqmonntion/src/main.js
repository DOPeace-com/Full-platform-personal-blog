import { createApp } from 'vue'
import App from './App.vue'
const app = createApp(App);
//导入路由
import router from "@/router";


app.use(router)

/*
* 配置动画的网页标题
* */
router.beforeEach((to)=>{
    document.title = to.meta.title + " - Do Of Peace"
})

app.mount('#app')
