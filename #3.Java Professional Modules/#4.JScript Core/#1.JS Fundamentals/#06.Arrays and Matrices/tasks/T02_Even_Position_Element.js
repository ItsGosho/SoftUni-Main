function f(arr) {
    let resArr=[];
    let j=0;
    for (let i = 0; i < arr.length; i++) {
        if(i%2===0){
            resArr[j]=arr[i];
            j++;
        }
    }
    console.log(resArr.join(" "));
}

f(['20', '30', '40']);