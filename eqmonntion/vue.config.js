const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})
module.exports = {
  // 选项...
  // publicPath: "/",
  publicPath:'./',
  devServer:{
    port:80,
    proxy: { //配置跨域
      '/api': {
        target: 'http://i.bajiao.ltd', //这里后台的地址模拟的;应该填写你们真实的后台接口
        ws: true,
        changOrigin: true, //允许跨域
        pathRewrite: {
          '/api': '' //请求的时候使用这个api就可以
        }
      }
    }
  }
}
