let expect = require('chai').expect;

function rgbToHexColor(red, green, blue) {
    if (!Number.isInteger(red) || (red < 0) || (red > 255))
        return undefined; // Red value is invalid
    if (!Number.isInteger(green) || (green < 0) || (green > 255))
        return undefined; // Green value is invalid
    if (!Number.isInteger(blue) || (blue < 0) || (blue > 255))
        return undefined; // Blue value is invalid
    return "#" +
        ("0" + red.toString(16).toUpperCase()).slice(-2) +
        ("0" + green.toString(16).toUpperCase()).slice(-2) +
        ("0" + blue.toString(16).toUpperCase()).slice(-2);
}

describe("RGB To Hex Tests",function () {
    it('should stop on invalid numbers', function () {
        expect(rgbToHexColor(-1,150,150)).to.be.undefined
        expect(rgbToHexColor(150,150,-1)).to.be.undefined
        expect(rgbToHexColor(150,-1,150)).to.be.undefined
    });
    it('should stop on invalid float nums', function () {
        expect(rgbToHexColor(1.50,150,150)).to.be.undefined
        expect(rgbToHexColor(150,150,3.30)).to.be.undefined
        expect(rgbToHexColor(150,7.10000,150)).to.be.undefined
    });
    it('should stop on invalid data types', function () {
        expect(rgbToHexColor({},150,150)).to.be.undefined
        expect(rgbToHexColor(150,150,[])).to.be.undefined
        expect(rgbToHexColor(150,new Date(),150)).to.be.undefined
    });
    it('test for correct result with correct values', function () {
        expect(rgbToHexColor(23,8,4)).to.equals("#170804");
        expect(rgbToHexColor(1,127,87)).to.equals("#017F57");
        expect(rgbToHexColor(61,4,87)).to.equals("#3D0457");
        expect(rgbToHexColor(36,96,23)).to.equals("#246017");
        expect(rgbToHexColor(0,0,0)).to.equals("#000000");
    });
    it('asd ', function () {
        expect(rgbToHexColor(undefined)).to.be.undefined;
    });
});