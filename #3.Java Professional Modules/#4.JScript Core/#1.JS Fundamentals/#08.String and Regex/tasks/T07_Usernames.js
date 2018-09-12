function f(emails) {
   let resultArray=[];
    for (let i = 0; i < emails.length; i++) {
        let arr=emails[i].split(/[\\@\\.]/);
        let initials="";
        for (let j = 1; j < arr.length; j++) {
            initials+=arr[j][0];
        }
        resultArray.push(arr[0]+"."+initials);
    }
    console.log(resultArray.join(", "));
}


f(['peshoo@gmail.com', 'todor_43@mail.dir.bg', 'foo@bar.com']);