(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/wodehuodong/add-or-update"],{"0c54":function(n,e,r){"use strict";(function(n){Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var t=a(r("a34a"));function a(n){return n&&n.__esModule?n:{default:n}}function u(n,e,r,t,a,u,i){try{var o=n[u](i),c=o.value}catch(s){return void r(s)}o.done?e(c):Promise.resolve(c).then(t,a)}function i(n){return function(){var e=this,r=arguments;return new Promise((function(t,a){var i=n.apply(e,r);function o(n){u(i,t,a,o,c,"next",n)}function c(n){u(i,t,a,o,c,"throw",n)}o(void 0)}))}}var o=function(){Promise.all([r.e("common/vendor"),r.e("components/w-picker/w-picker")]).then(function(){return resolve(r("647b"))}.bind(null,r)).catch(r.oe)},c={data:function(){return{ruleForm:{huodongmingcheng:"",huodongtupian:"",lianxidianhua:"",youhuineirong:"",shangjiazhanghao:"",shangjiamingcheng:"",dangkouhao:"",canyushijian:"",yonghuming:"",xingming:"",userid:""},user:{},ro:{huodongmingcheng:!1,huodongtupian:!1,lianxidianhua:!1,youhuineirong:!1,shangjiazhanghao:!1,shangjiamingcheng:!1,dangkouhao:!1,canyushijian:!1,yonghuming:!1,xingming:!1,userid:!1}}},components:{wPicker:o},computed:{},onLoad:function(e){var r=this;return i(t.default.mark((function a(){var u,i,o,c;return t.default.wrap((function(a){while(1)switch(a.prev=a.next){case 0:return r.ruleForm.canyushijian=r.$utils.getCurDateTime(),u=n.getStorageSync("nowTable"),a.next=4,r.$api.session(u);case 4:if(i=a.sent,r.user=i.data,r.ruleForm.yonghuming=r.user.yonghuming,r.ruleForm.xingming=r.user.xingming,r.ruleForm.userid=n.getStorageSync("userid"),e.refid&&(r.ruleForm.refid=e.refid,r.ruleForm.nickname=n.getStorageSync("nickname")),!e.id){a.next=16;break}return r.ruleForm.id=e.id,a.next=14,r.$api.info("wodehuodong",r.ruleForm.id);case 14:i=a.sent,r.ruleForm=i.data;case 16:if(!e.cross){a.next=67;break}o=n.getStorageSync("crossObj"),a.t0=t.default.keys(o);case 19:if((a.t1=a.t0()).done){a.next=67;break}if(c=a.t1.value,"huodongmingcheng"!=c){a.next=25;break}return r.ruleForm.huodongmingcheng=o[c],r.ro.huodongmingcheng=!0,a.abrupt("continue",19);case 25:if("huodongtupian"!=c){a.next=29;break}return r.ruleForm.huodongtupian=o[c],r.ro.huodongtupian=!0,a.abrupt("continue",19);case 29:if("lianxidianhua"!=c){a.next=33;break}return r.ruleForm.lianxidianhua=o[c],r.ro.lianxidianhua=!0,a.abrupt("continue",19);case 33:if("youhuineirong"!=c){a.next=37;break}return r.ruleForm.youhuineirong=o[c],r.ro.youhuineirong=!0,a.abrupt("continue",19);case 37:if("shangjiazhanghao"!=c){a.next=41;break}return r.ruleForm.shangjiazhanghao=o[c],r.ro.shangjiazhanghao=!0,a.abrupt("continue",19);case 41:if("shangjiamingcheng"!=c){a.next=45;break}return r.ruleForm.shangjiamingcheng=o[c],r.ro.shangjiamingcheng=!0,a.abrupt("continue",19);case 45:if("dangkouhao"!=c){a.next=49;break}return r.ruleForm.dangkouhao=o[c],r.ro.dangkouhao=!0,a.abrupt("continue",19);case 49:if("canyushijian"!=c){a.next=53;break}return r.ruleForm.canyushijian=o[c],r.ro.canyushijian=!0,a.abrupt("continue",19);case 53:if("yonghuming"!=c){a.next=57;break}return r.ruleForm.yonghuming=o[c],r.ro.yonghuming=!0,a.abrupt("continue",19);case 57:if("xingming"!=c){a.next=61;break}return r.ruleForm.xingming=o[c],r.ro.xingming=!0,a.abrupt("continue",19);case 61:if("userid"!=c){a.next=65;break}return r.ruleForm.userid=o[c],r.ro.userid=!0,a.abrupt("continue",19);case 65:a.next=19;break;case 67:r.styleChange();case 68:case"end":return a.stop()}}),a)})))()},methods:{styleChange:function(){this.$nextTick((function(){}))},canyushijianConfirm:function(n){console.log(n),this.ruleForm.canyushijian=n.result,this.$forceUpdate()},huodongtupianTap:function(){var n=this;this.$api.upload((function(e){n.ruleForm.huodongtupian=n.$base.url+"upload/"+e.file,n.$forceUpdate(),n.$nextTick((function(){n.styleChange()}))}))},getUUID:function(){return(new Date).getTime()},onSubmitTap:function(){var n=this;return i(t.default.mark((function e(){return t.default.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(!n.ruleForm.id){e.next=5;break}return e.next=3,n.$api.update("wodehuodong",n.ruleForm);case 3:e.next=7;break;case 5:return e.next=7,n.$api.add("wodehuodong",n.ruleForm);case 7:n.$utils.msgBack("提交成功");case 8:case"end":return e.stop()}}),e)})))()},optionsChange:function(n){this.index=n.target.value},bindDateChange:function(n){this.date=n.target.value},getDate:function(n){var e=new Date,r=e.getFullYear(),t=e.getMonth()+1,a=e.getDate();return"start"===n?r-=60:"end"===n&&(r+=2),t=t>9?t:"0"+t,a=a>9?a:"0"+a,"".concat(r,"-").concat(t,"-").concat(a)},toggleTab:function(n){this.$refs[n].show()}}};e.default=c}).call(this,r("543d")["default"])},2057:function(n,e,r){"use strict";(function(n){r("4314");t(r("66fd"));var e=t(r("bb96"));function t(n){return n&&n.__esModule?n:{default:n}}n(e.default)}).call(this,r("543d")["createPage"])},2386:function(n,e,r){"use strict";var t=r("bcb3"),a=r.n(t);a.a},"337b":function(n,e,r){"use strict";r.r(e);var t=r("0c54"),a=r.n(t);for(var u in t)"default"!==u&&function(n){r.d(e,n,(function(){return t[n]}))}(u);e["default"]=a.a},"5cc4":function(n,e,r){"use strict";r.d(e,"b",(function(){return a})),r.d(e,"c",(function(){return u})),r.d(e,"a",(function(){return t}));var t={wPicker:function(){return Promise.all([r.e("common/vendor"),r.e("components/w-picker/w-picker")]).then(r.bind(null,"647b"))}},a=function(){var n=this,e=n.$createElement;n._self._c},u=[]},bb96:function(n,e,r){"use strict";r.r(e);var t=r("5cc4"),a=r("337b");for(var u in a)"default"!==u&&function(n){r.d(e,n,(function(){return a[n]}))}(u);r("2386");var i,o=r("f0c5"),c=Object(o["a"])(a["default"],t["b"],t["c"],!1,null,"4db8925e",null,!1,t["a"],i);e["default"]=c.exports},bcb3:function(n,e,r){}},[["2057","common/runtime","common/vendor"]]]);