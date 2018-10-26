let expect = require('chai').expect;

function sum(arr) {
    let sum = 0;
    for (num of arr)
        sum += Number(num);
    return sum;
}

describe('Sum Of Numbers Tests', function () {
    it('Sum of all numbers', function () {
          expect(sum([1,2,3])).to.equal(6,'Wrong sum of 1,2 and 3')
    });
    it('Sum of one number', function () {
        expect(sum([5])).to.equal(5,'Wrong sum of only one number')
    });
    it('Sum of float numbers ', function () {
        expect(sum([1.50,2.50,3.30])).to.equal(7.3,'Wrong sum of float numbers')
    });
    it('Sum of negative numbers', function () {
        expect(sum([-1,-2])).to.equal(-3,'Wrong sum of negative numbers')
    });
});