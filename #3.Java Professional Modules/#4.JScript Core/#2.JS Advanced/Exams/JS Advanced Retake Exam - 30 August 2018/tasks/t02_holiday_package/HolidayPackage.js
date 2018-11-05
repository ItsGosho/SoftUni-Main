let expect = require('chai').expect;

class HolidayPackage {
    constructor(destination, season) {
        this.vacationers = [];
        this.destination = destination;
        this.season = season;
        this.insuranceIncluded = false; // Default value
    }

    showVacationers() {
        if (this.vacationers.length > 0)
            return "Vacationers:\n" + this.vacationers.join("\n");
        else
            return "No vacationers are added yet";
    }

    addVacationer(vacationerName) {
        if (typeof vacationerName !== "string" || vacationerName === ' ') {
            throw new Error("Vacationer name must be a non-empty string");
        }
        if (vacationerName.split(" ").length !== 2) {
            throw new Error("Name must consist of first name and last name");
        }
        this.vacationers.push(vacationerName);
    }

    get insuranceIncluded() {
        return this._insuranceIncluded;
    }

    set insuranceIncluded(insurance) {
        if (typeof insurance !== 'boolean') {
            throw new Error("Insurance status must be a boolean");
        }
        this._insuranceIncluded = insurance;
    }

    generateHolidayPackage() {
        if (this.vacationers.length < 1) {
            throw new Error("There must be at least 1 vacationer added");
        }
        let totalPrice = this.vacationers.length * 400;

        if (this.season === "Summer" || this.season === "Winter") {
            totalPrice += 200;
        }

        totalPrice += this.insuranceIncluded === true ? 100 : 0;

        return "Holiday Package Generated\n" +
            "Destination: " + this.destination + "\n" +
            this.showVacationers() + "\n" +
            "Price: " + totalPrice;
    }
}

describe('Holiday Package Unit Test', function () {
    it('should test constructor default and assigned properties', function () {
           let hp = new HolidayPackage("Vratza","Winter");
           expect(hp.vacationers).to.be.empty;
           expect(hp.destination).to.be.equal("Vratza");
           expect(hp.season).to.be.equal("Winter");
           expect(hp.insuranceIncluded).to.be.false;
    });

    it('should test showVacationers function', function () {
        let hp = new HolidayPackage("Vratza","Winter");
        expect(hp.showVacationers()).to.be.equal("No vacationers are added yet");
        hp.addVacationer("Georgi Peev");
        hp.addVacationer("Divcho Ivanov");
        expect(hp.showVacationers()).to.be.equal("Vacationers:\nGeorgi Peev\nDivcho Ivanov");
    });

    it('should test  addVacationers function', function () {
        let hp = new HolidayPackage("Vratza","Winter");

        expect(()=>hp.addVacationer("onlyFirstName")).to.throw(Error);
        expect(()=>hp.addVacationer("first second last")).to.throw(Error);
        expect(()=>hp.addVacationer(" ")).to.throw(Error);
        expect(()=>hp.addVacationer(new Date())).to.throw(Error);
        expect(()=>hp.addVacationer(1)).to.throw(Error);
        expect(()=>hp.addVacationer(1.00)).to.throw(Error);
        hp.addVacationer("Georgi Peev");
        expect(hp.vacationers).to.contain("Georgi Peev");

    });

    it('should test insuranceIncluded GET method', function () {
        let hp = new HolidayPackage("Vratza","Winter");
        expect(hp.insuranceIncluded).to.be.false;
        hp.insuranceIncluded=true;
        expect(hp.insuranceIncluded).to.be.true;
    });

    it('should test insuranceIncluded SET method', function () {
        let hp = new HolidayPackage("Vratza","Winter");
        expect(()=>hp.insuranceIncluded = 5).to.throw(Error);
        expect(()=>hp.insuranceIncluded = new Date()).to.throw(Error);
        expect(()=>hp.insuranceIncluded = 5.50).to.throw(Error);
        expect(()=>hp.insuranceIncluded = []).to.throw(Error);
        hp.insuranceIncluded = true;
        expect(hp.insuranceIncluded).to.be.true;
    });

    it('should test generateHolidayPackage', function () {
          let hp = new HolidayPackage("Vratza","Winter");
          expect(()=> hp.generateHolidayPackage()).to.throw(Error);
          hp.insuranceIncluded=true;
          hp.addVacationer("Georgi Peev");
          expect(hp.generateHolidayPackage()).to.equal("Holiday Package Generated\nDestination: Vratza\nVacationers:\nGeorgi Peev\nPrice: 700");
          hp.addVacationer("Roshko Roshkov")
          hp.insuranceIncluded=false;
          hp.season="Random";
          expect(hp.generateHolidayPackage()).to.equal("Holiday Package Generated\nDestination: Vratza\nVacationers:\nGeorgi Peev\nRoshko Roshkov\nPrice: 800");
          hp.season="Summer";
          expect(hp.generateHolidayPackage()).to.equal("Holiday Package Generated\nDestination: Vratza\nVacationers:\nGeorgi Peev\nRoshko Roshkov\nPrice: 1000");

    });
});


