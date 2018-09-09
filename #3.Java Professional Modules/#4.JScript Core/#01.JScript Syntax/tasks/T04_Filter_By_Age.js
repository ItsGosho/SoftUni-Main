function filterByMinAge(minAge,firstPersonName,firstPersonAge,secondPersonName,secondPersonAge){
    if(firstPersonAge>minAge){
          console.log("{ name: '"+firstPersonName+"', age: "+firstPersonAge+" }")
    }else if(secondPersonAge>minAge){
        console.log("{ name: '"+secondPersonName+"', age: "+secondPersonAge+" }")
    }
}

filterByMinAge(12, 'Ivan', 15, 'Asen', 9);