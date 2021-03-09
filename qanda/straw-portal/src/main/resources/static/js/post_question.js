Vue.component('v-select', VueSelect.VueSelect);

let postQuestionApp = new Vue({
    el: '#postQuestionApp',
    data: {
        tags: [
            { value: 1, label: 'Spring' },
            { value: 2, label: 'SpringMVC' },
            { value: 3, label: 'Mybatis' },
            { value: 4, label: 'SpringBoot' },
            { value: 5, label: 'SpringValidation' }
        ],
        selectedTagIds: [],
        teachers: [
            { value: 1, label: '大刘老师' },
            { value: 2, label: '王老师' },
            { value: 3, label: '范老师' },
            { value: 4, label: '小刘老师' },
            { value: 5, label: '成老师' }
        ],
        selectedTeacherIds: []
    },
    methods: {
        loadTags: function () {
            // alert('准备从服务器端加载标签列表……');
            $.ajax({
                url: '/portal/tag',
                success: function (r) {
                    let list = r.data;
                    let tags = [];
                    for (let i = 0; i < list.length; i++) {
                        let tag = {};
                        tag.value = list[i].id;
                        tag.label = list[i].name;
                        tags[i] = tag;
                    }
                    postQuestionApp.tags = tags;
                }
            });
        },
        loadTeachers: function () {
            // alert('准备从服务器端加载老师列表……');
            $.ajax({
                url: '/portal/user/list/teacher',
                success: function (r) {
                    let list = r.data;
                    let teachers = [];
                    for (let i = 0; i < list.length; i++) {
                        let teacher = {};
                        teacher.value = list[i].id;
                        teacher.label = list[i].nickName;
                        teachers[i] = teacher;
                    }
                    postQuestionApp.teachers = teachers;
                }
            });
        },
        postQuestion: function () {
            // alert('准备提交发布问题的表单，请通过浏览器的控制台观察即将提交的数据！');
            let title = $('#title').val();
            let tagIds = postQuestionApp.selectedTagIds;
            let teacherIds = postQuestionApp.selectedTeacherIds;
            let content = $('#summernote').val();
            console.log(title);
            console.log(tagIds);
            console.log(teacherIds);
            console.log(content);

            $.ajax({
                url: '/portal/question/post',
                type: 'post',
                data: {
                    title: title,
                    content: content,
                    tagIds: tagIds,
                    teacherIds: teacherIds
                },
                traditional: true,
                success: function (r) {
                    if (r.state == 2000) {
                        alert('发布问题成功！');
                    } else {
                        alert(r.message);
                    }
                },
                error: function () {
                    alert('程序运行出错，请打开浏览器的控制台检查错误，如果提示500错误，还需要检查服务器端的控制台！');
                }
            });
        }
    },
    created: function () {
        this.loadTags();
        this.loadTeachers();
    }
});

