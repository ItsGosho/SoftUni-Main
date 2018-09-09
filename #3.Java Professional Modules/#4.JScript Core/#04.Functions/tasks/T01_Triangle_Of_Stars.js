function triangleOfStars(n){
    if(n===1){
        console.log("*");
        return;
    }
    for (let i = 1; i <= n; i++) {
        console.log(concat(i));
    }
    for (let i = n-1; i >0; i--) {
        console.log(concat(i));
    }

    function concat(i){
        let text="";
        for (let j = 0; j < i; j++) {
            text+="*";
        }
        return text;
    }
}

triangleOfStars(1);