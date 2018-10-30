class CheckingAccount {

    constructor (clientId,email,firstName,lastName){

        this.clientId=clientId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    set clientId(value) {
        if(value.length!==6 && !Number.isInteger(value)){
            throw new TypeError("Client ID must be a 6-digit number");
        }
        this._clientId = value;
    }

    set email(value) {
        let emailPatern = /^[a-zA-Z0-9]+@[a-zA-Z.]+$/g;
        if(!emailPatern.test(value)){
            throw new TypeError("Invalid e-mail")
        }
        this._email = value;
    }

    set firstName(value) {
        if(value.length>=3 && value.length<=20){
            throw new TypeError("First name must be between 3 and 20 characters long");
        }
        let namePatt = /^[a-z]+$/g;
        if(!namePatt.test(value)){
            throw new TypeError("First name must contain only Latin characters");
        }
        this._firstName = value;
    }

    set lastName(value) {
        if(value.length>=3 && value.length<=20){
            throw new TypeError("Last name must be between 3 and 20 characters long");
        }
        let namePatt = /^[a-z]+$/g;
        if(!namePatt.test(value)){
            throw new TypeError("Last name must contain only Latin characters");
        }
        this._lastName = value;
    }
}


//DONE: let acc = new CheckingAccount('1314', 'ivan@some.com', 'Ivan', 'Petrov');
//let acc1 = new CheckingAccount('131455', 'ivan@', 'Ivan', 'Petrov');
let acc2 = new CheckingAccount('131455', 'ivan@some.com', 'I', 'Petrov');
let acc3 = new CheckingAccount('131455', 'ivan@some.com', 'Ivan', 'P3trov');