let registerApp = new Vue({
    el: '#registerApp',
    methods: {
        register: function () {
            // alert("准备提交注册……");
            $.ajax({
                url: '/portal/user/register/student',
                type: 'post',
                data: {
                    inviteCode: $('#inviteCode').val(),
                    nickName: $('#nickname').val(),
                    phone: $('#phone').val(),
                    password: $('#password').val()
                },
                success: function (r) {
                    if (r.state == 2000) {
                        alert('注册成功！');
                    } else {
                        alert(r.message);
                    }
                },
                error: function () {
                    alert('程序运行出错，请打开浏览器的控制台检查错误，如果提示500错误，还需要检查服务器端的控制台！');
                }
            });
        }
    }
});