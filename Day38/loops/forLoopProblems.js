const { factorial } = require("../utils/mathUtils");
const { isPrime } = require("../utils/primeUtils");

// Powers of 2
let n = 5;
for (let i = 0; i <= n; i++) {
  console.log(`2^${i} = ${Math.pow(2, i)}`);
}

// Harmonic Number
let harmonic = 0;
for (let i = 1; i <= n; i++) {
  harmonic += 1 / i;
}
console.log("Harmonic:", harmonic);

// Prime Check
console.log("Is 17 Prime?", isPrime(17));

// Factorial
console.log("Factorial of 5:", factorial(5));
