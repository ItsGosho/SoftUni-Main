class Rat{

    constructor (name){
        this.name=name;
        this.otherRats = [];
    }

    toString(){
        let otherRats = [];
        otherRats.push(this.name);
        for (let i = 0; i < this.otherRats.length; i++) {
            otherRats.push("##"+this.otherRats[i].name)
        }
        return otherRats.join('\n');
    }

    unite(object){
        if (object instanceof Rat) {
            this.otherRats.push(object);
        }
    }

    getRats(){
        return this.otherRats;
    }
}

let test = new Rat("Pesho");
console.log(test.toString()); //Pesho

console.log(test.getRats()); //[]

test.unite(new Rat("Gosho"));
test.unite(new Rat("Sasho"));
test.unite("asd");
console.log(test.getRats());
//[ Rat { name: 'Gosho', unitedRats: [] },
//  Rat { name: 'Sasho', unitedRats: [] } ]

console.log(test.toString());
// Pesho
// ##Gosho
// ##Sasho
