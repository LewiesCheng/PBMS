<%@ page import="servlet.Count" %><%--
  Created by JoyHwong on 16/6/3.
  Copyright @ 2016 All right reserved.
  Follow me on github https://github.com/JoyHwong

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/money.css">
</head>
<body>
<%
    Count count = (Count)request.getSession().getAttribute("count");
%>
<div id="wapper">
    <table>
        <caption>收支表</caption>
        <thead>
        <td></td><td>本月</td><td>本年</td>
        </thead>
        <tbody>
        <tr><td>收入</td><td><input id="income" class="hidden" value="￥${count.getIncome()}"></td>
            <td id="ti">￥${count.getTotalIncome()}</td></tr>
        <tr><td>支出</td><td><input id="spend" class="hidden" value="￥${count.getSpend()}"></td>
            <td id="ts">￥${count.getTotalSpend()}</td></tr>
        </tbody>
    </table>
</div>
<script lang="javascript" type="text/javascript" src="javascript/money.js"></script>
</body>
</html>
