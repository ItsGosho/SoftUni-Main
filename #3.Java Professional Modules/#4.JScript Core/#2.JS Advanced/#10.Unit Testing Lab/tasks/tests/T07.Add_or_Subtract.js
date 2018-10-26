let expect = require('chai').expect;

function createCalculator() {
    let value = 0;
    return {
        add: function(num) { value += Number(num); },
        subtract: function(num) { value -= Number(num); },
        get: function() { return value; }
    }
}
describe("Test calculator",function () {
    it('Test add with different number types', function () {
        let cc = createCalculator();
        cc.add(3);
        expect(cc.get()).to.equal(3);
        cc.add(0.50);
        expect(cc.get()).to.equal(3.5);
        cc.add(-55);
        expect(cc.get()).to.equal(-51.5);
    });

    it('Test substract with different number types ', function () {
        let cc = createCalculator();
        cc.add(3);
        cc.subtract(1);
        expect(cc.get()).to.equal(2);
        cc.subtract(0.50);
        expect(cc.get()).to.equal(1.5);
        cc.add(-33);
        expect(cc.get()).to.equal(-31.5);
    });

    it('Test with invalid inputs', function () {
          let cc = createCalculator();
          cc.subtract(undefined)
          expect(cc.get()).to.be.NaN;
    });
});