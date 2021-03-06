<%--
  Created by IntelliJ IDEA.
  User: boo
  Date: 2022/2/17
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()+"://" + request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>查询学生ajax</title>
    <base href="<%=basePath%>"/>
    <script type="text/javascript" src="js/jquery-1.11.1-min.js"></script>
    <script type="text/javascript">
        $(function () {
            loadStudentData();
            $("#btnLoader").click(function () {
                loadStudentData();
            })
        })

        function loadStudentData() {
            $.ajax({
                url:"student/queryStudent.do",
                type:"get",
                dataType:"json",
                success:function (data) {
                    //清除旧数据
                    $("#info").html("");
                    $.each(data,function (i,n) {
                        //再来增加新的数据
                        $("#info").append("<tr>")
                            .append("<td>"+n.id+"</td>")
                            .append("<td>"+n.name+"</td>")
                            .append("<td>"+n.age+"</td>")
                            .append("<td>"+n.email+"</td>")
                            .append("<tr>")
                    })
                }
            })
        }

    </script>
</head>
<body>
    <div align="center">
        <table>
            <thead>
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>年龄</td>
                <td>邮箱</td>
            </tr>
            </thead>
            <tbody id="info">

            </tbody>
        </table>
        <input type="button" id="btnLoader" value="查询数据">
    </div>

</body>
</html>
