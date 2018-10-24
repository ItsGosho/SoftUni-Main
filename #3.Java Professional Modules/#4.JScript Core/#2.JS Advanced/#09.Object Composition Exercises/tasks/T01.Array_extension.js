(function arrayExtension() {
    Array.prototype.last=function () {
        return this[this.length-1];
    };
    Array.prototype.skip=function (n) {
        let newArr=[];
        for (let i = n; i < this.length; i++) {
            newArr.push(this[i]);
        }
        return newArr;
    };
    Array.prototype.take=function (n) {
        let newArr=[];
        for (let i = 0; i < n; i++) {
            newArr.push(this[i]);
        }
        return newArr;
    };
    Array.prototype.sum=function () {
        let res=0;
        for (let i = 0; i < this.length; i++) {
           res+= this[i];
        }
        return res;
    };
    Array.prototype.average=function () {
        let res=0;
        for (let i = 0; i < this.length; i++) {
            res+= this[i];
        }
        return res/this.length;
    };
})();

function f() {
     let arr = [1,2,3];
     console.log(arr.last());
}

f();