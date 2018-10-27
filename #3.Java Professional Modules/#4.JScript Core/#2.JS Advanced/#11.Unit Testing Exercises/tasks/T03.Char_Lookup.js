let expect = require('chai').expect;

function lookupChar(string, index) {
    if (typeof(string) !== 'string' || !Number.isInteger(index)) {
        return undefined;
    }
    if (string.length <= index || index < 0) {
        return "Incorrect index";
    }

    return string.charAt(index);
}

describe('lookupChar test', function () {
    it('should try with invalid datatypes', function () {
          expect(lookupChar(1,1)).to.be.undefined;
          expect(lookupChar("asd","=er")).to.be.undefined;
          expect(lookupChar("oki",1.50)).to.be.undefined;
    });
    it('should check if the index check work', function () {
          expect(lookupChar("oki",-1)).to.equal("Incorrect index");
          expect(lookupChar("oki",234)).to.equal("Incorrect index");
    });
    it('should return right answer', function () {
        expect(lookupChar("oki",1)).to.equal("k");
    });
});