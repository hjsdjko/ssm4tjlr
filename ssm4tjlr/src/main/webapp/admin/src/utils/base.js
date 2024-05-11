const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm4tjlr/",
            name: "ssm4tjlr",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm4tjlr/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "民大食堂用餐综合服务小程序"
        } 
    }
}
export default base
