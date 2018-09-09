function func(arr){

    // agg(arr,(a,b)=>a+b);
    // function agg(arr,func){
    //     let sum =0 ;
    //     for (let i = 0; i < arr.length; i++) {
    //        sum= func(0,arr[i]);
    //     }
    //     console.log(sum);
    // }
    let sum = 0;
    let concat="";
    arr.map(x=>sum+=x);
    arr.map(x=>concat+=x);
    console.log(sum);
    console.log(concat);
}

func([2, 4, 8, 16]);