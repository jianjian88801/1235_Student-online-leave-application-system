const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot0e3m2/",
            name: "springboot0e3m2",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot0e3m2/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "学生网上请假系统"
        } 
    }
}
export default base
