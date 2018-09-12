function f(arr) {
    let res="";
    for (let i = 0; i < arr.length; i++) {
        res+=arr[i];
    }
    let out="";
    for (let i = res.length-1; i >= 0; i--) {
        out+=res[i];
    }
    console.log(out);
}

f(['I', 'am', 'student']);