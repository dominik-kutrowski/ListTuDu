
function clock(){
    var today = new Date();

    var hour = today.getHours();
    var minute = today.getMinutes();
    var second = today.getSeconds();

    if(hour<10)hour = "0"+hour;
    if(minute<10)minute = "0"+minute;
    if(second<10)second = "0"+second;

    document.getElementById("clock").innerHTML =
     today.getDate()+"/"+today.getMonth()+"/"+today.getFullYear()
     +" | "+hour+":"+minute+":"+second;

    setTimeout("clock()",1000)
}