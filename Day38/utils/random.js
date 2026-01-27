function getSingleDigit() {
  return Math.floor(Math.random() * 10);
}

function getDiceNumber() {
  return Math.floor(Math.random() * 6) + 1;
}

function getTwoDigitRandom() {
  return Math.floor(Math.random() * 90) + 10;
}

function getThreeDigitRandom() {
  return Math.floor(Math.random() * 900) + 100;
}

module.exports = {
  getSingleDigit,
  getDiceNumber,
  getTwoDigitRandom,
  getThreeDigitRandom
};
