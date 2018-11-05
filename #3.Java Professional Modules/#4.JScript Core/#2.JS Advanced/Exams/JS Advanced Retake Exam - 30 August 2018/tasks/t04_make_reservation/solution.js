function makeReservation(container) {
    let buttonSubmit = $(`#submit`);
    let buttonEdit = $(`#edit`);
    let buttonContinue = $(`#continue`);
    let fullNameField = $(`#fullName`);
    let emailField = $(`#email`);
    let phonenumberField = $(`#phoneNumber`);
    let addressField = $(`#address`);
    let postalCodeField = $(`#postalCode`);

    buttonSubmit.on(`click`, function () {
        if (fullNameField.val() !== "" && emailField.val() !== "") {
            let nameLi = $(`<li>`);
            let emailLi = $(`<li>`);
            let phonenumberLi = $(`<li>`);
            let addressLi = $(`<li>`);
            let postalCodeLi = $(`<li>`);

            nameLi.text("Name: " + fullNameField.val());
            emailLi.text("E-mail: " + emailField.val());
            phonenumberLi.text("Phone: " + phonenumberField.val());
            addressLi.text("Address: " + addressField.val());
            postalCodeLi.text("Postal Code: " + postalCodeField.val());

            $(`#infoPreview`).append(nameLi);
            $(`#infoPreview`).append(emailLi);
            $(`#infoPreview`).append(phonenumberLi);
            $(`#infoPreview`).append(addressLi);
            $(`#infoPreview`).append(postalCodeLi);

            fullNameField.val("");
            emailField.val("");
            phonenumberField.val("");
            addressField.val("");
            postalCodeField.val("");

            $(`#submit`).prop(`disabled`, true);
            $(`#edit`).prop(`disabled`, false);
            $(`#continue`).prop(`disabled`, false);
        }
    });

    buttonEdit.on(`click`, function () {
        $(`#fullName`).val($(`#infoPreview`).children()[0].textContent.split(":")[1].trim());
        $(`#email`).val($(`#infoPreview`).children()[1].textContent.split(":")[1].trim());
        $(`#phoneNumber`).val($(`#infoPreview`).children()[2].textContent.split(":")[1].trim());
        $(`#address`).val($(`#infoPreview`).children()[3].textContent.split(":")[1].trim());
        $(`#postalCode`).val($(`#infoPreview`).children()[4].textContent.split(":")[1].trim());
        $(`#infoPreview`).empty();
        $(`#submit`).prop(`disabled`, false);
        $(`#edit`).prop(`disabled`, true);
        $(`#continue`).prop(`disabled`, true);
    });

    buttonContinue.on(`click`, function () {

        $(`#submit`).prop(`disabled`, true);
        $(`#edit`).prop(`disabled`, true);
        $(`#continue`).prop(`disabled`, true);

        let divElement = $(`<div>`);
        divElement.attr(`id`, `extraDetails`);

        let newH2 = $(`<h2>`);
        newH2.text("Payment details");

        let select = $(`<select>`);
        select.attr(`id`, `paymentOptions`);
        select.attr(`class`, `custom-select`);

        let option1 = $(`<option>`);
        option1.text("Choose");
        option1.attr(`disabled`, true);
        option1.attr(`hidden`, true);
        option1.attr(`selected`, true);
        let option2 = $(`<option>`);
        option2.text("Credit Card");
        option2.attr(`value`, `creditCard`);
        option2.on(`click`, function () {
            let cardNumber = $(`<div>`);
            cardNumber.attr(`class`, `inputLabel`);
            cardNumber.text("Card Number");
            cardNumber.append($(`<input>`));

            let expDate = $(`<div>`);
            expDate.attr(`class`, `inputLabel`);
            expDate.text("Expiration Date");
            expDate.append($(`<input>`));

            let securityNumbers = $(`<div>`);
            securityNumbers.attr(`class`, `inputLabel`);
            securityNumbers.text("Security Numbers");
            securityNumbers.append($(`<input>`));

            let button = $(`<button>`);
            button.attr(`id`,`checkOut`);
            button.text("Check Out");

            divElement.append(cardNumber);
            divElement.append($(`<br>`));
            divElement.append(expDate);
            divElement.append($(`<br>`));
            divElement.append(securityNumbers);
            divElement.append($(`<br>`));
            divElement.append(button);

            button.on(`click`,function () {
                $(`#wrapper`).html('');
                let h4 = $(`<h4>`);
                h4.text("Thank you for your reservation");
                $(`#wrapper`).append(h4);
            });
        });
        let option3 = $(`<option>`);
        option3.on(`click`,function(){
            let newP = $(`<p>`);
            newP.html("You have 48 hours to transfer the amount to: <br> IBAN: GR96 0810 0010 0000 0123 4567 890");
            let btn = $(`<button>`);
            btn.attr(`id`,`checkOut`);
            btn.text("Check Out");
            divElement.append(newP);
            divElement.append(btn);
            btn.on(`click`,function () {
                $(`#wrapper`).html('');
                let h4 = $(`<h4>`);
                h4.text("Thank you for your reservation");
                $(`#wrapper`).append(h4);
            });
        });
        option3.text("Bank Transfer");
        option3.attr(`value`, `bankTransfer`);
        select.append(option1);
        select.append(option2);
        select.append(option3);

        $(`#container`).append(newH2);
        $(`#container`).append(select);
        $(`#container`).append(divElement);
    });

}