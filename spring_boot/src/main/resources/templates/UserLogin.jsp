
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" type="text/css" href="../static/bootstrap3/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../static/bootstrap3/font-awesome-4.7.0/css/font-awesome.css"/>
    <script type="text/javascript" src="../static/bootstrap3/jquery.min.js"></script>
    <script type="text/javascript" src="../static/bootstrap3/js/bootstrap.js"></script>
    <script type="text/javascript" src="../static/bootstrap3/js/holder.js"></script>
    <script type="text/javascript" src="../static/bootstrap3/js/html5shiv.min.js"></script>
    <script type="text/javascript" src="../static/bootstrap3/js/css3-mediaqueries.js"></script>
    <script type="text/javascript" src="../static/bootstrap3/js/respond.min.js"></script>
</head>
<body>
<div>
    <form action="/userLogin" method="post">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>id</th>
                <th>姓名</th>
                <th>密码</th>
                <th>学号</th>
            </tr>
            </thead>
            <tbody>
      <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.password}</td>
                <td>${user.stunumber}</td>
            </tr>
      </c:forEach>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
