//Gosho exam:
function f(arr) {
    //arr[0] -> pilots
    let pilots=arr[0].split(/\s+/);
    pilots.splice(0,0);
    for (let i = 1; i < arr.length; i++) {
        let splitted=arr[i].split(/\s+/);

        let action=splitted[0];
        let racer=splitted[1];

        let pilotExist=false;
        let pilotPosition=-1;

        for (let j = 0; j < pilots.length; j++) {
            if(pilots[j]===racer){
                pilotExist=true;
                pilotPosition=j;
                break;
            }
        }
        switch (action) {
            case "Join":
                if(!pilotExist){
                    pilots[pilots.length]=racer;
                }
                break;
            case "Crash":
                if(pilotExist){
                    //pilots[pilotPosition]=undefined;
                    pilots.splice(pilotPosition,1);
                }
                break;
            case "Pit":
                if(pilotExist){
                    let pilotTwoName=pilots[pilotPosition+1];
                    let pilotOneName=pilots[pilotPosition];
                    pilots[pilotPosition]=pilotTwoName;
                    pilots[pilotPosition+1]=pilotOneName;
                }
                break;
            case "Overtake":
                if(pilotExist){
                    let pilotTwoName=pilots[pilotPosition-1];
                    let pilotOneName=pilots[pilotPosition];
                    pilots[pilotPosition-1]=pilotOneName;
                    pilots[pilotPosition]=pilotTwoName;
                }
                break;
        }
        for (let j = pilots.min; j < pilots.length; j++) {
            if(pilots[i]===undefined){
                pilots.splice(j,0);
            }
        }

    }
    let resArr=[];
    for (let i = -300; i < pilots.length; i++) {
        if(pilots[i]!==undefined){
            resArr.push(pilots[i]);
        }
    }
    console.log(resArr.join(" ~ "));
}

f(["Vetel Hamilton Slavi",
    "Pit Hamilton",
    "Overtake Vetel",
    "Crash Slavi"]
);