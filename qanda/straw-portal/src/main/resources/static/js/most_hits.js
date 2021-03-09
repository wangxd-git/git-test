let mostHitsApp = new Vue({
    el: '#mostHitsApp',
    data: {
        questions: [
            {
                "id": 12,
                "title": "使用summernote上传本地图片后却不发布问题会不会形成浪费？",
                "status": 2,
                "statusText": "已解决",
                "statusClass": "text-success",
                "hits": 763
            },
            {
                "id": 5,
                "title": "Servlet与JSP有什么关系？",
                "status": 0,
                "statusText": "未回复",
                "statusClass": "text-warning",
                "hits": 712
            },
            {
                "id": 10,
                "title": "HashMap和HashTable有什么区别？",
                "status": 1,
                "statusText": "已回复",
                "statusClass": "text-info",
                "hits": 670
            }
        ]
    },
    methods: {
        loadMostHits: function () {
            // alert('准备从服务器端加载热点问题……');
            $.ajax({
                url: '/portal/question/most-hits',
                success: function (r) {
                    let list = r.data;
                    let questions = [];
                    let statusTexts = ['未回复', '未解决', '已解决'];
                    let statusClasses = ['text-warning', 'text-info', 'text-success'];
                    for (let i = 0; i < list.length; i++) {
                        let question = list[i];
                        question.statusText = statusTexts[question.status];
                        question.statusClass = statusClasses[question.status];
                        questions[i] = question;
                    }
                    mostHitsApp.questions = questions;
                }
            });
        }
    },
    created: function () {
        this.loadMostHits();
    }
});
