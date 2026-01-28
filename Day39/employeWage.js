console.log("====== EMPLOYEE WAGE USING ARRAY & MAP ======");

// ---------------- CONSTANTS ----------------
const IS_PART_TIME = 1;
const IS_FULL_TIME = 2;
const PART_TIME_HOURS = 4;
const FULL_TIME_HOURS = 8;
const WAGE_PER_HOUR = 20;
const MAX_HRS_IN_MONTH = 160;
const NUM_OF_WORKING_DAYS = 20;

// ---------------- HELPER FUNCTIONS ----------------
function getWorkingHours(empCheck) {
    switch (empCheck) {
        case IS_PART_TIME:
            return PART_TIME_HOURS;
        case IS_FULL_TIME:
            return FULL_TIME_HOURS;
        default:
            return 0;
    }
}

function calcDailyWage(empHrs) {
    return empHrs * WAGE_PER_HOUR;
}

// =================================================
// UC 6 – Store Daily Wage along with Total Wage
// =================================================

let totalEmpHrs = 0;
let totalWorkingDays = 0;
let empDailyWageArr = new Array();

while (totalEmpHrs < MAX_HRS_IN_MONTH &&
       totalWorkingDays < NUM_OF_WORKING_DAYS) {

    totalWorkingDays++;
    let empCheck = Math.floor(Math.random() * 10) % 3;
    let empHrs = getWorkingHours(empCheck);
    totalEmpHrs += empHrs;

    empDailyWageArr.push(calcDailyWage(empHrs));
}

let empWage = calcDailyWage(totalEmpHrs);

console.log("UC6 → Total Days:", totalWorkingDays,
            "Total Hours:", totalEmpHrs,
            "Total Wage:", empWage);

// =================================================
// UC 7 – Array Helper Functions
// =================================================

// UC 7A – Calculate total wage using forEach
let totalWage = 0;
empDailyWageArr.forEach(wage => totalWage += wage);
console.log("UC7A → Total Wage using forEach:", totalWage);

// UC 7A – Calculate total wage using reduce
let totalWageReduce = empDailyWageArr.reduce((sum, wage) => sum + wage, 0);
console.log("UC7A → Total Wage using reduce:", totalWageReduce);

// UC 7B – Show Day along with Daily Wage (map)
let dayWithWageArr = empDailyWageArr.map(
    (wage, index) => `Day ${index + 1} = ${wage}`
);
console.log("UC7B → Day with Daily Wage:");
console.log(dayWithWageArr);

// UC 7C – Show Days when Full Time Wage (160) was earned (filter)
let fullTimeWageArr = dayWithWageArr.filter(wage => wage.includes("160"));
console.log("UC7C → Days with Full Time Wage:");
console.log(fullTimeWageArr);

// UC 7D – First occurrence when Full Time Wage was earned (find)
let firstFullTime = dayWithWageArr.find(wage => wage.includes("160"));
console.log("UC7D → First Full Time Wage Day:", firstFullTime);

// UC 7E – Check if Every Element is Full Time Wage (every)
let isAllFullTime = empDailyWageArr.every(wage => wage === 160);
console.log("UC7E → All Days Full Time?", isAllFullTime);

// UC 7F – Check if Any Part Time Wage exists (some)
let isAnyPartTime = empDailyWageArr.some(wage => wage === 80);
console.log("UC7F → Any Part Time Wage?", isAnyPartTime);

// UC 7G – Number of days Employee Worked (reduce)
let numOfDaysWorked = empDailyWageArr.reduce(
    (days, wage) => wage > 0 ? days + 1 : days, 0
);
console.log("UC7G → Number of Days Worked:", numOfDaysWorked);

// =================================================
// UC 8 – Store Daily Wage in a Map
// =================================================

let empDailyWageMap = new Map();
totalEmpHrs = 0;
totalWorkingDays = 0;

while (totalEmpHrs < MAX_HRS_IN_MONTH &&
       totalWorkingDays < NUM_OF_WORKING_DAYS) {

    totalWorkingDays++;
    let empCheck = Math.floor(Math.random() * 10) % 3;
    let empHrs = getWorkingHours(empCheck);
    totalEmpHrs += empHrs;

    empDailyWageMap.set(totalWorkingDays, calcDailyWage(empHrs));
}

// Calculate total wage using Map
let totalWageFromMap = 0;
for (let wage of empDailyWageMap.values()) {
    totalWageFromMap += wage;
}

console.log("UC8 → Daily Wage Map:", empDailyWageMap);
console.log("UC8 → Total Wage using Map:", totalWageFromMap);

