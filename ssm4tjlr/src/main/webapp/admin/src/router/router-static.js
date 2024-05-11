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
    import gouwuche from '@/views/modules/gouwuche/list'
    import youhuihuodong from '@/views/modules/youhuihuodong/list'
    import shangjiacanpin from '@/views/modules/shangjiacanpin/list'
    import dingdanxinxi from '@/views/modules/dingdanxinxi/list'
    import storeup from '@/views/modules/storeup/list'
    import shangjia from '@/views/modules/shangjia/list'
    import canpinzhonglei from '@/views/modules/canpinzhonglei/list'
    import dangkouhao from '@/views/modules/dangkouhao/list'
    import yonghu from '@/views/modules/yonghu/list'
    import discussshangjiacanpin from '@/views/modules/discussshangjiacanpin/list'
    import qiandaoxinxi from '@/views/modules/qiandaoxinxi/list'
    import config from '@/views/modules/config/list'
    import wodehuodong from '@/views/modules/wodehuodong/list'


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
	path: '/gouwuche',
        name: '购物车',
        component: gouwuche
      }
      ,{
	path: '/youhuihuodong',
        name: '优惠活动',
        component: youhuihuodong
      }
      ,{
	path: '/shangjiacanpin',
        name: '商家餐品',
        component: shangjiacanpin
      }
      ,{
	path: '/dingdanxinxi',
        name: '订单信息',
        component: dingdanxinxi
      }
      ,{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
      ,{
	path: '/shangjia',
        name: '商家',
        component: shangjia
      }
      ,{
	path: '/canpinzhonglei',
        name: '餐品种类',
        component: canpinzhonglei
      }
      ,{
	path: '/dangkouhao',
        name: '档口号',
        component: dangkouhao
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/discussshangjiacanpin',
        name: '商家餐品评论',
        component: discussshangjiacanpin
      }
      ,{
	path: '/qiandaoxinxi',
        name: '签到信息',
        component: qiandaoxinxi
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/wodehuodong',
        name: '我的活动',
        component: wodehuodong
      }
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
