<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="account/findAll">查询所有账户</a>

    <form action="account/saveAccount" method="post">
        ID: <input type="text" name="id"/><br/>
        UID: <input type="text" name="uid"/><br/>
        Money: <input type="text" name="money"/><br/>
        <input type="submit" value="保存用户"/><br/>
    </form>
</body>
</html>
