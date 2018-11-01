class Joro{
    constructor() {

    }

    toString(){
        return "ASd"
    }
}

function extendClass(classToExtend) {
    classToExtend.prototype.species="Human";
    classToExtend.prototype.toSpeciesString=function () {
        return `I am a ${this.species}. ${this.toString()}`;
    }
}
extendClass(Joro);
let j = new Joro();
console.log(j.toSpeciesString());