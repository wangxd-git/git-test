let myQuestionsApp = new Vue({
    el: '#myQuestionsApp',
    data: {
        questions: [
            {
                id: 2,
                title: '模拟问题的标题--2',
                content: '模拟问题的<b style="color:red">正文</b>--2',
                status: 1,
                statusText: '未解决',
                statusClass: 'badge-info',
                userNickName: '大鲁班',
                hits: 572,
                gmtCreate: '2020-11-20T10:34:09',
                gmtCreateText: '11分钟前'
            },
            {
                id: 1,
                title: '模拟问题的标题--1',
                content: '模拟问题的正文--1',
                status: 0,
                statusText: '未回复',
                statusClass: 'badge-warning',
                userNickName: '奥特曼',
                hits: 395,
                gmtCreate: '2020-11-20T10:34:09',
                gmtCreateText: '15分钟前'
            },
        ],
        navigatepageNums: [1,2,3,4,5,6,7,8],
        currentPageNum: 1,
        prePageNum: 1,
        nextPageNum: 1
    },
    methods: {
        loadMyQuestions: function (page) {
            // alert('准备加载我的问答列表……');
            if (page == 0) {
                return;
            }
            $.ajax({
                url: '/portal/question/my',
                data: 'page=' + page,
                success: function (r) {
                    let list = r.data.list;
                    let questions = [];
                    let statusTexts = ['未回复', '未解决', '已解决'];
                    let statusClasses = ['badge-warning', 'badge-info', 'badge-success'];
                    for (let i = 0; i < list.length; i++) {
                        let question = list[i];
                        question.statusText = statusTexts[question.status];
                        question.statusClass = statusClasses[question.status];
                        question.gmtCreateText = getTimeText(question.gmtCreate);
                        questions[i] = question;
                    }
                    myQuestionsApp.questions = questions;
                    myQuestionsApp.navigatepageNums = r.data.navigatepageNums;
                    myQuestionsApp.currentPageNum = r.data.pageNum;
                    myQuestionsApp.prePageNum = r.data.prePage;
                    myQuestionsApp.nextPageNum = r.data.nextPage;
                }
            });
        }
    },
    created: function () {
        this.loadMyQuestions(1);
    }
});




