function f(arr) {
    let delimiter = arr[arr.length-1];
    let res=[];
    for (let i = 0; i < arr.length-1; i++) {
        res.push(arr[i]);
    }
    console.log(res.join(delimiter))
}

f(["Test",
"Asd",
    "-"]);