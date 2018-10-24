function f(arr) {
    function commandProcessor() {
          let car = {
              color:null,
              model:null
          };
          let cars = new Map();
          function create(name) {
              let createdCar = Object.create(car);
              cars.set(name,createdCar);
          }
          function createInh(name,parent) {
              let createdCar = Object.create(cars.get(parent));
              cars.set(name,createdCar);
          }
          function print(name) {
                  let res=[];
                  let obj = cars.get(name);

                  if(obj.model!==null){
                      res.push("model:"+obj.model)
                  }
                  if(obj.color!==null){
                      res.push("color:"+obj.color)
                  }
                  console.log(res.join(", "));
          }
          function set(name,type,value) {
             switch (type) {
                 case "color":
                     cars.get(name).color=value;
                     break;
                 case "model":
                     cars.get(name).model=value;
                     break;
             }
          }
          return {create,print,set,createInh}
    }
    let cp = commandProcessor();
    for (let i = 0; i < arr.length; i++) {
        let spl=arr[i].split(' ');
        if(spl[0]==='create' && spl[2]==='inherit'){
            cp.createInh(spl[1],spl[3]);
        }else if(spl[0]==='create'){
            cp.create(spl[1])
        }else if(spl[0]==='set'){
            cp.set(spl[1],spl[2],spl[3]);
        }else if(spl[0]==='print'){
            cp.print(spl[1]);
        }
    }
}


f(['create c1',
    'create c2 inherit c1',
    'set c1 color red',
    'set c2 model new',
    'print c1',
    'print c2']
);