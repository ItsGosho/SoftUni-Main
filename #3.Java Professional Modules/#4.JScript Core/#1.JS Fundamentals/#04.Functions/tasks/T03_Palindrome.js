function palindrome(word){
   let text="";
    for (let i = word.length-1; i >=0; i--) {
        text+=word[i];
    }
    if(word===text){
        console.log(true);
    }else{
        console.log(false);
    }
}

palindrome("racecar1");