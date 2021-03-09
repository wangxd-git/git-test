$(document).ready(function () {
    $('#summernote').summernote({
        height: 300,
        tabsize: 2,
        lang: 'zh-CN',
        placeholder: '请输入问题的详细描述...',
        callbacks: {
            onImageUpload: function (files) {
                // alert('准备上传图片到服务器端！');
                // 服务器端每次只处理1个文件，所以，只允许上传1个
                if (files.length == 0) {
                    alert('错误！请选择您要上传的图片！')
                    return;
                }
                if (files.length > 1) {
                    alert('错误！一次只能选择1张图片！')
                    return;
                }
                // 从数组中取出元素，该元素就是要上传的文件数据
                let file = files[0];

                // 准备上传时提交的请求参数
                let formData = new FormData();
                // 以下append()方法的第1个参数必须与服务器端要求提交的请求参数名称保持一致
                formData.append('file', file);

                // 通过$.ajax()提交异步请求，并处理结果
                // 当处理文件上传时：
                // -- 提交的请求参数必须是FormData类型的；
                // -- 必须配置contentType为false；
                // -- 必须配置processData为false。
                $.ajax({
                    url: '/portal/question/image/upload',
                    type: 'post',
                    data: formData,
                    contentType: false,
                    processData: false,
                    success: function (r) {
                        if (r.state == 2000) {
                            console.log(r.data);
                            // 创建<img>标签的对象
                            let img = new Image();
                            // 设置<img>标签对象显示的图片
                            img.src = r.data;
                            // 将<img>标签插入到summernote中
                            $('#summernote').summernote('insertNode', img);
                        } else {
                            alert(r.message);
                        }
                    }
                });
            }
        }
    });
});

