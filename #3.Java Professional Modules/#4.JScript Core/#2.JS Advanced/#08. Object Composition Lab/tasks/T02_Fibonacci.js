function getFibonator() {
    let counter=0;
    if(counter=0){
        console.log(1);
    }
    console.log(1);
    let num1=0;
    let num2=1;
    return function fib() {
        let res = num2+num1;
        num2=num1;
        num1=res;
        return res;
    };
}

let fib = getFibonator();
console.log(fib()); // 1
console.log(fib()); // 1
console.log(fib()); // 2
console.log(fib()); // 3
console.log(fib()); // 5
console.log(fib()); // 8
console.log(fib()); // 13
