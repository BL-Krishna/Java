const random=require("../utils/random");

//min and max of 5 random 3-digit number
let nums=[];
for(let i=0;i<5;i++){
    nums.push(random.getThreeDigitRandom());
}

console.log("Numbers :",nums);
console.log("Min :",Math.min(...nums));
console.log("Max : ",Math.max(...nums));

function isLeapYear(year){
    return (year%4 && year%100!=0) || year%400 === 0;
}
console.log("2024 is Leap Year ?",isLeapYear(2024));

//coin flips

console.log("Coin Flip : ",Math.random()<0.5? "Head":"Tail");