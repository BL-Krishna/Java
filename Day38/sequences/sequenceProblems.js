const random = require("../utils/random");
const math = require("../utils/mathUtils");

// Single Digit
console.log("Single Digit:", random.getSingleDigit());

// Dice
const dice1 = random.getDiceNumber();
const dice2 = random.getDiceNumber();
console.log("Dice Sum:", dice1 + dice2);

// 5 Random 2-digit Numbers
let numbers = [];
for (let i = 0; i < 5; i++) {
  numbers.push(random.getTwoDigitRandom());
}

console.log("Numbers:", numbers);
console.log("Sum:", math.sum(numbers));
console.log("Average:", math.average(numbers));
