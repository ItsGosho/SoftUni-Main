function func(num){

    let result=num.toString();
    while (true){
        if(checkSum(result)){
            result+=9;
        }else{
            console.log(result);
            break;
        }
    }

    function checkSum(num){
        let numAsStringArray =  num.toString().split("");
        let sum = 0;
        numAsStringArray.map(x=>sum+=parseInt(x));
        let avg = sum/numAsStringArray.length;
        if(avg>=5){
            return false
        }else{
            return true
        }
    }
}

func(1);