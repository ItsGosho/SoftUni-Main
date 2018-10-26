function printDeckOfCards(cards) {
    function makeCard(face,suit) {
        let cardFaces = [2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K', 'A'];
        let cardsuits = {
            S: '\u2660',
            H: '\u2665',
            D: '\u2666',
            C: '\u2663'
        };

        let asd = face+suit;
        if(cardFaces.findIndex(x=>x==face)<0){
            throw Error("Invalid card: "+asd);
        }

        if(!cardsuits.hasOwnProperty(suit)){
            throw Error("Invalid card: "+asd);
        }
        let res = face+cardsuits[suit];

        let object = {
            toString:function () {
                return res;
            }
        };

        return object;
    }

    let cardsRes=[];
    for (let i = 0; i < cards.length; i++) {
        let suit = cards[i].substring(cards[i].length-1);
        let face = cards[i].substring(0,cards[i].length-1);
        cardsRes.push(makeCard(face,suit));
    }
    let prArr=[];
    for (let i = 0; i < cardsRes.length; i++) {
        prArr.push(cardsRes[i].toString());
    }
    console.log(prArr.join(" "));
}


printDeckOfCards(['AS', '10D', 'KH', '2C']);
printDeckOfCards(['5S', '3D', 'QD', '1C']);

