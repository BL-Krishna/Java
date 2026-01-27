function inchesToFeet(){
    return inches/12;
}

function feetToMeter(){
    return feet *0.3048;
}

function meterToFeet(){
    return meter/0.3048;
}

function fahrenheitToCelsuis(f){
    return (f-32)*5/9;
}

function celsiusToFahrenheit(c){
    return (c*9/5)+32;
}

module.exports={
inchesToFeet,
feetToMeter,
meterToFeet,
fahrenheitToCelsuis,
celsiusToFahrenheit
}