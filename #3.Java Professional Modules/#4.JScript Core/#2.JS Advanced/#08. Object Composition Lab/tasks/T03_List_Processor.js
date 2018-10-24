function f(arr) {
    function commandProcessor() {
        let arr=[];
        function add(string) {arr.push(string);}
        function remove(string){
            for (let i = 0; i < arr.length; i++) {
                if(arr[i]===string){
                    delete arr[i];
                }
            }}
        function print(){
            console.log(arr.filter(x=>x!=="").join(","));}

        return{add,remove,print}
    }
    let cp = commandProcessor();
    for (let i = 0; i < arr.length; i++) {
        let spl=arr[i].split(' ');
        switch (spl[0]) {
            case "add":
                cp.add(spl[1]);
                break;
            case "remove":
                cp.remove(spl[1]);
                break;
            case "print":
                cp.print();
                break;
        }
    }
}

f(['add pesho', 'add gosho', 'add pesho', 'remove pesho','print']);