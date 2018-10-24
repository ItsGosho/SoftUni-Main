function result(object) {
    let crew = Object.create(object);
    if(crew.handsShaking){
        crew.__proto__.bloodAlcoholLevel+=(0.1*crew.weight)*crew.experience;
        crew.__proto__.handsShaking=false;
    }
    return crew
}

result({ weight: 120,
    experience: 20,
    bloodAlcoholLevel: 200,
    handsShaking: true }
);

let worker = result({ weight: 80,
    experience: 1,
    bloodAlcoholLevel: 0,
    handsShaking: true }
);

console.log(worker.weight);