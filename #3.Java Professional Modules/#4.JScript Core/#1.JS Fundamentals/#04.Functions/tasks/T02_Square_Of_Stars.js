function printSquare(n){
    let res="";
    for (let i = 0; i < n; i++) {
        if(i!==0){
            res+="\n";
        }
        for (let j = 0; j < n; j++) {
            res+="* ";
        }
    }
    console.log(res);
}

printSquare(5);