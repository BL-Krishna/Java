function sum(numbers) {
  return numbers.reduce((a, b) => a + b, 0);
}

function average(numbers) {
  return sum(numbers) / numbers.length;
}

function factorial(n) {
  let fact = 1;
  for (let i = 1; i <= n; i++) {
    fact *= i;
  }
  return fact;
}

module.exports = { sum, average, factorial };
