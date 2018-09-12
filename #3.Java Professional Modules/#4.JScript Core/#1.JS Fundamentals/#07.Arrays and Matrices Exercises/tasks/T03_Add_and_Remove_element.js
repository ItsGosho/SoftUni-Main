function f(arr) {
  let initStart=1;
  let resultArr=[];
    for (let i = 0; i < arr.length; i++) {
        if(arr[i]==="add"){
           resultArr.push(initStart);
        }else if(arr[i]==="remove"){
            resultArr.pop();
        }
        initStart++;
    }
    if(resultArr.length===0){
        console.log("Empty");
    }else{
        for (const resultArrElement of resultArr) {
            console.log(resultArrElement);
        }
    }
}

f(["remove",
    "remove",
    "remove",
    "remove",
    "remove",]
);