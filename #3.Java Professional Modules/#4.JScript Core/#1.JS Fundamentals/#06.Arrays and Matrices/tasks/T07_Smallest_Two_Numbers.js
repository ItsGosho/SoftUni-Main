function f(arr) {

    customAscGoshoSort(arr);
    function customAscGoshoSort(arr){
        while (true){
            let changeMade=false;
            for (let i = 0; i < arr.length; i++) {
                if(arr[i]>arr[i+1]){
                    let save=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=save;
                    changeMade=true;
                }
            }
            if(!changeMade){
                break;
            }
        }
    }
    console.log(arr[0]+" "+arr[1]);

}

f([3, 0, 10, 4, 7, 3]);