const routers = [
    {
        path: "/",
        name: "/",
        component: () => import("@/components/MyHome"),
        meta:{
            title: "Home"
        }

    },
    {
        path: "/login",
        name: "/login",
        component:() => import("@/components/login/PeaceWebLogIn"),
        meta:{
            title:"Login"
        }
    }
]

export default routers
