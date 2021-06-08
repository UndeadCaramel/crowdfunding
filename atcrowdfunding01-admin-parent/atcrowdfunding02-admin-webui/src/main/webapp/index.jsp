<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert here</title></head>
<base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
<script type="application/javascript" src="jquery/jquery-2.1.1.min.js"></script>
<body>
<a href="test/ssm.html">测试ssm整合环境</a>
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