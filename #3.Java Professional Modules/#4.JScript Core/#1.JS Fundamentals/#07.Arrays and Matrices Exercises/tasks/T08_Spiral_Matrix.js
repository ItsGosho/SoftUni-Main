function f(col,row) {

    let matrica=[[]];
    let change=false;
    for (let i = 0; i < col; i++) {
        matrica[i]=new Array(row);
        for (let j = 0; j < row; j++) {
            matrica[i][j]=0;
        }
    }
    let centerCol=parseInt(col/2);
    let centerRow=parseInt(row/2);

    let positionCol=0;
    let positionRow=0;

    let init=1;

    let timeToGoRight=true;
    let timeToGoDown=false;
    let timeToGoLeft=false;
    let timeToGoUp=false;

    let currentMaxRight=row;
    let currentMaxDown=col;
    let currentMaxLeft=-1;
    let currentMaxUp=0;

    while (true) {

        if(timeToGoRight){
            matrica[positionCol][positionRow]=init;
            positionRow++;
            init++;
            printMatrix(matrica);
            if(positionRow===currentMaxRight){
                timeToGoRight=false;
                timeToGoDown=true;
                positionCol++;
                positionRow--;
            }
        }
        if(timeToGoDown){
            matrica[positionCol][positionRow]=init;
            positionCol++;
            init++;
            printMatrix(matrica);
            if(positionCol===currentMaxDown){
                timeToGoDown=false;
                timeToGoLeft=true;
                positionCol--;
                positionRow--;
            }
        }

        if(timeToGoLeft){
            matrica[positionCol][positionRow]=init;
            positionRow--;
            init++;
            printMatrix(matrica);
            if(positionRow===currentMaxLeft){
                timeToGoLeft=false;
                timeToGoUp=true;
                positionCol--;
                positionRow++;
            }
        }

        if(timeToGoUp){
            matrica[positionCol][positionRow]=init;
            positionCol--;
            init++;
            printMatrix(matrica);
            if(positionCol===currentMaxUp){
                timeToGoUp=false;
                timeToGoRight=true;
                positionRow++;
                positionCol++;

                //--
                currentMaxLeft--;
                currentMaxDown--;
                currentMaxUp--;
                currentMaxRight--;
            }
        }
    }

    //printMatrix(matrica);
    function printMatrix(matrix) {
        let res="";
        for (let i = 0; i < matrix.length; i++) {
            for (let j = 0; j < matrix[i].length; j++) {
                res+=matrix[i][j]+" ";
            }
            res+="\n";
        }
        console.log(res);
    }
    console.log("");
}

f(5,5);