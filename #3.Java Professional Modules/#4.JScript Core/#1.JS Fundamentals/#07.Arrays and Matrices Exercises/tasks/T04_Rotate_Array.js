function f(arr) {
  let rollsCount=arr[arr.length-1];
  arr.pop();
    for (let i = 0; i < rollsCount; i++) {
        arr=rotate(arr);
    }
    console.log(arr.join(" "));
    function rotate(arr) {
        let resArr=[];
        resArr.push(arr[arr.length-1]);
        for (let i = 0; i < arr.length-1; i++) {
            resArr.push(arr[i]);
        }
        return resArr;
    }
}

f(["Banana",
    "Orange",
    "Coconut",
    "Apple",
    15
]);