function check(year){
    if(year%4 ===0 || year%400 === 0){
        console.log("yes")
    }else{
        console.log("no");
    }
}

check(1900);