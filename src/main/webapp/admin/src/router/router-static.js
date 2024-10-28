import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

    import yonghu from '@/views/modules/yonghu/list'
    import laoren from '@/views/modules/laoren/list'
    import liuyanxinxi from '@/views/modules/liuyanxinxi/list'
	import shentizhibiao from '@/views/modules/shentizhibiao/list'
    import shiyaojilu from '@/views/modules/shiyaojilu/list'
	import tijianbingli from '@/views/modules/tijianbingli/list'
	import tufaqingkuang from '@/views/modules/tufaqingkuang/list'

//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
	  ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      },
	  {
	  path: '/laoren',
	      name: '老人信息',
	      component: laoren
	  },
	  {
	  path: '/liuyanxinxi',
	      name: '留言信息',
	      component: liuyanxinxi
	  },
	  {
	  path: '/shentizhibiao',
	      name: '身体指标',
	      component: shentizhibiao
	  },
	  
	  {
	  path: '/shiyaojilu',
	      name: '食药记录',
	      component: shiyaojilu
	  },
	  {
	  path: '/tijianbingli',
	      name: '体检报告',
	      component: tijianbingli
	  },
	  {
	  path: '/tufaqingkuang',
	      name: '突发情况',
	      component: tufaqingkuang
	  },
	 
        ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
