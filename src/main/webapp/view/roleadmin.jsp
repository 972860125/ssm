<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <style>
        #allpermis li {
            list-style-type: none;
        }
    </style>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.js"></script>

    <script>
        function getpermisJs(id) {
            //获取所有的权限
            $.ajax({
                type: "GET",
                async:false,
                url: "<%=request.getContextPath()%>/selectAllPermis",
                success: function (d) {
                    var allpermis = "";
                    for (var i = 0; i < d.data[0].length; i++) {
                        var onemenuobj = d.data[0][i];//每一个第一级菜单对象
                        var apermistitle = onemenuobj.apermistitle;//第一级菜单的名字
                        var aid = onemenuobj.aid;//第一级菜单的id
                        allpermis += " <ul class=\"onepermisli\"><li><input type=\"checkbox\" name=\"permisid\" value=\"" + aid + "\">" + apermistitle;

                        var twolist = onemenuobj.twolist;//一个一级菜单对应的多个二级菜单
                        allpermis += " <ul class=\"twopermisli\">";
                        for (var j = 0; j < twolist.length; j++) {
                            var twomenuobj = twolist[j];//一个二级菜单对象
                            var bpermistitle = twomenuobj.bpermistitle;//二级菜单的名字
                            var bid = twomenuobj.bid;//二级菜单的id
                            allpermis += "<li><input type=\"checkbox\" name=\"permisid\" value=\"" + bid + "\">" + bpermistitle;//二级

                            var threelist = twomenuobj.threelist;//一个二级菜单对应的多个三级菜单
                            allpermis += "<ul class=\"threepermisli\">";
                            for (var z = 0; z < threelist.length; z++) {
                                var threemenuobj = threelist[z];//一个三级菜单对象
                                var cpermistitle = threemenuobj.cpermistitle;//三级菜单的名字
                                var cid = threemenuobj.cid;//三级菜单的id
                                allpermis += "<li><input type=\"checkbox\" name=\"permisid\" value=\"" + cid + "\">" + cpermistitle + "</li>";
                            }
                            allpermis += "</ul>";

                            allpermis += "</li>";//二级
                        }
                        allpermis += "</ul>";
                        allpermis += "</li>";
                        allpermis += "</ul>";
                    }
                    $("#allpermis").html(allpermis);
                }
            });

            //获取角色对应的权限
            $.ajax({
                type: "GET",
                async:true,
                url: "<%=request.getContextPath()%>/selectAllPermis?id=" + id,
                success: function (d) {
                    var allpermisid=d.data[0];//角色对应的所有权限id数组
                    for(var i=0;i<allpermisid.length;i++){
                        $("#allpermis :checkbox[value='"+allpermisid[i]+"']").attr("checked",true);
                    }
                }
            });

        }


    </script>
</head>
<body>
<br>
<div class="row">
    <div class="col-lg-3">

        <table class="table table-bordered table-condensed table-responsive">
            <tr>
                <td>角色名字</td>
                <td>描述</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${roleList}" var="v">
                <tr>
                    <td>${v.rolename}</td>
                    <td>${v.description}</td>
                    <td>
                        <button onclick="getpermisJs(${v.id})">修改角色</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="col-lg-9" id="allpermis">

    </div>
</div>
</body>
</html>
