let detailApp = new Vue({
    el: '#detailApp',
    data: {
        id: 0,
        question: {
            title: '测试标题',
            content: '<b style="color: red">测试</b>正文',
            hits: 988,
            userNickName: '飞毛腿',
            gmtCreateText: '52分钟前'
        },
        answers: [
            {
                id: 5,
                userNickName: '张三',
                content: '测试答案5',
                gmtCreateText: '51分钟前'
            },
            {
                id: 3,
                userNickName: '李四',
                content: '测试答案3',
                gmtCreateText: '32分钟前'
            },
            {
                id: 1,
                userNickName: '王二',
                content: '测试答案1',
                gmtCreateText: '17分钟前'
            }
        ]
    },
    methods: {
        loadQuestionDetail: function () {
            // alert('准备加载问题ID=' + this.id +'的详情……');
            $.ajax({
                url: '/portal/question/' + this.id,
                success: function (r) {
                    if (r.state == 2000) {
                        // alert('获取“问题”数据成功！可从浏览器的控制台查看！');
                        // console.log(r.data);
                        let question = r.data;
                        question.gmtCreateText = getTimeText(question.gmtCreate);
                        detailApp.question = question;
                    } else {
                        alert(r.message);
                        location.href = "/";
                    }
                }
            });
        },
        postAnswer: function () {
            // alert('准备发表答案……');
            $.ajax({
                url: '/portal/answer/post',
                data: {
                    questionId: this.id,
                    content: $('#summernote').val()
                },
                type: 'post',
                success: function (r) {
                    if (r.state == 2000) {
                        alert('发表答案成功！');
                        detailApp.loadAnswers();
                        location.href = '#answers';
                        $('#summernote').summernote('reset');
                    } else if (r.state == 4100) {
                        alert(r.message);
                        location.href = '/';
                    } else {
                        alert(r.message);
                    }
                }
            });
        },
        loadAnswers: function () {
            // alert('准备从服务器获取问题ID=' + this.id + '的答案列表……');
            $.ajax({
                url: '/portal/answer',
                data: 'questionId=' + this.id,
                success: function (r) {
                    let list = r.data;
                    let answers = [];
                    for(let i = 0; i < list.length; i++) {
                        let answer = list[i];
                        answer.gmtCreateText = getTimeText(answer.gmtCreate);
                        answers[i] = answer;
                    }
                    detailApp.answers = answers;
                }
            });
        },
        postComment: function (answerId) {
            // alert('准备发表答案ID=' + answerId + "的评论……");
            $.ajax({
                url: '/portal/comment/post',
                type: 'post',
                data: {
                    answerId: answerId,
                    content: $('#commentContent' + answerId).val()
                },
                success: function (r) {
                    if (r.state == 2000) {
                        alert('发表评论成功！');
                        // 后续处理待续
                        alert('发表评论成功');
                        detailApp.loadAnswers();
                    } else {
                        alert(r.message);
                    }
                }
            });
        }
    },
    created: function () {
        let id = location.search.substring(1);
        if (id == "" || isNaN(id)) { // isNaN > is Not a Number
            alert('错误！缺少必要的参数！');
            location.href = "/";
            return;
        }
        this.id = id;
        this.loadQuestionDetail();
        this.loadAnswers();
    }
});




