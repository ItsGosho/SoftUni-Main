function calSumAndVat(arr){
    let inputAsArray = arr;
    let sum = 0;
    for (const inputAsArrayElement of inputAsArray) {
        sum+=inputAsArrayElement;
    }
    console.log("sum = "+sum);
    let vat = sum*0.20;
    console.log("VAT = "+vat);
    console.log("total = "+(sum+vat));
}

calSumAndVat([3.12, 5, 18, 19.24, 1953.2262, 0.001564, 1.1445]);