/**
 * Created by JoyHwong on 16/6/2.
 */
var btn = document.getElementById('button');

btn.addEventListener("click", function () {

    var inputs = document.getElementsByClassName("input");
    if (inputs[0].value === 'admin' && inputs[1].value === 'admin') {
        location.href = 'money';
    } else {
        alert("账号密码不匹配");
    }
}, false);