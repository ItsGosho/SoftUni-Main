//Gosho exam:
function f(arr){
    let dict=new Map();
    for (let i = 0; i < arr.length; i++) {
        let splitted=arr[i].split(/ -> /);
        let team=splitted[0];
        let racer=splitted[1];
        let points=parseInt(splitted[2]);

        if(dict.get(team)===undefined){
            dict.set(team,new Map());
            dict.get(team).set(racer,points);
        }else{
            if(dict.get(team).get(racer)===undefined){
                dict.get(team).set(racer,points);
            }else{
                dict.get(team).set(racer,dict.get(team).get(racer)+points);
            }
        }
    }
    let dictSums=new Map();
    dict.forEach((value1,key1)=>{
        let sum=0;
        dict.get(key1).forEach((value2,key2)=>{
            sum+=parseInt(value2);
        });
        dictSums.set(key1,sum);
    });
    let dictSumsSorted = new Map([...dictSums.entries()].sort((x1,x2)=>x2[1]-x1[1]));
    let count=0;
    dictSumsSorted.forEach((value1,key1)=>{
        if(count===3){
            return;
        }
        console.log(key1+": "+value1);
        let dictPlayersSorted = new Map([...dict.get(key1).entries()].sort((x1,x2)=>x2[1]-x1[1]));
        dictPlayersSorted.forEach((value2,key2)=>{
            console.log("-- "+key2+" -> "+value2);
        });
        count++;
    })
}

f([
    "Ferrari -> Kimi Raikonnen -> 25",
    "Ferrari -> Sebastian Vettel -> 18",
    "Mercedes -> Lewis Hamilton -> 10",
    "Mercedes -> Valteri Bottas -> 8",
    "Red Bull -> Max Verstapen -> 6",
    "Red Bull -> Daniel Ricciardo -> 4",
    "Mercedes -> Lewis Hamilton -> 25",
    "Mercedes -> Valteri Bottas -> 18",
    "Haas -> Romain Grosjean -> 25",
    "Haas -> Kevin Magnussen -> 25",
    ]
);