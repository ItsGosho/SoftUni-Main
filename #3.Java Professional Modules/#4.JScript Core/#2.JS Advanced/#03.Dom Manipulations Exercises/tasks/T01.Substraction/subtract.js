function subtract() {
    let firstNum = parseFloat(document.getElementById("firstNumber").value);
    let secondNum = parseFloat(document.getElementById("secondNumber").value);

    let resultField = document.getElementById("result");
    let sum = firstNum-secondNum;
    resultField.textContent=sum;
}
