function f(arr) {
    let res="";
    for (let i = 1; i < arr[0]+1; i++) {
        res+=arr[i]+" ";
    }
    res+="\n";
    for (let i = arr.length-arr[0]; i < arr.length; i++) {
        res+=arr[i]+" ";
    }
    console.log(res);
}

f([2,
    7, 8, 9]
);