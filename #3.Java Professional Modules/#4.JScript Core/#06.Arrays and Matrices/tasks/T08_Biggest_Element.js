function f(matrix) {
        let count=0;
        for (let i = 0; i < matrix.length; i++) {
            for (let j = 0; j < matrix[i].length; j++) {
                try{
                        if(matrix[i][j]===matrix[i+1][j] &&
                            matrix[i][j]!==undefined && matrix[i+1][j]!==undefined){
                            matrix[i][j]=undefined;
                            matrix[i+1][j]=undefined;
                            count++;
                        }
                        if(matrix[i][j]===matrix[i-1][j] &&
                            matrix[i][j]!==undefined && matrix[i-1][j]!==undefined){
                            matrix[i][j]=undefined;
                            matrix[i-1][j]=undefined;
                            count++;
                        }
                        if(matrix[i][j]===matrix[i][j+1] &&
                            matrix[i][j]!==undefined && matrix[i][j+1]!==undefined){
                            matrix[i][j]=undefined;
                            matrix[i][j+1]=undefined;
                            count++;
                        }
                        if(matrix[i][j]===matrix[i][j-1] &&
                            matrix[i][j]!==undefined && matrix[i][j-1]!==undefined){
                            matrix[i][j]=undefined;
                            matrix[i][j-1]=undefined;
                            count++;
                        }
                }catch (e) {

                }
            }
        }
        console.log(count);
}

f([['2', '3', '4', '7', '0'],
    ['4', '0', '5', '3', '4'],
    ['2', '3', '5', '4', '2'],
    ['9', '8', '7', '5', '4']]

);