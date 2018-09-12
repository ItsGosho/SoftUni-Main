function f(matrix) {

    let sumFirstRow = 0;
    //check first row
        for (let j = 0; j < matrix[0].length; j++) {
            sumFirstRow+=matrix[0][j];
        }

    let sumLastRow = 0;
    //check first row
        for (let j = 0; j < matrix[matrix.length-1].length; j++) {
            sumLastRow+=matrix[matrix.length-1][j];
        }

    let sumLeftRow = 0;
    //check first row
    for (let j = 0; j < matrix.length; j++) {
        sumLeftRow+=matrix[j][0];
    }

    let sumRightRow = 0;
    //check first row
    for (let i = matrix.length-1; i >= 0 ; i--) {
        sumRightRow+=matrix[i][matrix.length-1];
    }
    let testArr=[sumRightRow,sumLeftRow,sumLastRow,sumFirstRow];
    let equal=true;
    for (let i = 0; i < testArr.length; i++) {
        if(testArr[0]!==testArr[i]){
            equal=false;
        }
    }
    console.log(equal);
}

f([[11, 32, 45],
    [21, 0, 1],
    [21, 1, 1]]
);