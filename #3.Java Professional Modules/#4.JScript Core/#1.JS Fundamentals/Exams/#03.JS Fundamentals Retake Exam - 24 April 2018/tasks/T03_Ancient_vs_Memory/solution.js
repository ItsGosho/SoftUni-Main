function f(words) {
    let arrWords = words;

    let neededLengthByOrder = [];
    let wordsByOrder = [];
    for (let i = 0; i < arrWords.length; i++) {
        let splitted = arrWords[i].split(/ /);

        let gotNeedLength = false;
        let neededLength = 0;
        let str = "";
        let rdyForBefore=false;
        for (let j = 0; j < splitted.length; j++) {
            if(splitted[j]==="32763"){
                rdyForBefore=true;
                j++;
            }
            if(rdyForBefore){
                if (splitted[j] === "0" && splitted[j + 1] !== "0" && splitted[j+2]==="0") {
                    if (!gotNeedLength) {
                        neededLength = parseInt(splitted[j + 1]);
                        j+=3;
                        neededLengthByOrder.push(neededLength);
                        gotNeedLength = true;
                    }
                }
                if (splitted[j] !== "0" && splitted[j] !== neededLength.toString()) {
                    str += splitted[j] + " ";
                }else{
                    break;
                }
            }
        }
        wordsByOrder.push(str);
    }
    for (let i = 0; i < wordsByOrder.length; i++) {
        if(wordsByOrder[i].split(/ /).filter(x=>x!=="").length === neededLengthByOrder[i]){
            let sigurnost=wordsByOrder[i].split(/ /).filter(x=>x!=="");
            let res="";
            for (let j = 0; j < sigurnost.length; j++) {
                res+=String.fromCharCode(parseInt(sigurnost[j]));
            }
            console.log(res);
        }
    }
}

f(["32656 19759 32763 0 8 0 86 101 114 111 110 105 107 97 0 0 0 0 0 0 0 0 1"]);