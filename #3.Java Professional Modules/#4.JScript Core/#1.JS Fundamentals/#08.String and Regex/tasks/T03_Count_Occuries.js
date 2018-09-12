function f(word, text) {
    let currIndex = 0;
    let res = 0;
    for (const textElement of text) {
        let get = "";
        let up = currIndex;
        for (let i = 0; i < word.length; i++) {
            get += text[up];
            up++;
        }
        up = currIndex;
        if (get === word) {
            res++;
        }
        currIndex++;
    }
    console.log(res);
}

f('the', 'The quick brown fox jumps over the lay dog.');