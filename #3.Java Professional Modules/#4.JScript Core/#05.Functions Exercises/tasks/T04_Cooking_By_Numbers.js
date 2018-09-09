function cook(arr){
   let num = arr[0];
    for (let i = 1; i < arr.length; i++) {
        switch (arr[i]) {
            case "chop":
                num=num/2;
                console.log(num);
                break;
            case "dice":
                num=Math.sqrt(num);
                console.log(num);
                break;
            case "spice":
                num++;
                console.log(num);
                break;
            case "bake":
                num*=3;
                console.log(num);
                break;
            case "fillet":
                num-=num*0.20;
                console.log(num);
                break;
        }
    }
}

cook([9, "dice", "spice", "chop", "bake", "fillet"]);