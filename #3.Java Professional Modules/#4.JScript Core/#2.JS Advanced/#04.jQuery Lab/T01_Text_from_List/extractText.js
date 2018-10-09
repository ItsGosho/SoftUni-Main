function extractText() {

    let res = $('#items li');
    let result = [];
    for (let i = 0; i < res.length; i++) {
      result[i]=res[i].textContent;
    }
    $('#result').text(result.join(", "));
}
