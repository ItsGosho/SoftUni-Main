function makeCard(face,suit) {
    let cardFaces = [2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K', 'A'];
    let cardsuits = {
        S: '\u2660',
        H: '\u2665',
        D: '\u2666',
        C: '\u2663'
    };

    if(cardFaces.findIndex(x=>x==face)<0){
        throw Error("kk");
    }

    if(!cardsuits.hasOwnProperty(suit)){
        throw Error();
    }
    let res = face+cardsuits[suit];

    let object = {
        toString:function () {
            return res;
        }
    };

    return object;
}

console.log('' + makeCard('A', 'S'));
console.log('' + makeCard('10', 'H'));
console.log('' + makeCard('1', 'C'));
