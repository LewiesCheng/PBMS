/**
 * Created by hdvsyu on 16/6/4.
 */
function check() {
    var yearSelect = document.getElementById("yearSelect");
    var yearIndex = yearSelect.selectedIndex;
    var year = yearSelect.options[yearIndex].text;
    
    var monthSelect = document.getElementById("monthSelect");
    var monthIndex = monthSelect.selectedIndex;
    var month = monthSelect.options[monthIndex].text;
    
    if (year === "2016" && parseInt(month) <= 6 || year === "2015") {
        return true;
    }
    alert("选择的日期不合法");
    return false;
}
