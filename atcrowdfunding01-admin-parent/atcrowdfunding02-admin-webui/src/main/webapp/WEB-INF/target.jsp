<%--
  Created by IntelliJ IDEA.
  User: PaperoAviadilo
  Date: 2021/6/5
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script type="application/javascript" src="../jquery/jquery-2.1.1.min.js"></script>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
</head>
<body>
 <h1>Success</h1>
    ${requestScope.get("list")}
 <br/>
 <button id="btn1">发送[2,5,8]</button>
 <button id="btn2">发送</button>
 <button id="btn3">发送</button>
</body>
<script>
    $(function () {
        $("#btn1").click(function(){
            $.ajax({
                "url": "test/array.html",
                "type": "post",
                "data": {
                    "array": [2,5,8]
                },
                "dataType": "text",
                success: function(response){
                    console.log(response)
                },
                error: function(response) {
                    console.log(response)
                }
            })
        })
    })
</script>
</html>
