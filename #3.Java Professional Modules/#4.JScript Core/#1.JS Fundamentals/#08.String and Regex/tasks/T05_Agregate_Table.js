function f(arr) {
    let totalSum=0;
    let towns=[];
    for (let i = 0; i < arr.length; i++) {
         let splitted=arr[i].split(" ").filter(x=>x!=="");
         let townName="";
        for (let j = 1; j < splitted.length-2; j++) {
          townName+=splitted[j]+" ";
        }
        towns.push(townName.trim());
         totalSum+=parseInt(splitted[splitted.length-1]);
    }
    console.log(towns.join(", "));
    console.log(totalSum);
}

f(['| Sofia           | 300',
    '| Veliko Tarnovo  | 500',
    '| Yambol          | 275']
);