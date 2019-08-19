<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.js"></script>

    <style>

    </style>

    <script>
        $(function () {
            getPermisJson(0, 0, 1);
        });

        //获取一级菜单
        function getPermisJson(parent, t, n) {
            if (t == 0) {//进入页面自动加载第一级的菜单

            } else {
                var dh= $(t).parent("div").next("div").html();
                if(dh!=""){
                    return;
                }
            }

            $.get("<%=request.getContextPath()%>/permismenu?parent=" + parent, function (data) {
                var s = "";
                var adiv = 640 - (n - 1) * 30;
                for (var i = 0; i < data.length; i++) {
                    s += "<div style='width: " + adiv + "px;float: left;'>" + data[i].permistitle + "【权限名字" + data[i].permisname + "】【描述" + data[i].description + "】</div>";
                    s += "<div  style='width: 280px;float: left;'><button type=\"button\" class=\"btn btn-default btn-xs\" onclick='getPermisJson(" + data[i].id + ",this," + (n + 1) + ")'>查看下级菜单</button>";
                    s += "&nbsp;<button type=\"button\" onclick='addmenu("+data[i].id+")' class=\"btn btn-primary btn-xs\">增加下级菜单</button></div>";
                    s += "<div  style='clear:both;padding-left: 30px'></div>";
                }
                if (t == 0) {
                    $("#permisdiv").append(s);
                } else {
                    $(t).parent("div").next("div").append(s);
                }
            });
        }


        function addmenu(id) {
            window.location.href="<%=request.getContextPath()%>/view/addpermis.jsp?id="+id;
        }

    </script>


</head>

<body>
<div class="container-fluid">

    <br>
    <div id="permisdiv">

    </div>


</div>

</body>
</html>
