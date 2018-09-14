//Gosho exam:
function f(lostFightsCount, helmetPrice, swordPrice, shieldPrice, armorPrice) {
   let totalTimesHelmetBroken=0;
   let totalTimesSwordBroken=0;
   let totalTimesShieldBroken=0;
   let totalTimesArmorBroken=0;


    for (let i = 1; i < lostFightsCount+1; i++) {
        if(i%2===0){
            totalTimesHelmetBroken++;

        }
        if(i%3===0){
            totalTimesSwordBroken++;

        }
        if(i%3===0 && i%2===0){
            totalTimesShieldBroken++;
            if(totalTimesShieldBroken%2===0){
                totalTimesArmorBroken++;
            }
        }
    }

    let sum=(helmetPrice*totalTimesHelmetBroken)+(swordPrice*totalTimesSwordBroken)+(totalTimesShieldBroken*shieldPrice)+(armorPrice*totalTimesArmorBroken);
   console.log("Gladiator expenses: "+sum.toFixed(2)+" aureus")
}

f(  23,
    12.50,
    21.50,
    40,
    200,
);