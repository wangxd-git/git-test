let tagsApp = new Vue({
    el: '#tagsApp',
    data: {
        tags: [
            { id: 1, name: 'Spring' },
            { id: 2, name: 'SpringMVC' },
            { id: 3, name: 'Mybatis' },
            { id: 4, name: 'SpringBoot' },
            { id: 5, name: 'SpringValidation' }
        ]
    },
    methods: {
        loadTags: function () {
            // alert('准备从服务器端加载标签列表……');
            $.ajax({
                url: '/portal/tag',
                success: function (r) {
                    tagsApp.tags = r.data;
                }
            });
        }
    },
    created: function () {
        this.loadTags();
    }
});

