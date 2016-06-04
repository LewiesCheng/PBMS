<%@ page import="servlet.Count" %>
<%@ page import="servlet.Item" %>
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
    <form method="get" action="money" onsubmit="return check();">
        <select name="year" id="yearSelect">
            <option value="2016" <%=count.getYear().equals("2016") ? "Selected" : ""%>>2016</option>
            <option value="2015" <%=count.getYear().equals("2015") ? "Selected" : ""%>>2015</option>
        </select>
        <select name="month" id="monthSelect">
            <option value="12" <%=count.getMonth().equals("12") ? "Selected" : ""%>>12</option>
            <option value="11" <%=count.getMonth().equals("11") ? "Selected" : ""%>>11</option>
            <option value="10" <%=count.getMonth().equals("10") ? "Selected" : ""%>>10</option>
            <option value="9" <%=count.getMonth().equals("9") ? "Selected" : ""%>>9</option>
            <option value="8" <%=count.getMonth().equals("8") ? "Selected" : ""%>>8</option>
            <option value="7" <%=count.getMonth().equals("7") ? "Selected" : ""%>>7</option>
            <option value="6" <%=count.getMonth().equals("6") ? "Selected" : ""%>>6</option>
            <option value="5" <%=count.getMonth().equals("5") ? "Selected" : ""%>>5</option>
            <option value="4" <%=count.getMonth().equals("4") ? "Selected" : ""%>>4</option>
            <option value="3" <%=count.getMonth().equals("3") ? "Selected" : ""%>>3</option>
            <option value="2" <%=count.getMonth().equals("2") ? "Selected" : ""%>>2</option>
            <option value="1" <%=count.getMonth().equals("1") ? "Selected" : ""%>>1</option>
        </select>
        <input id="query" type="submit" value="查询">
    </form>
    <table id="table1">
        <caption><span id="year">${count.getYear()}</span>年<span id="month">${count.getMonth()}</span>月收支表</caption>
        <thead>
        <td></td><td>本月</td><td>本年</td>
        </thead>
        <tbody>
        <tr><td>收入</td><td><input id="income" class="hidden" value="￥${count.getIncome()}"></td>
            <td id="ti">￥${count.getTotalIncome()}</td></tr>
        <tr><td>支出</td><td>￥${count.getSpend()}</td>
            <td id="ts">￥${count.getTotalSpend()}</td></tr>
        </tbody>
    </table>

    <table id="table2">
        <caption>${count.getYear()}年${count.getMonth()}月支出明细</caption>
        <thead><td>食品消费</td><td>房租</td><td>子女教育</td><td>水电费</td><td>医疗费</td></thead>
        <tbody>
        <tr><td><input id="food" class="hidden" value="￥${count.getFood()}"></td>
            <td><input id="rent" class="hidden" value="￥${count.getRent()}"></td>
            <td><input id="educate" class="hidden" value="￥${count.getEducate()}"></td>
            <td><input id="utilitie" class="hidden" value="￥${count.getUtilitie()}"></td>
            <td><input id="medical" class="hidden" value="￥${count.getMedical()}"></td></tr>
        </tbody>
    </table>

    <table id="table3">
        <caption>${count.getYear()}年${count.getMonth()}月排序后的支出明细</caption>
    <%
        Item[] items = new Item[5];
        items[0] = new Item("食品消费", count.getFood());
        items[1] = new Item("房租", count.getRent());
        items[2] = new Item("子女教育", count.getEducate());
        items[3] = new Item("水电费", count.getUtilitie());
        items[4] = new Item("医疗费", count.getMedical());

        // 冒泡排序
        for (int i = 1; i < items.length; i++) {
            for (int j = i; j > 0; j--) {
                if (items[j].compareTo(items[j-1]) < 0) {
                    Item temp = items[j];
                    items[j] = items[j - 1];
                    items[j - 1] = temp;
                }
            }
        }

        out.println("<thead>");
        for (Item item : items) {
            out.println("<td>" + item.getItem() + "</td>");
        }
        out.println("</thead>");
        out.println("<tbody><tr>");
        for (Item item : items) {
            out.println("<td>￥" + item.getSpend() + "</td>");
        }
        out.println("<tr></tbody>");
        out.flush();
    %>
    </table>
</div>
<script lang="javascript" type="text/javascript" src="javascript/check.js"></script>
<script lang="javascript" type="text/javascript" src="javascript/money.js"></script>
</body>
</html>
