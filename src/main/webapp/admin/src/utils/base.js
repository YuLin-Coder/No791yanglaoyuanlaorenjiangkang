const base = {
    get() {
                return {
            url : "http://localhost:8080/yanglaoyuanlaorenjiangkang/",
            name: "yanglaoyuanlaorenjiangkang",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/yanglaoyuanlaorenjiangkang/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "养老院老人健康监护平台"
        } 
    }
}
export default base
