//Gosho exam:
function f(arr) {
    let dict = new Map();

    for (let i = 0; i < arr.length - 1; i++) {
        let splitted = arr[i].split(/ -> /);
        let splittedDuel = arr[i].split(/ vs /);
        let name = splitted[0];
        let special = splitted[1];
        let amount = parseInt(splitted[2]);

        if (splittedDuel.length <= 1) {
            if (dict.get(name) !== undefined) {

                if (dict.get(name).get(special) !== undefined) {
                    if (dict.get(name).get(special) < amount) {
                        dict.get(name).set(special, amount);
                    }
                } else {
                    dict.get(name).set(special, amount);
                }
            } else {
                dict.set(name, new Map());
                dict.get(name).set(special, amount);
            }
        } else {
            if (dict.get(splittedDuel[0]) !== undefined &&
                dict.get(splittedDuel[1]) !== undefined) {
                let firstTech = [];
                dict.get(splittedDuel[0]).forEach((value, key) => {
                    firstTech.push(key);
                });
                let secondTech = [];
                dict.get(splittedDuel[1]).forEach((value, key) => {
                    secondTech.push(key);
                });
                let common=[];
               if(firstTech.length>secondTech.length){
                   for (let j = 0; j < firstTech.length; j++) {
                       for (let k = 0; k < secondTech.length; k++) {
                           if(firstTech[j]===secondTech[k]){
                               if(firstTech[j]!==undefined &&
                                   secondTech[k]!==undefined){
                                   common.push(firstTech[j]);
                               }
                           }
                       }
                   }
               }else{
                   for (let j = 0; j < secondTech.length; j++) {
                       for (let k = 0; k < firstTech.length; k++) {
                           if(firstTech[k]===secondTech[j]){
                               if(firstTech[k]!==undefined &&
                                   secondTech[j]!==undefined){
                                   common.push(firstTech[k]);
                               }
                           }
                       }
                   }
               }
              if(common.length>=1) {
                  let sumFirst = 0;
                  let sumSecond = 0;
                  dict.get(splittedDuel[0]).forEach(((value, key) => {
                      for (let j = 0; j < common.length; j++) {
                          if (key === common[j]) {
                              sumFirst += parseInt(value);
                          }
                      }
                  }));
                  dict.get(splittedDuel[1]).forEach(((value, key) => {
                      for (let j = 0; j < common.length; j++) {
                          if (key === common[j]) {
                              sumSecond += parseInt(value);
                          }
                      }
                  }));
                  if (sumFirst > sumSecond) {
                      dict.delete(splittedDuel[1]);
                  } else {
                      dict.delete(splittedDuel[0]);
                  }
              }
            }
        }
    }
    let dictWithSums = new Map();
    dict.forEach((value, key) => {
        let sum = 0;
        dict.get(key).forEach((value, key) => {
            sum += parseInt(value);
        });
        dictWithSums.set(key, sum);
    });
    let dictKeysSorted = new Map([...dictWithSums.entries()].sort((x1, x2) => {
        if (x1[1] === x2[1]) {
            return x1[0] > x2[0];
        }
        return x1[1] < x2[1];
    }));
    dictKeysSorted.forEach((value, key) => {
        console.log(key + ": " + value + " skill");
        let dictInterSorted = new Map([...dict.get(key).entries()].sort((x1, x2) => {
            if (x1[1] === x2[1]) {
                return x1[0] < x2[0];
            }
            return x1[1] < x2[1];
        }));
        dictInterSorted.forEach((value, key) => {
            console.log("- " + key + " <!> " + value);
        });
    });
}

f([
    "Pesho -> Duck -> 400",
    "Julius -> Shield -> 150",
    "Gladius -> Heal -> 200",
    "Gladius -> Support -> 250",
    "Gladius -> Shield -> 250",
    "Pesho vs Gladius",
    "Gladius vs Julius",
    "Gladius vs Gosho",
    "Ave Cesar",
]);