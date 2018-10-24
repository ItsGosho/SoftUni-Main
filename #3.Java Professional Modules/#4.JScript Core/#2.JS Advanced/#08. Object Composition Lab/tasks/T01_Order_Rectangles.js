function f(arr) {

    let resultArr=[];
    for (let i = 0; i < arr.length; i++) {
        resultArr[i]={
            width: arr[i][0],
            height: arr[i][1],
            area:function(){
                return this.width*this.height;
            },
            compareTo:function (otherRectangle) {
                let result = otherRectangle.area() - this.area();
                return result || (otherRectangle.width - this.width);
            },

        };
    }
    resultArr.sort((x1,x2)=>x1.compareTo(x2));
    console.log(resultArr);
}


f([[10,5], [3,20], [5,12]]);
f([[10,5],[5,12]]);