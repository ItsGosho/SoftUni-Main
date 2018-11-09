function onlineShop(selector) {
    let form = $(`<div id="header">Online Shop Inventory</div>
    <div class="block">
        <label class="field">Product details:</label>
        <br>
        <input placeholder="Enter product" class="custom-select">
        <input class="input1" id="price" type="number" min="1" max="999999" value="1"><label class="text">BGN</label>
        <input class="input1" id="quantity" type="number" min="1" value="1"><label class="text">Qty.</label>
        <button id="submit" class="button" disabled>Submit</button>
        <br><br>
        <label class="field">Inventory:</label>
        <br>
        <ul class="display">
        </ul>
        <br>
        <label class="field">Capacity:</label><input id="capacity" readonly>
        <label class="field">(maximum capacity is 150 items.)</label>
        <br>
        <label class="field">Price:</label><input id="sum" readonly>
        <label class="field">BGN</label>
    </div>`);
    $(selector).html(form);
    // Write your code here

    let currCuant=0;

    let productField = $(`.custom-select`);
    let priceField = $(`#price`);
    let quantityField = $(`#quantity`);
    let submitButton = $(`#submit`);
    let inventoryField = $(`.display`);
    let capacityField = $(`#capacity`);
    let sumField = $(`#sum`);
    productField.on('input',function () {
        if(productField.val().length>=1){
            submitButton.prop("disabled",false);
        }else{
            submitButton.prop("disabled",true);
        }
    });

    submitButton.on(`click`,function () {

        let newLi = $(`<li>`);
        newLi.text(`Product: ${productField.val()} Price: ${priceField.val()} Quantity: ${quantityField.val()}`);
        inventoryField.append(newLi);
        capacityField.val(inventoryField[0].children.length);
        sumField.val(Number(sumField.val())+Number(priceField.val()));
        currCuant+=Number(quantityField.val());
        capacityField.val(currCuant);
        if(currCuant>=150){
            submitButton.prop("disabled",true);
            productField.prop("disabled",true);
            priceField.prop("disabled",true);
            quantityField.prop("disabled",true);
            capacityField.addClass("fullCapacity");
            capacityField.val("full");
        }
        submitButton.prop("disabled",true);
        productField.val("");
        priceField.val(1);
        quantityField.val(1);
    });
}