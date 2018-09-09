function parseAndPrint(numberAsString){
      let num = parseInt(numberAsString);
      let res = "";
    for (let i = 1; i <= num; i++) {
        res+=i;
    }
    console.log(res);
}

parseAndPrint("11");