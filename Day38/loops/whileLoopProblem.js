// Powers of 2 till 256
let power = 1;
while (power <= 256) {
  console.log(power);
  power *= 2;
}

// Flip Coin till 11 wins
let heads = 0, tails = 0;
while (heads < 11 && tails < 11) {
  Math.random() < 0.5 ? heads++ : tails++;
}
console.log("Heads:", heads, "Tails:", tails);
