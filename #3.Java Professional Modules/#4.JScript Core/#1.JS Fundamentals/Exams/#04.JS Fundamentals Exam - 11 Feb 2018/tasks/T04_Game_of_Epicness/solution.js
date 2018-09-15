//Gosho exam:
function f(kingdoms,fights){
    let dict=new Map();
    for (let i = 0; i < kingdoms.length ; i++) {
        let king=kingdoms[i];
        if(dict.get(king.kingdom)!==undefined){
            dict.get(king.kingdom).set(king.general,king.army);
        }else{
            dict.set(king.kingdom,new Map());
            dict.get(king.kingdom).set(king.general,king.army);
        }
    }
    let dictKingdomGeneralWins=new Map();
    for (let i = 0; i < fights.length; i++) {
        let attackingKingdom=fights[i][0];
        let attackingGeneral=fights[i][1];
        let defendingKingdom=fights[i][2];
        let defendingGeneral=fights[i][3];
        if(attackingKingdom.toLowerCase()!==defendingKingdom.toLowerCase()){
            if(dict.get(attackingKingdom).get(attackingGeneral)>dict.get(defendingKingdom).get(defendingGeneral)){
                dict.get(attackingKingdom)
                    .set(attackingGeneral,Math.floor(dict.get(attackingKingdom).get(attackingGeneral)*1.10));
                dict.get(defendingKingdom)
                    .set(defendingGeneral,Math.floor(dict.get(defendingKingdom).get(defendingGeneral)*0.90));

                //WIN
                if(dictKingdomGeneralWins.get(attackingKingdom)!==undefined){
                    if(dictKingdomGeneralWins.get(attackingKingdom).get(attackingGeneral)===undefined){
                        dictKingdomGeneralWins.get(attackingKingdom).set(attackingGeneral,[1,0]);
                    }else{
                        dictKingdomGeneralWins.get(attackingKingdom)
                            .set(attackingGeneral,[dictKingdomGeneralWins.get(attackingKingdom).get(attackingGeneral)[0]+1,dictKingdomGeneralWins.get(attackingKingdom).get(attackingGeneral)[1]]);
                    }
                }else{
                    dictKingdomGeneralWins.set(attackingKingdom,new Map());
                    dictKingdomGeneralWins.get(attackingKingdom).set(attackingGeneral,[1,0]);
                }
                //LOSE
                if(dictKingdomGeneralWins.get(defendingKingdom)!==undefined){
                    if(dictKingdomGeneralWins.get(defendingKingdom).get(defendingGeneral)===undefined){
                        dictKingdomGeneralWins.get(defendingKingdom).set(defendingGeneral,[0,1]);
                    }else{
                        dictKingdomGeneralWins.get(defendingKingdom)
                            .set(defendingGeneral,[dictKingdomGeneralWins.get(defendingKingdom).get(defendingGeneral)[0],dictKingdomGeneralWins.get(defendingKingdom).get(defendingGeneral)[1]+1]);
                    }
                }else{
                    dictKingdomGeneralWins.set(defendingKingdom,new Map());
                    dictKingdomGeneralWins.get(defendingKingdom).set(defendingGeneral,[0,1]);
                }


            }else if(dict.get(attackingKingdom).get(attackingGeneral)<dict.get(defendingKingdom).get(defendingGeneral)){
                dict.get(defendingKingdom)
                    .set(defendingGeneral,Math.floor(dict.get(defendingKingdom).get(defendingGeneral)*1.10));
                dict.get(attackingKingdom)
                    .set(attackingGeneral,Math.floor(dict.get(attackingKingdom).get(attackingGeneral)*0.90));
                //WIN
                if(dictKingdomGeneralWins.get(defendingKingdom)!==undefined){
                    if(dictKingdomGeneralWins.get(defendingKingdom).get(defendingGeneral)===undefined){
                        dictKingdomGeneralWins.get(defendingKingdom).set(defendingGeneral,[1,0]);
                    }else{
                        dictKingdomGeneralWins.get(defendingKingdom)
                            .set(defendingGeneral,[dictKingdomGeneralWins.get(defendingKingdom).get(defendingGeneral)[0]+1,dictKingdomGeneralWins.get(defendingKingdom).get(defendingGeneral)[1]]);
                    }
                }else{
                    dictKingdomGeneralWins.set(defendingKingdom,new Map());
                    dictKingdomGeneralWins.get(defendingKingdom).set(defendingGeneral,[1,0]);
                }

                //LOSE
                if(dictKingdomGeneralWins.get(attackingKingdom)!==undefined){
                    if(dictKingdomGeneralWins.get(attackingKingdom).get(attackingGeneral)===undefined){
                        dictKingdomGeneralWins.get(attackingKingdom).set(attackingGeneral,[0,1]);
                    }else{
                        dictKingdomGeneralWins.get(attackingKingdom)
                            .set(attackingGeneral,[dictKingdomGeneralWins.get(attackingKingdom).get(attackingGeneral)[0],dictKingdomGeneralWins.get(attackingKingdom).get(attackingGeneral)[1]+1]);
                    }
                }else{
                    dictKingdomGeneralWins.set(attackingKingdom,new Map());
                    dictKingdomGeneralWins.get(attackingKingdom).set(attackingGeneral,[0,1]);
                }
            }
        }
    }


    let dictTotalWinsAndLoses = new Map();

    dictKingdomGeneralWins.forEach((value, key) => {
        let totalWins=0;
        let totalLoses=0;
        dictKingdomGeneralWins.get(key).forEach((value,key) => {
            totalWins+=value[0];
            totalLoses+=value[1];
        });
        dictTotalWinsAndLoses.set(key,[totalWins,totalLoses]);
    });

    let dictResult = new Map([...dictTotalWinsAndLoses.entries()].sort((x1, x2) => {

        if(x1[1][0]===x2[1][0]){
            return x1[1][1]>x2[1][1];
        }
        if(x1[1][1]===x2[1][1]){
            return x1[0]<x2[0];
        }
        return x1[1][0]<x2[1][0];
    }));
    let iter=0;
    dictResult.forEach((value, key) => {
        if(iter===0){
            console.log("Winner: "+key);

            let name=key;

            let dictGeneralsSorted = new Map([...dict.get(key).entries()].sort((x1,x2)=>{
                return x1[1]<x2[1];
            }));

            dictGeneralsSorted.forEach((value, key) => {
                console.log("/\\general: "+key);
                console.log("---army: "+value);

                let wins=0;
                let loses=0;

                if(dictKingdomGeneralWins.get(name).get(key)!==undefined){
                    wins=dictKingdomGeneralWins.get(name).get(key)[0];
                }
                if(dictKingdomGeneralWins.get(name).get(key)!==undefined){
                    loses=dictKingdomGeneralWins.get(name).get(key)[1];
                }
                console.log("---wins: "+wins);
                console.log("---losses: "+loses);
            });
        }else{
            return;
        }
        iter++;
    });
}

f([ { kingdom: "Maiden Way", general: "Merek", army: 5000 },
        { kingdom: "Stonegate", general: "Ulric", army: 4900 },
        { kingdom: "Stonegate", general: "Doran", army: 70000 },
        { kingdom: "YorkenShire", general: "Quinn", army: 0 },
        { kingdom: "YorkenShire", general: "Quinn", army: 2000 },
        { kingdom: "Maiden Way", general: "Berinon", army: 100000 } ],
    [ ["YorkenShire", "Quinn", "Stonegate", "Ulric"],
        ["Stonegate", "Ulric", "Stonegate", "Doran"],
        ["Stonegate", "Doran", "Maiden Way", "Merek"],
        ["Stonegate", "Ulric", "Maiden Way", "Merek"],
        ["Maiden Way", "Berinon", "Stonegate", "Ulric"] ]
);