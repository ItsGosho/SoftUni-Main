let expect = require("chai").expect;

class Console {

    static get placeholder() {
        return /{\d+}/g;
    }

    static writeLine() {
        let message = arguments[0];
        if (arguments.length === 1) {
            if (typeof (message) === 'object') {
                message = JSON.stringify(message);
                return message;
            }
            else if (typeof(message) === 'string') {
                return message;
            }
        }
        else {
            if (typeof (message) !== 'string') {
                throw new TypeError("No string format given!");
            }
            else {
                let tokens = message.match(this.placeholder).sort(function (a, b) {
                    a = Number(a.substring(1, a.length - 1));
                    b = Number(b.substring(1, b.length - 1));
                    return a - b;
                });
                if (tokens.length !== (arguments.length - 1)) {
                    throw new RangeError("Incorrect amount of parameters given!");
                }
                else {
                    for (let i = 0; i < tokens.length; i++) {
                        let number = Number(tokens[i].substring(1, tokens[i].length - 1));
                        if (number !== i) {
                            throw new RangeError("Incorrect placeholders given!");
                        }
                        else {
                            message = message.replace(tokens[i], arguments[i + 1])
                        }
                    }
                    return message;
                }
            }
        }
    }
};

//console.log(Console.placeholder("Dobre {0}!","Brat"));

describe('Console tests', function () {
    it('should return placeholder', function () {
         expect(Console.placeholder).to.not.equal(/{\d+}/g);
    });

    it('should should return message as object', function () {
         expect(Console.writeLine({name:"gosho",age:17})).to.equal("{\"name\":\"gosho\",\"age\":17}");
    });

    it('should should return string', function () {
         expect(Console.writeLine("asd")).to.equal("asd");
    });
    it('should should return undefined', function () {
        expect(Console.writeLine(123)).to.equal(undefined);
    });

    it('should throw type error cuz its not a string', function () {
        expect(() => Console.writeLine(123,"asd")).to.throw(TypeError);
    });

    it('should throw not enought parameters given', function () {
        expect(() => Console.writeLine("Ok {0} dobre {1}","asd")).to.throw(RangeError);
    });

    it('should throw incorect placeholders given', function () {
        expect(() => Console.writeLine("Ok {03}","asd")).to.throw(RangeError);
    });

    it('should return right answer', function () {
        expect(Console.writeLine("I`m {0} really {1}","really","good"))
            .to.equal("I`m really really good");
    });
});

