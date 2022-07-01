import {createRouter,createWebHistory} from "vue-router";
import routers from "@/router/routers";

const index = createRouter({
    history:createWebHistory("/"),//指定使用Hash进行一个路由的切换
    routes:routers
})

export default index;
