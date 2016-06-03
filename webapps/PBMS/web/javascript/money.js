window.onload = function() {
    var year = document.getElementById("year").textContent;
    var month = document.getElementById("month").textContent;
    var inc = document.getElementById('income');
    inc.onblur = function () {
        inc.setAttribute('value', inc.value);
        location.href='change?income=' + inc.value.substr(1) + "&year=" + year + "&month=" + month;
    };

    var food = document.getElementById('food');
    food.onblur = function () {
        food.setAttribute('value', food.value);
        location.href='change?food=' + food.value.substr(1) + "&year=" + year + "&month=" + month;
    };

    var rent = document.getElementById('rent');
    rent.onblur = function () {
        rent.setAttribute('value', rent.value);
        location.href='change?rent=' + rent.value.substr(1) + "&year=" + year + "&month=" + month;
    };

    var educate = document.getElementById('educate');
    educate.onblur = function () {
        educate.setAttribute('value', educate.value);
        location.href='change?educate=' + educate.value.substr(1) + "&year=" + year + "&month=" + month;
    };

    var utilitie = document.getElementById('utilitie');
    utilitie.onblur = function () {
        utilitie.setAttribute('value', utilitie.value);
        location.href='change?utilitie=' + utilitie.value.substr(1) + "&year=" + year + "&month=" + month;
    };

    var medical = document.getElementById('medical');
    medical.onblur = function () {
        medical.setAttribute('value', medical.value);
        location.href='change?medical=' + medical.value.substr(1) + "&year=" + year + "&month=" + month;
    };
};