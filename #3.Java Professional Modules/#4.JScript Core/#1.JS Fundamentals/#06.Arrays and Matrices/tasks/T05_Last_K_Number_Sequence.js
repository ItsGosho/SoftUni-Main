function f(n, k) {
    let resArr = [1];
    let nowIndex=1;
    while (true){
        if(resArr.length===n){
            break;
        }
        let sumToAss=0;
        for (let i = 0; i < k; i++) {
             if(resArr[i]!==undefined){
                     sumToAss+=resArr[nowIndex-1-i];
             }
        }
        resArr[nowIndex]=sumToAss;
        nowIndex++;
    }
    console.log(resArr.join(" "));
}

f(6, 3);