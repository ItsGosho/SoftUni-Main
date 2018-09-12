function f(arr) {
    let totalSum=0;
    let resPurch=[];
    for (let i = 1; i < arr.length; i+=2) {
        resPurch.push(arr[i-1]);
        totalSum+=parseFloat(arr[i]);
    }
    console.log("You purchased "+resPurch.join(", ")+" for a total sum of "+totalSum);
}

f(['Beer Zagorka', '2.65', 'Tripe soup', '7.80','Lasagna', '5.69']);