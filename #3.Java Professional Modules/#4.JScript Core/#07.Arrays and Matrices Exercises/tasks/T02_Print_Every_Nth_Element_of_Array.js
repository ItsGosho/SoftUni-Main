function f(arr) {
   let step=arr[arr.length-1];
    for (let i = 0; i < arr.length; i+=step) {
        console.log(arr[i]);
    }
}

f([5,
20,
31,
4,
20,
2,
]);