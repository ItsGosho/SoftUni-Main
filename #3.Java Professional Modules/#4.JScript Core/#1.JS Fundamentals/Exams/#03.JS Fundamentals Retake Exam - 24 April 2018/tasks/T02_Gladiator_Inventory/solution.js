//Gosho exam:
function f(log) {
    let equpments = log[0].split(/ /);
    let arr = [];
    for (let i = 1; i < log.length - 1; i++) {
        arr.push(log[i]);
    }
    for (let i = 0; i < arr.length; i++) {
        let splitted=arr[i].split(/ /);
        let command=splitted[0];
        let item=splitted[1];

        let itemExist=false;
        let itemPosition=0;

        switch (command) {
            case "Buy":
                for (let j = 0; j < equpments.length; j++) {
                    if(equpments[j]===item){
                        itemExist=true;
                        itemPosition=j;
                        break;
                    }
                }
                if(!itemExist){
                    equpments.push(item);
                }
                break;
            case "Trash":
                for (let j = 0; j < equpments.length; j++) {
                    if(equpments[j]===item){
                        itemExist=true;
                        itemPosition=j;
                        break;
                    }
                }
                if(itemExist){
                    equpments[itemPosition]=undefined;
                }
                break;
            case "Repair":
                for (let j = 0; j < equpments.length; j++) {
                    if(equpments[j]===item){
                        itemExist=true;
                        itemPosition=j;
                        break;
                    }
                }
                if(itemExist){
                    equpments.push(equpments[itemPosition]);
                    equpments[itemPosition]=undefined;
                }
                break;
            case "Upgrade":
                let splitted2=item.split(/-/);
                item=splitted2[0];
                let enchant=splitted2[1];
                for (let j = 0; j < equpments.length; j++) {
                    if(equpments[j]===item){
                        itemExist=true;
                        itemPosition=j;
                        break;
                    }
                }
                if(itemExist){
                    let resArr=[];
                    for (let j = 0; j <= itemPosition; j++) {
                        resArr.push(equpments[j]);
                    }
                    resArr.push(item+":"+enchant);
                    for (let j = itemPosition+1; j < equpments.length; j++) {
                        resArr.push(equpments[j]);
                    }
                   equpments=resArr;
                }
                break;
        }
        for (let j = 0; j < equpments.length; j++) {
            if(equpments[j]===undefined){
                equpments.splice(j,1);
            }
        }
    }
    console.log(equpments.join(" "));
}

f(["SWORD Shield Spear",
    "Buy Bag",
    "Trash Shield",
    "Repair Spear",
    "Upgrade SWORD-Steel",
    "Fight!",
]);