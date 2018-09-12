function concat(word){

    let splitted=word.split(/\W+/);
    let resArr=[];
    let i=0;
    for (const wordElement of splitted) {
        if(wordElement!==""){
            resArr[i]=wordElement.toUpperCase();
            i++;
        }
    }
    console.log(resArr.join(", "));
}

concat("Hi, how are you?");