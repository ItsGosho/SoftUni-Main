function f(arr) {
    let negativeArr=[];
    let negCounter=0;
    let positiveArr=[];
    let posCounter=0;
    for (const item of arr) {
        if(item>=0){
          positiveArr[posCounter]=item;
          posCounter++;
        }else{
            negativeArr[negCounter]=item;
            negCounter++;
        }
    }
    console.log(negativeArr.reverse().join("\n"));
    console.log(positiveArr.join("\n"));
}

f([3, -2, 0, -1]);