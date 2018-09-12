function f(arr) {
    let resArr=[];
    let currMax=Number.MIN_VALUE;
    for (const arrElement of arr) {
        if(arrElement>=currMax){
            resArr.push(arrElement);
            currMax=arrElement;
        }
    }
    for (const resArrElement of resArr) {
        console.log(resArrElement);
    }
}

f([ 1,
    3,
    8,
    4,
    10,
    12,
    3,
    2,
    24,
]);