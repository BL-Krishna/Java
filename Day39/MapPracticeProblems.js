
// Dice Roll Simulation

function rollDie() {
    return Math.floor(Math.random() * 6) + 1;
}

function diceSimulation() {
    let diceCount = {};

    // Initialize dictionary
    for (let i = 1; i <= 6; i++) {
        diceCount[i] = 0;
    }

    let reachedTen = false;

    while (!reachedTen) {
        let result = rollDie();
        diceCount[result]++;

        if (diceCount[result] === 10) {
            reachedTen = true;
        }
    }

    console.log("Dice Roll Counts:", diceCount);

    let maxNum = null, minNum = null;
    let maxCount = -Infinity, minCount = Infinity;

    for (let num in diceCount) {
        if (diceCount[num] > maxCount) {
            maxCount = diceCount[num];
            maxNum = num;
        }
        if (diceCount[num] < minCount) {
            minCount = diceCount[num];
            minNum = num;
        }
    }

    console.log(`Maximum times rolled: Number ${maxNum} (${maxCount} times)`);
    console.log(`Minimum times rolled: Number ${minNum} (${minCount} times)`);
}



//  Birth Month Generator


function generateBirthMonths() {
    const months = [
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    ];

    let birthMonthMap = {};

    // Initialize months
    for (let month of months) {
        birthMonthMap[month] = [];
    }

    for (let i = 1; i <= 50; i++) {
        let year = Math.random() < 0.5 ? 1992 : 1993;
        let monthIndex = Math.floor(Math.random() * 12);
        let month = months[monthIndex];

        birthMonthMap[month].push(`Person${i} (${year})`);
    }

    console.log("\nIndividuals grouped by birth month:");

    for (let month in birthMonthMap) {
        if (birthMonthMap[month].length > 0) {
            console.log(`${month}:`, birthMonthMap[month]);
        }
    }
}


console.log("=== Dice Roll Simulation ===");
diceSimulation();

console.log("\n=== Birth Month Simulation ===");
generateBirthMonths();
