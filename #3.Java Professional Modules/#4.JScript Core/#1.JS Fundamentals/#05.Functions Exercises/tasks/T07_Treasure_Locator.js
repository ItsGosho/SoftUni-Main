function find(arr){
    for (let i = 0; i < arr.length; i+=2) {
        let x = arr[i];
        let y = arr[i + 1];
        if (x >= 1 && x <= 3 && y >= 1 && y <= 3) {
            console.log("Tuvalu");
        } else if (x >= 8 && x <= 9 && y >= 0 && y <= 1) {
            console.log("Tokelau");
        } else if (x >= 5 && x <= 7 && y >= 3 && y <= 6) {
            console.log("Samoa");
        } else if (x >= 0 && x <= 2 && y >= 6 && y <= 8) {
            console.log("Tonga");
        }else if (x >= 4 && x <= 9 && y >= 7 && y <= 8) {
            console.log("Cook");
        }else{
            console.log("On the bottom of the ocean");
        }
    }
}

find([6,4]);