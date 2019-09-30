const DateHelper = {

    dateAfterHours(hours) {
        let expirationDate = new Date();
        expirationDate.setHours(expirationDate.getHours() + hours);
        return expirationDate;
    }

};

export default DateHelper;