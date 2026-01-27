const { isPrime, getPalindrome } = require("../utils/primeUtils");

function checkPalindromePrime(num) {
  if (isPrime(num)) {
    const palindrome = getPalindrome(num);
    return isPrime(palindrome);
  }
  return false;
}

console.log("Palindrome Prime Check (13):", checkPalindromePrime(13));
