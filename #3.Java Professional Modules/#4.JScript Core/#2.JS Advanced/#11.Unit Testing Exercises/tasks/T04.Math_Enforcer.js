let expect = require('chai').expect;

let mathEnforcer = {
    addFive: function (num) {
        if (typeof(num) !== 'number') {
            return undefined;
        }
        return num + 5;
    },
    subtractTen: function (num) {
        if (typeof(num) !== 'number') {
            return undefined;
        }
        return num - 10;
    },
    sum: function (num1, num2) {
        if (typeof(num1) !== 'number' || typeof(num2) !== 'number') {
            return undefined;
        }
        return num1 + num2;
    }
};

describe('Math enforcer test', function () {
    it('should test all functions with invalid types', function () {
        let me = mathEnforcer;
        expect(me.addFive(undefined)).to.be.undefined;
        expect(me.addFive("asd")).to.be.undefined;
        expect(me.subtractTen(undefined)).to.be.undefined;
        expect(me.subtractTen("asd")).to.be.undefined;
        expect(me.sum(undefined,undefined)).to.be.undefined;
        expect(me.sum(1,undefined)).to.be.undefined;
        expect(me.sum(undefined,1)).to.be.undefined;
    });

    it('should check for correct result', function () {
        let me = mathEnforcer;
        expect(me.subtractTen(10)).to.be.equal(0);
        expect(me.subtractTen(-111)).to.be.equal(-121);
        expect(me.subtractTen(3.30)).to.be.equal(-6.7);
        expect(me.addFive(5)).to.be.equal(10);
        expect(me.addFive(5.50)).to.be.equal(10.5);
        expect(me.addFive(-3)).to.be.equal(2);
        expect(me.sum(1,3)).to.be.equal(4);
        expect(me.sum(1.30,2.70)).to.be.equal(4);
        expect(me.sum(-5,-2)).to.be.equal(-7);
    });
});