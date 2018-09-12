function letterCounter(word,symbol){
    let count = 0;
    for (const wordElement of word) {
        if(wordElement===symbol){
            count++;
        }
    }
    console.log(count);
}

letterCounter('hello', 'l')