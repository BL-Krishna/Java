function numberToWord(num){
    switch(num){
        case 0: return "Zero";
        case 1: return "one";
        case 2: return "two";
        case 3: return "three";
        case 4 : return "four";
        case 5: return "five";
        case 6: return "six";
        default : return "Invalid";
    }
}

function weekDay(num){
    switch (num){
        case 1: return "Sunday";
        case 2: return "Monday";
        case 3: return "Tuesday";
        case 4: return "Wednesday";
        case 5: return "Thursday";
        case 6: return "Friday";
        case 7: return "Saturday";
        default :return "Invalid";
    }
}
console.log(numberToWord(1));
console.log(weekDay(7));