console.log("======Array Practice Problems");

//generate random 3 digit number and find largest and second largest number without sorting

function secondLargestWithoutSorting(){
    let arr=[];

    for(let i=0;i<10;i++){
        arr.push(Math.floor(Math.random()*900)+100);
    }
    let largest=-Infinity ,secondLargest=-Infinity;
    let smallest=Infinity,secondSmallet=Infinity;

    for(let num of arr){
        if(num > largest){
            secondLargest=largest;
            largest=num;
        }
        else if(num>secondLargest && num !=largest){
            secondLargest=num;
        }

        if(num<smallest){
            secondSmallet=smallest;
            smallest=num;
        }
        else if(num<secondSmallet && num!=smallest){
            secondSmallet=num;
        }
    }
    console.log("Array ",arr);
    console.log("2nd Largest",secondLargest);
    console.log("2nd Smallest ",secondSmallet);

}
// Sort array and find 2nd largest & smallest
function secondLargestSmallestWithSort() {
    let arr = [];

    for (let i = 0; i < 10; i++) {
        arr.push(Math.floor(Math.random() * 900) + 100);
    }

    arr.sort((a, b) => a - b);

    console.log("Sorted Array:", arr);
    console.log("2nd Smallest:", arr[1]);
    console.log("2nd Largest", arr[arr.length - 2]);
}

//  Prime Factorization stored in array
function primeFactorsToArray(n) {
    let factors = [];

    for (let i = 2; i * i <= n; i++) {
        while (n % i === 0) {
            factors.push(i);
            n /= i;
        }
    }
    if (n > 1) factors.push(n);

    console.log("Prime Factors:", factors);
}


//sum of three integers equals to zero
function sumOfThreeZero() {
    let arr = [-1, 0, 1, 2, -2, -3, 3];
    let result = [];

    for (let i = 0; i < arr.length - 2; i++) {
        for (let j = i + 1; j < arr.length - 1; j++) {
            for (let k = j + 1; k < arr.length; k++) {
                if (arr[i] + arr[j] + arr[k] === 0) {
                    result.push([arr[i], arr[j], arr[k]]);
                }
            }
        }
    }

    console.log("Triplets with sum zero:", result);
}

//  Repeated digits between 0–100
function repeatedDigits() {
    let repeated = [];

    for (let i = 11; i <= 99; i += 11) {
        repeated.push(i);
    }

    console.log("Repeated digits:", repeated);
}
secondLargestWithoutSorting();
console.log("----------------------");

secondLargestSmallestWithSort();
console.log("----------------------");

primeFactorsToArray(56);
console.log("----------------------");

sumOfThreeZero();
console.log("----------------------");

repeatedDigits();

