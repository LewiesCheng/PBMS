window.onload = function() {
    var inc = document.getElementById('income');
    inc.onblur = function () {
        var income = parseFloat(inc.value.substr(1));
        inc.setAttribute('value', inc.value);
        location.href='change?income=' + inc.value.substr(1);
    };

    var spe = document.getElementById('spend');
    spe.onblur = function () {
        var spend = parseFloat(spe.value.substr(1));
        spe.setAttribute('value', spe.value);
        location.href='change?spend=' + spe.value.substr(1);
    };
};