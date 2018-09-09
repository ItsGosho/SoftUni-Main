function f(arr) {
    let resArr=[];
    let j=0;
    for (let i = 0; i < arr.length; i++) {
        if(i%2!==0){
            resArr[j]=arr[i]*2;
                j++;
        }
    }
    console.log(resArr.reverse().join(" "))
}

f([10, 15, 20, 25]);