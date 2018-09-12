//Gosho exam:
function f(arr) {
    let pattern = RegExp(/^([!@#$?\w]+)(=)([0-9]+)(--)([0-9]+)(<<)(\w+)$/);
    arr.splice(arr.length - 1, 1);

    let dict=new Map();

    for (let i = 0; i < arr.length; i++) {
        let match = pattern.exec(arr[i]);
        if (match) {
            let geneName = match[1];
            let neededLength = parseInt(match[3]);
            let geneCount = parseInt(match[5]);
            let organism = match[7];
            let resultName = "";
            for (let j = 0; j < geneName.length; j++) {
                if (geneName[j] !== "!" && geneName[j] !== "@"
                    && geneName[j] !== "#"
                    && geneName[j] !== "$"
                    && geneName[j] !== "?") {
                    resultName += geneName[j];
                }
            }
            if (resultName.length === neededLength) {
                if(dict.get(organism)!==undefined){
                    dict.set(organism,dict.get(organism)+geneCount);
                }else{
                    dict.set(organism,geneCount);
                }
            }
        }
    }
    let dictSorted = new Map([...dict.entries()].sort((x1,x2)=>x2[1]-x1[1]));
    for (const [key,value] of dictSorted) {
       console.log(key+" has genome size of "+value);
    }
}

f(["!@ab?si?di!a@=7--152<<human",
    "b!etu?la@=6--321<<dog",
    "!curtob@acter##ium$=14--230<<dog",
    "!some@thin@g##=9<<human",
    "Stop!",]
);