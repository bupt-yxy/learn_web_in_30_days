#Vue & Vite 学习笔记

##vue-cli脚手架创建vue
###新建工程
1. npm install -g @vue/cli  
2. vue create 项目名称  
3. cd 项目名称//进入项目  
4. npm run serve启动vue项目  
5. 进入localhost可以看到目前的工程界面  
6. ctrl+c关闭  
7. 进入idea打开（方便后续写后端）  
8. add config->new->npm->script写serve  
9. package.json->vue-cli-service serve --open 实现自动打开  
10. assets-》存放静态资源  
11. components-》组件存放，打包代码，从其他地方引入，组件式的开发，如HelloWorld.vue，从视图传递变量到组件  
12. store存放页面的变量  
13. views-》视图  
14. package.json引入定义依赖  

使用npm安装vue脚手架、vite脚手架，vue@cli，element-plus和图标，axios等工具和依赖。
```
安装图标 npm install @element-plus/icons-vue
安装淘宝镜像 npm config set registry https://registry.npm.taobao.org
```
```
npm init vite@latest
```
然后根据指示操作。
直接在文件夹的地址处输入cmd，可以直接转到cd的power shell窗口。

##工具和依赖
MybatisPlus [插件主体](https://baomidou.com/pages/2976a3/#spring-boot)  
ElementPlus [组件](https://element.eleme.cn/#/zh-CN/component/input)  
HuTool [参考文档](https://hutool.cn/docs/#/)  
ElementPlus [图标](https://element-plus.gitee.io/zh-CN/component/button.html#图标按钮)
Vite [Vite中文网](https://vitejs.cn/)

##vue脚手架的框架结构解析
###结构和文件
*.vue文件，vue components组件文件
- main.js 入口，使用以下代码：
```javascript
const app = createApp(App)
app.use(router).use(ElementPlus).mount('#app)
```
其中router是router/index.js暴露的端口
- App.vue 根组件
- router/index.js 定义页面路由，一级路由和二级路由，并暴露端口router。

<router-view/> 你访问的地址匹配到在router/index.js中定义的path时，会将你在index.js中的path对应的定义的component替换该<router-view/>并渲染。

在真实项目中，router-view不仅仅只用于App.vue文件中，还会用于整体布局文件。如Layout.vue文件中写header和导航栏，然后使用<router-view/>插槽，只使用二级路由切换和渲染主题内容的页面，就是为了实现网站头、尾、导航栏、内容区分隔，使切换路由时只变换内容区，头、尾、导航栏等公共部分不做切换。这时候，我们可以在index.js中添加二级路由children，代码示例如下：
```js
const routes = [
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect: "/home",
    children: [
      {
        path: '/home',
        name: 'Home',
        component: () => import("@/views/Home.vue")
      }
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/Login.vue')
  }]
```
也可以不使用children，如下
```js
const routes = [
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect: "/home",

  },
  {
  path: '/home',
  name: 'Home',
  component: () => import("@/views/Home.vue")
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/Login.vue')
  }
]
```
此外，在路由A使用redirect重定向到另一个路由B时，路由A本身也需要component对应一个页面，而且这个页面里还要有<router-view></router-view>或者<router-view/>最终才能成功的跳转。
