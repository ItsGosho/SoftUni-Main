let expect = require("chai").expect;

class Calculator {
    constructor() {
        this.expenses = [];
    }

    add(data) {
        this.expenses.push(data);
    }

    divideNums() {
        let divide;
        for (let i = 0; i < this.expenses.length; i++) {
            if (typeof (this.expenses[i]) === 'number') {
                if (i === 0 || divide===undefined) {
                    divide = this.expenses[i];
                } else {
                    if (this.expenses[i] === 0) {
                        return 'Cannot divide by zero';
                    }
                    divide /= this.expenses[i];
                }
            }
        }
        if (divide !== undefined) {
            this.expenses = [divide];
            return divide;
        } else {
            throw new Error('There are no numbers in the array!')
        }
    }

    toString() {
        if (this.expenses.length > 0)
            return this.expenses.join(" -> ");
        else return 'empty array';
    }

    orderBy() {
        if (this.expenses.length > 0) {
            let isNumber = true;
            for (let data of this.expenses) {
                if (typeof data !== 'number')
                    isNumber = false;
            }
            if (isNumber) {
                return this.expenses.sort((a, b) => a - b).join(', ');
            }
            else {
                return this.expenses.sort().join(', ');
            }
        }
        else return 'empty';
    }
}


describe('Calculator Unit Test', function () {
    it('should test constructor initialization', function () {
        let c = new Calculator();
        expect(c.expenses).to.be.empty;
        expect(c.expenses).to.be.instanceOf(Array)
    });

    it('should test add method', function () {
         let c = new Calculator();
         c.add(5);
         expect(c.expenses).to.contain(5);
    });

    it('should test divideNums method', function () {
          let c = new Calculator();
          c.add(5);
          c.add(3);
          c.add(2);
          c.add("asd");
          expect(c.divideNums()).to.be.equal(0.8333333333333334);
          c.add(2.50);
          c.add(undefined);
          expect(c.divideNums()).to.be.equal(0.33333333333333337);
          c.add(0);
          expect(c.divideNums()).to.be.equal("Cannot divide by zero");
          c.expenses=[];
          expect(()=>c.divideNums()).to.throw(Error);
    });

    it('should test toString method', function () {
         let c = new Calculator();
         expect(c.toString()).to.be.equal("empty array");
         c.add("Robo");
         c.add(1.00);
         c.add(new Array(1,2,3));
         expect(c.toString()).to.be.equal("Robo -> 1 -> 1,2,3");
    });

    it('should test orderBy', function () {
        let c = new Calculator();
        expect(c.orderBy()).to.be.equal("empty");
        c.add(4);
        c.add(1.50);
        c.add(1);
        expect(c.orderBy()).to.be.equal("1, 1.5, 4");
        c.add("gosho");
        expect(c.orderBy()).to.be.equal("1, 1.5, 4, gosho");
        c.expenses=[];
        c.add("B");
        c.add("A");
        c.add("C");
        expect(c.orderBy()).to.be.equal("A, B, C");
    });
});