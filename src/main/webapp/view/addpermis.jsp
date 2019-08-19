
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.js"></script>
</head>
<body>

<br>
<form class="form-horizontal" method="post" action="<%=request.getContextPath()%>/addpermismenu">
    <input type="hidden" name="parent" value="<%=request.getParameter("id")%>">
    <div class="form-group">
        <label for="permistitle" class="col-sm-2 control-label">标题</label>
        <div class="col-sm-10">
            <input type="text" name="permistitle" class="form-control" id="permistitle" placeholder="标题">
        </div>
    </div>
    <div class="form-group">
        <label for="permisname" class="col-sm-2 control-label">权限名字(user:sel)</label>
        <div class="col-sm-10">
            <input type="text" name="permisname" class="form-control" id="permisname" placeholder="权限名字">
        </div>
    </div>

    <div class="form-group">
        <label for="href" class="col-sm-2 control-label">链接地址</label>
        <div class="col-sm-10">
            <input type="text" name="href" class="form-control" id="href" placeholder="链接地址">（如果不是菜单可以不写）
        </div>
    </div>

    <div class="form-group">
        <label for="permistype" class="col-sm-2 control-label">权限类型</label>
        <div class="col-sm-10">
            <input type="text" name="permistype" class="form-control" id="permistype" placeholder="权限类型">（1:菜单 2:其他操作）
        </div>
    </div>

    <div class="form-group">
        <label for="description" class="col-sm-2 control-label">描述</label>
        <div class="col-sm-10">
            <input type="text" name="description" class="form-control" id="description" placeholder="描述">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">增加</button>
        </div>
    </div>
</form>
</body>
</html>
