//Gosho exam:
function f(arr) {

    let totalPeach=0;
    let totalPlum=0;
    let totalCherry=0;
    let totalRakia=0;

    for (let i = 0; i < arr.length; i++) {
        let splitted=arr[i].split(/\s+/);

        let fruitName=splitted[0];
        let weightInKilo=parseFloat(splitted[1]);

        switch (fruitName) {
            case "peach":
                totalPeach+=weightInKilo;
                break;
            case "plum":
                totalPlum+=weightInKilo;
                break;
            case "cherry":
                totalCherry+=weightInKilo;
                break;
            default:
                totalRakia+=weightInKilo;
                break;
        }
    }
    totalCherry=(totalCherry/0.009)/25;
    console.log("Cherry kompots: "+ Math.floor(totalCherry));
    totalPeach=(totalPeach/0.140)/2.5;
    console.log("Peach kompots: "+ Math.floor(totalPeach));
    totalPlum=(totalPlum/0.020)/10;
    console.log("Plum kompots: "+Math.floor(totalPlum));
    totalRakia=totalRakia*0.200;
    console.log("Rakiya liters: "+ totalRakia.toFixed(2));
}

f([ 'cherry   1.2',
    'peach 2.2',
    'plum 5.2',
    'peach 0.1',
    'cherry 0.2',
    'cherry 5.0',
    'plum 10',
    'cherry 20.0' ,
    'papaya 20' ]
);