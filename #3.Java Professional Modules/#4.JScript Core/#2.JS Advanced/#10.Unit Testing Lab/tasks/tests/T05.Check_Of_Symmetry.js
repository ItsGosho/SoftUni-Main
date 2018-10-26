let expect = require('chai').expect;

function isSymmetric(arr) {
    if (!Array.isArray(arr))
        return false; // Non-arrays are non-symmetric
    let reversed = arr.slice(0).reverse(); // Clone and reverse
    let equal = (JSON.stringify(arr) == JSON.stringify(reversed));
    return equal;
}

describe("Symmetry tests",function () {
    it('Check the isArray check', function () {
          expect(isSymmetric("sfterv")).to.be.false;
    });
    it('Check for correct value return', function () {
        expect(isSymmetric([1,2,1,2,1])).to.be.true;
    });
    it('Check for correct value return with negative numbers', function () {
        expect(isSymmetric([-1,1,-1])).to.be.true;
    });
    it('Check for correct value return with strings', function () {
        expect(isSymmetric(["kochina",1,"kochina"])).to.be.true;
    });
    it('Check for incorrect value return', function () {
        expect(isSymmetric(["kochina",1,"koc1hina"])).to.be.false;
    });
    it('Check with empty arr', function () {
        expect(isSymmetric([])).to.be.true;
    });
});