(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/shangjiacanpin/add-or-update"],{"0435":function(n,a,e){"use strict";e.r(a);var i=e("65af"),t=e("6cd4");for(var r in t)"default"!==r&&function(n){e.d(a,n,(function(){return t[n]}))}(r);e("b012");var u,o=e("f0c5"),c=Object(o["a"])(t["default"],i["b"],i["c"],!1,null,"dc9ad184",null,!1,i["a"],u);a["default"]=c.exports},"65af":function(n,a,e){"use strict";e.d(a,"b",(function(){return t})),e.d(a,"c",(function(){return r})),e.d(a,"a",(function(){return i}));var i={wPicker:function(){return Promise.all([e.e("common/vendor"),e.e("components/w-picker/w-picker")]).then(e.bind(null,"647b"))}},t=function(){var n=this,a=n.$createElement;n._self._c},r=[]},"6cd4":function(n,a,e){"use strict";e.r(a);var i=e("eae4"),t=e.n(i);for(var r in i)"default"!==r&&function(n){e.d(a,n,(function(){return i[n]}))}(r);a["default"]=t.a},b012:function(n,a,e){"use strict";var i=e("eb32"),t=e.n(i);t.a},b459:function(n,a,e){"use strict";(function(n){e("4314");i(e("66fd"));var a=i(e("0435"));function i(n){return n&&n.__esModule?n:{default:n}}n(a.default)}).call(this,e("543d")["createPage"])},eae4:function(n,a,e){"use strict";(function(n){Object.defineProperty(a,"__esModule",{value:!0}),a.default=void 0;var i=t(e("a34a"));function t(n){return n&&n.__esModule?n:{default:n}}function r(n,a,e,i,t,r,u){try{var o=n[r](u),c=o.value}catch(s){return void e(s)}o.done?a(c):Promise.resolve(c).then(i,t)}function u(n){return function(){var a=this,e=arguments;return new Promise((function(i,t){var u=n.apply(a,e);function o(n){r(u,i,t,o,c,"next",n)}function c(n){r(u,i,t,o,c,"throw",n)}o(void 0)}))}}var o=function(){Promise.all([e.e("common/vendor"),e.e("components/w-picker/w-picker")]).then(function(){return resolve(e("647b"))}.bind(null,e)).catch(e.oe)},c={data:function(){return{ruleForm:{shangjiazhanghao:"",shangjiamingcheng:"",dangkouhao:"",lianxidianhua:"",canpinming:"",canpinzhonglei:"",danjia:"",canpintupian:"",canpinxiangqing:"",thumbsupnum:"",crazilynum:"",clicktime:"",clicknum:""},shangjiazhanghaoOptions:[],shangjiazhanghaoIndex:0,dangkouhaoOptions:[],dangkouhaoIndex:0,canpinzhongleiOptions:[],canpinzhongleiIndex:0,user:{},ro:{shangjiazhanghao:!1,shangjiamingcheng:!1,dangkouhao:!1,lianxidianhua:!1,canpinming:!1,canpinzhonglei:!1,danjia:!1,canpintupian:!1,canpinxiangqing:!1,thumbsupnum:!1,crazilynum:!1,clicktime:!1,clicknum:!1}}},components:{wPicker:o},computed:{},onLoad:function(a){var e=this;return u(i.default.mark((function t(){var r,u,o,c;return i.default.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return r=n.getStorageSync("nowTable"),t.next=3,e.$api.session(r);case 3:return u=t.sent,e.user=u.data,t.next=7,e.$api.option("shangjia","shangjiazhanghao",{});case 7:return u=t.sent,e.shangjiazhanghaoOptions=u.data,t.next=11,e.$api.option("dangkouhao","dangkouhao",{});case 11:return u=t.sent,e.dangkouhaoOptions=u.data,t.next=15,e.$api.option("canpinzhonglei","canpinzhonglei",{});case 15:if(u=t.sent,e.canpinzhongleiOptions=u.data,e.ruleForm.userid=n.getStorageSync("userid"),a.refid&&(e.ruleForm.refid=a.refid,e.ruleForm.nickname=n.getStorageSync("nickname")),!a.id){t.next=25;break}return e.ruleForm.id=a.id,t.next=23,e.$api.info("shangjiacanpin",e.ruleForm.id);case 23:u=t.sent,e.ruleForm=u.data;case 25:if(!a.cross){t.next=84;break}o=n.getStorageSync("crossObj"),t.t0=i.default.keys(o);case 28:if((t.t1=t.t0()).done){t.next=84;break}if(c=t.t1.value,"shangjiazhanghao"!=c){t.next=34;break}return e.ruleForm.shangjiazhanghao=o[c],e.ro.shangjiazhanghao=!0,t.abrupt("continue",28);case 34:if("shangjiamingcheng"!=c){t.next=38;break}return e.ruleForm.shangjiamingcheng=o[c],e.ro.shangjiamingcheng=!0,t.abrupt("continue",28);case 38:if("dangkouhao"!=c){t.next=42;break}return e.ruleForm.dangkouhao=o[c],e.ro.dangkouhao=!0,t.abrupt("continue",28);case 42:if("lianxidianhua"!=c){t.next=46;break}return e.ruleForm.lianxidianhua=o[c],e.ro.lianxidianhua=!0,t.abrupt("continue",28);case 46:if("canpinming"!=c){t.next=50;break}return e.ruleForm.canpinming=o[c],e.ro.canpinming=!0,t.abrupt("continue",28);case 50:if("canpinzhonglei"!=c){t.next=54;break}return e.ruleForm.canpinzhonglei=o[c],e.ro.canpinzhonglei=!0,t.abrupt("continue",28);case 54:if("danjia"!=c){t.next=58;break}return e.ruleForm.danjia=o[c],e.ro.danjia=!0,t.abrupt("continue",28);case 58:if("canpintupian"!=c){t.next=62;break}return e.ruleForm.canpintupian=o[c],e.ro.canpintupian=!0,t.abrupt("continue",28);case 62:if("canpinxiangqing"!=c){t.next=66;break}return e.ruleForm.canpinxiangqing=o[c],e.ro.canpinxiangqing=!0,t.abrupt("continue",28);case 66:if("thumbsupnum"!=c){t.next=70;break}return e.ruleForm.thumbsupnum=o[c],e.ro.thumbsupnum=!0,t.abrupt("continue",28);case 70:if("crazilynum"!=c){t.next=74;break}return e.ruleForm.crazilynum=o[c],e.ro.crazilynum=!0,t.abrupt("continue",28);case 74:if("clicktime"!=c){t.next=78;break}return e.ruleForm.clicktime=o[c],e.ro.clicktime=!0,t.abrupt("continue",28);case 78:if("clicknum"!=c){t.next=82;break}return e.ruleForm.clicknum=o[c],e.ro.clicknum=!0,t.abrupt("continue",28);case 82:t.next=28;break;case 84:e.styleChange();case 85:case"end":return t.stop()}}),t)})))()},methods:{styleChange:function(){this.$nextTick((function(){}))},shangjiazhanghaoChange:function(n){var a=this;return u(i.default.mark((function e(){var t;return i.default.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return a.shangjiazhanghaoIndex=n.target.value,a.ruleForm.shangjiazhanghao=a.shangjiazhanghaoOptions[a.shangjiazhanghaoIndex],e.next=4,a.$api.follow("shangjia","shangjiazhanghao",{columnValue:a.ruleForm.shangjiazhanghao});case 4:t=e.sent,t.data.shangjiamingcheng&&(a.ruleForm.shangjiamingcheng=t.data.shangjiamingcheng),t.data.lianxidianhua&&(a.ruleForm.lianxidianhua=t.data.lianxidianhua);case 7:case"end":return e.stop()}}),e)})))()},clicktimeConfirm:function(n){console.log(n),this.ruleForm.clicktime=n.result,this.$forceUpdate()},dangkouhaoChange:function(n){this.dangkouhaoIndex=n.target.value,this.ruleForm.dangkouhao=this.dangkouhaoOptions[this.dangkouhaoIndex]},canpinzhongleiChange:function(n){this.canpinzhongleiIndex=n.target.value,this.ruleForm.canpinzhonglei=this.canpinzhongleiOptions[this.canpinzhongleiIndex]},canpintupianTap:function(){var n=this;this.$api.upload((function(a){n.ruleForm.canpintupian=n.$base.url+"upload/"+a.file,n.$forceUpdate(),n.$nextTick((function(){n.styleChange()}))}))},getUUID:function(){return(new Date).getTime()},onSubmitTap:function(){var n=this;return u(i.default.mark((function a(){return i.default.wrap((function(a){while(1)switch(a.prev=a.next){case 0:if(n.ruleForm.shangjiazhanghao){a.next=3;break}return n.$utils.msg("商家账号不能为空"),a.abrupt("return");case 3:if(n.ruleForm.shangjiamingcheng){a.next=6;break}return n.$utils.msg("商家名称不能为空"),a.abrupt("return");case 6:if(n.ruleForm.lianxidianhua){a.next=9;break}return n.$utils.msg("联系电话不能为空"),a.abrupt("return");case 9:if(!n.ruleForm.lianxidianhua||n.$validate.isMobile(n.ruleForm.lianxidianhua)){a.next=12;break}return n.$utils.msg("联系电话应输入手机格式"),a.abrupt("return");case 12:if(!n.ruleForm.danjia||n.$validate.isNumber(n.ruleForm.danjia)){a.next=15;break}return n.$utils.msg("单价应输入数字"),a.abrupt("return");case 15:if(!n.ruleForm.thumbsupnum||n.$validate.isIntNumer(n.ruleForm.thumbsupnum)){a.next=18;break}return n.$utils.msg("赞应输入整数"),a.abrupt("return");case 18:if(!n.ruleForm.crazilynum||n.$validate.isIntNumer(n.ruleForm.crazilynum)){a.next=21;break}return n.$utils.msg("踩应输入整数"),a.abrupt("return");case 21:if(!n.ruleForm.clicknum||n.$validate.isIntNumer(n.ruleForm.clicknum)){a.next=24;break}return n.$utils.msg("点击次数应输入整数"),a.abrupt("return");case 24:if(!n.ruleForm.id){a.next=29;break}return a.next=27,n.$api.update("shangjiacanpin",n.ruleForm);case 27:a.next=31;break;case 29:return a.next=31,n.$api.add("shangjiacanpin",n.ruleForm);case 31:n.$utils.msgBack("提交成功");case 32:case"end":return a.stop()}}),a)})))()},optionsChange:function(n){this.index=n.target.value},bindDateChange:function(n){this.date=n.target.value},getDate:function(n){var a=new Date,e=a.getFullYear(),i=a.getMonth()+1,t=a.getDate();return"start"===n?e-=60:"end"===n&&(e+=2),i=i>9?i:"0"+i,t=t>9?t:"0"+t,"".concat(e,"-").concat(i,"-").concat(t)},toggleTab:function(n){this.$refs[n].show()}}};a.default=c}).call(this,e("543d")["default"])},eb32:function(n,a,e){}},[["b459","common/runtime","common/vendor"]]]);