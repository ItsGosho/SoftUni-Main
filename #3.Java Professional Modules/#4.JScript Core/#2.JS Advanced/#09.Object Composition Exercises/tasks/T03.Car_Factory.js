function result(object) {
    let resObj={};
    let eng={};
   if(object.power<=90){
      eng = {
          power: 90,
          volume: 1800
      };
      resObj.model=object.model;
      resObj.engine=eng;


   }else if(object.power<=120){
       eng = {
           power: 120,
           volume: 2400
       };
       resObj.model=object.model;
       resObj.engine=eng;
   }else if(object.power<=200){
       eng = {
           power: 200,
           volume: 3500
       };
       resObj.model=object.model;
       resObj.engine=eng;
   }
   let carr = {type:object.carriage,color:object.color};
   resObj.carriage=carr;
   if(object.wheelsize%2===0){
       object.wheelsize=object.wheelsize-1;
   }
   let ps=[];
    for (let i = 0; i < 4; i++) {
        ps.push(object.wheelsize);
    }
    resObj.wheels=ps;
    return resObj;
}

result({ model: 'VW Golf II',
    power: 90,
    color: 'blue',
    carriage: 'hatchback',
    wheelsize: 14 }
);