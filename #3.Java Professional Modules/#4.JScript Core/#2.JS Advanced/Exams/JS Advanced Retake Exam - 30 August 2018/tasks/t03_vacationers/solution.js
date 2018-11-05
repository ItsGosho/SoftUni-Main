class Vacationer{
    constructor(fullName,creditCard){
        this.fullName = fullName;
        this._idNumber = this.generateIDNumber();
        this.creditCard = creditCard;
        this._wishList = [];
        this._fullName = fullName;
        this.creditCard = creditCard;
    }


    get wishList() {
        return this._wishList;
    }

    set wishList(value) {
        this._wishList = value;
    }

    get fullName() {
        return this._fullName;
    }

    set fullName(object) {
        if(object.length !==3){
            throw new TypeError("Name must include first name, middle name and last name");
        }
        if(typeof object[0] !== "string" || typeof object[1] !== "string" || typeof object[2] !== "string"){
            throw new TypeError();
        }
        let nameToTest = object.join(" ")+" ";
        let patt = new RegExp('^([A-Z]{1}[a-z]+\\s+)+$');
        let match = patt.exec(nameToTest);
        if(!match){
            throw new TypeError("Invalid full name");
        }
        this._fullName = {
            firstName: object[0],
            middleName: object[1],
            lastName: object[2]
        };
    }

    get creditCard() {
        return this._creditCard;
    }

    set creditCard(object) {
        if(object === undefined){
            this._creditCard = {
                cardNumber:1111,
                expirationDate:"",
                securityNumber:111
            }
        }else{
            if(typeof object[0] !== "number" || typeof object[1] !== "string" || typeof object[2] !== "number"){
                throw new TypeError();
            }
            this._creditCard = {
                cardNumber:  object[0],
                expirationDate: object[1],
                securityNumber: object[2]
            };
        }
    }

    get idNumber() {
        return this._idNumber;
    }

    generateIDNumber(){
        let calc = 231*this.fullName.firstName.charCodeAt(0)+139*this.fullName.middleName.length;
        let addLast = "";
        if(this.fullName.lastName.endsWith("a") ||
            this.fullName.lastName.endsWith("e") ||
            this.fullName.lastName.endsWith("o") ||
            this.fullName.lastName.endsWith("i") ||
            this.fullName.lastName.endsWith("u")){
            calc+="8";
        }else{
            calc+="7";
        }
        return calc;
    }

    addCreditCardInfo(input){
        if(input.length !==3){
             throw new TypeError("Missing credit card information");
        }
        if(typeof input[0] !== Number || typeof input[2] !== Number){
            throw new TypeError("Invalid credit card details");
        }
    }

    addDestinationToWishList(destination){
        if(this.wishList.includes(destination)){
            throw new TypeError("Destination already exists in wishlist");
        }
        this.wishList.push(destination);
        this.wishList = this.wishList.sort((x1,x2)=>x1.length - x2.length)
    }

    getVacationerInfo(){
        let wlResult = "";
        if(this.wishList.length>1){
            wlResult=this.wishList.join(", ");
        }else{
            wlResult="empty";
        }
        return `Name: ${this.fullName[0]} ${this.fullName[1]} ${this.fullName[2]}\nID Number: ${this.idNumber}\nWishlist:\n${wlResult}\nCredit Card:\nCard Number: ${this.creditCard.cardNumber}\nExpiration Date: ${this.creditCard.expirationDate}\nSecurity Number: ${this.creditCard.securityNumber}`
    }
}

//let asd = new Vacationer(["Tania", "Ivanova", "Zhivkova"], ['123456789', "10/01/2018", 777]);

// Initialize vacationers with 2 and 3 parameters
let vacationer1 = new Vacationer(["Vania", "Ivanova", "Zhivkova"]);

let vacationer2 = new Vacationer(["Tania", "Ivanova", "Zhivkova"],
    [123456789, "10/01/2018", 777]);

// Should throw an error (Invalid full name)
try {
    let vacationer3 = new Vacationer(["Vania", "Ivanova", "ZhiVkova"]);
} catch (err) {
    console.log("Error: " + err.message);
}

// Should throw an error (Missing credit card information)
try {
    let vacationer3 = new Vacationer(["Zdravko", "Georgiev", "Petrov"]);
    vacationer3.addCreditCardInfo([123456789, "20/10/2018"]);
} catch (err) {
    console.log("Error: " + err.message);
}

vacationer1.addDestinationToWishList('Spain');
vacationer1.addDestinationToWishList('Germany');
vacationer1.addDestinationToWishList('Bali');

// Return information about the vacationers
console.log(vacationer1.getVacationerInfo());
console.log(vacationer2.getVacationerInfo());
