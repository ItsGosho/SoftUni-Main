function f(arr,sortCriteria) {
    class Ticket{
        constructor (destination,price,status){
            this.destination=destination;
            this.price=price;
            this.status=status;
        }
    }
    let resArr=[];
    for (let i = 0; i < arr.length; i++) {
        let splitted=arr[i].split("|");
        let ticket = new Ticket(splitted[0],parseFloat(splitted[1]),splitted[2]);
        resArr.push(ticket);
    }
    if(sortCriteria.toLowerCase()==="destination"){
        return resArr.sort((x1,x2)=>x1.destination.localeCompare(x2.destination))
    }else if(sortCriteria.toLowerCase()==="price"){
        return resArr.sort((x1,x2)=>x1.price-x2.price)
    }else if(sortCriteria.toLowerCase()==="status"){
        return resArr.sort((x1,x2)=>x1.status.localeCompare(x2.status ))
    }
}


console.log(f(['Philadelphia|94.20|available',
        'New York City|95.99|available',
        'New York City|95.99|sold',
        'Boston|126.20|departed'],
    'destination'
));
console.log("----");
console.log(f(['Philadelphia|94.20|available',
        'New York City|95.99|available',
        'New York City|95.99|sold',
        'Boston|126.20|departed'],
    'status'
));