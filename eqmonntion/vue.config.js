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
  }
}
