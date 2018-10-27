let expect = require('chai').expect;

function isOddOrEven(string) {
    if (typeof(string) !== 'string') {
        return undefined;
    }
    if (string.length % 2 === 0) {
        return "even";
    }

    return "odd";
}

describe('isOddOrEven test', function () {
    it('should be string', function () {
          expect(isOddOrEven(1)).to.be.undefined;
    });
    it('should be odd', function () {
        expect(isOddOrEven("asd")).to.equal("odd");
    });
    it('should be even', function () {
        expect(isOddOrEven("as")).to.equal("even");
    });
});