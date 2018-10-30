class Stringer{
    constructor (string,length){
        this.modifiedString=string;
        this.innerString=string;
        this.innerLength=length;
    }
    decrease(n){
        if(n<0){
            n=0;
        }
        this.modifiedString=this.modifiedString.substring(0,this.innerLength-n);
        if(this.modifiedString.length!==this.innerString.length){
            this.modifiedString+="...";
        }
        this.innerLength-=n;
    }
    increase(n){
        if(n<0){
            n=0;
        }
        this.modifiedString=this.innerString.substring(0,n);
        this.innerLength+=n;
    }

    toString(){
        return this.modifiedString
    }
}


let test = new Stringer("Test", 5);
console.log(test.toString()); //Test

test.decrease(3);
console.log(test.toString()); //Te...

test.decrease(5);
console.log(test.toString()); //...

test.increase(4);
console.log(test.toString()); //Test
