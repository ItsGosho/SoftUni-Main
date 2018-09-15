//Gosho exam:
function f(arr){
    let protmone=0;
    let bitCoinPocket=0;
    let firstPurchDay=0;
    let dayCounter=1;
    let checker=false;
    for (let i = 0; i < arr.length; i++) {
        let goldForTheDay=arr[i];
        if(dayCounter%3===0){
            goldForTheDay*=0.70;
        }
        protmone+=goldForTheDay*67.51;
        while(protmone>=11949.16){
            bitCoinPocket++;
            protmone-=11949.16;
        }
        if(bitCoinPocket>=1 && !checker){
            firstPurchDay=dayCounter;
            checker=true;
        }
        dayCounter++;
    }
    console.log("Bought bitcoins: "+bitCoinPocket);
    if(bitCoinPocket>=1){
        console.log("Day of the first purchased bitcoin: "+firstPurchDay);
    }
    console.log("Left money: "+protmone.toFixed(2)+" lv.");
}

f([3124.15, 504.212, 2511.124]);