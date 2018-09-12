function f(arr) {
   arr.sort((x1,x2)=>{
       if(x1.length!==x2.length){
           return x2.toLowerCase().length<x1.toLowerCase().length
       }else{
           return x2.toLowerCase()<x1.toLowerCase()
       }
   });
    for (const arrElement of arr) {
        console.log(arrElement)  ;
    }
}

f([ "Isacc",
    "Theodor",
    "Jack",
    "Harrison",
    "George",

]);