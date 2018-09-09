function nextDay(year,month,day){
    let next = new Date(year,month,day+1);
    console.log(next.getFullYear()+"-"+next.getMonth()+"-"+next.getDate());
}

nextDay(2016, 9, 30);