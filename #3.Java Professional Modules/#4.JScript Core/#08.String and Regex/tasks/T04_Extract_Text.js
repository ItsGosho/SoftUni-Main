function f(text) {
 let resArr=[];
 let word="";
 let isItTime=false;
    for (let i = 0; i < text.length; i++) {
        if(text[i]===")"){
            isItTime=false;
            if(word.length>=1) {
                resArr.push(word);
            }
            word="";
        }
        if(isItTime){
            word+=text[i];
        }
        if(text[i]==="("){
            isItTime=true;
        }
    }
    console.log(resArr.join(", "))
}

f('()Rakiya (Bulgarian brandy) is self-made liquor (alcoholic drink)');