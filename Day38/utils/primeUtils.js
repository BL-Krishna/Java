function isPrime(n){
    if(n<=1)return false;
    for(let i=2;i*i<=n;i++){
        if(n%i==0) return false;
    }
    return true;
}

function getPalindrome(n){
    return Number(n.toString().split("").reverse().join(""));
}

function primeFactors(n){
    let factors=[];
    for(let i=2;i*i<=n;i++){
          while (n % i === 0) {
      factors.push(i);
      n /= i;
    }
    }
  if (n > 1) factors.push(n);
  return factors;
}

module.exports={isPrime,getPalindrome,primeFactors};