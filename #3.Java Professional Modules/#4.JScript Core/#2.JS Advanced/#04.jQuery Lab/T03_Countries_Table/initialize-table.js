function initializeTable() {

    fill("Bulgaria","Sofia");
    fill("Germany","Berlin");
    fill("Russia","Moscow");


    $(`#createLink`).on("click",function () {
        let country = $(`#newCountryText`)[0].value;
        let capital = $(`#newCapitalText`)[0].value;
        let tr = $(`<tr>`);

        let tdCountry = $(`<td>`);
        tdCountry.text(country);
        tr.append(tdCountry);

        let tdCapital = $(`<td>`);
        tdCapital.text(capital);
        tr.append(tdCapital);

        let tdButtons = $(`<td>`);

        let tdButtonsUp = $(`<a href="#">`);
        tdButtonsUp.text("[Up]");
        tdButtonsUp.on("click",function () {
            let arr = $(`tr`);
            let topElementIndex;
            let currentElementIndex;
            for (let i = 2; i < arr.length; i++) {
                if(arr[i].firstChild.textContent===country){
                    topElementIndex=i-1;
                    currentElementIndex=i;
                }
            }
            arr.insertBefore(arr[topElementIndex]);
            arr[topElementIndex].childNodes[2].childNodes[0].hidden=false;
            checkUp();
            checkDown();

        });

        let tdButtonsDown = $(`<a href="#">`);
        tdButtonsDown.text("[Down]");
        tdButtonsDown.on("click",function () {
            let arr = $(`tr`);
            let topElementIndex;
            let currentElementIndex;
            for (let i = 2; i < arr.length; i++) {
                if(arr[i].firstChild.textContent===country){
                    topElementIndex=i-1;
                    currentElementIndex=i;
                }
            }
            arr.insertBefore(arr[currentElementIndex]);
            arr[topElementIndex].childNodes[2].childNodes[1].hidden=false;
            checkUp();
            checkDown();

        });

        let tdButtonsDelete = $(`<a href="#">`);
        tdButtonsDelete.text("[Delete]");
        tdButtonsDelete.on("click",function () {
            tr.fadeOut(1000);
            setTimeout(1000,function () {
                tr.remove();
                checkUp();
                checkDown();
            })
        });

        tdButtons.append(tdButtonsUp);
        tdButtons.append(tdButtonsDown);
        tdButtons.append(tdButtonsDelete);

        tr.append(tdButtons);

        $(`#countriesTable`).append(tr);
        checkUp();
        checkDown();
    });
    function checkUp() {
        let arr = $(`tr`).splice(2);

        if(arr.length>=1){
            if(arr[0].childNodes[2].childNodes[0].textContent==="[Up]"){
                arr[0].childNodes[2].childNodes[0].hidden=true;
            }
        }
    }

    function fill(country,capital) {
        let tr = $(`<tr>`);

        let tdCountry = $(`<td>`);
        tdCountry.text(country);
        tr.append(tdCountry);

        let tdCapital = $(`<td>`);
        tdCapital.text(capital);
        tr.append(tdCapital);

        let tdButtons = $(`<td>`);

        let tdButtonsUp = $(`<a href="#">`);
        tdButtonsUp.text("[Up]");
        tdButtonsUp.on("click",function () {
            let arr = $(`tr`);
            let topElementIndex;
            let currentElementIndex;
            for (let i = 2; i < arr.length; i++) {
                if(arr[i].firstChild.textContent===country){
                    topElementIndex=i-1;
                    currentElementIndex=i;
                }
            }
            arr.insertBefore(arr[topElementIndex]);
            arr[topElementIndex].childNodes[2].childNodes[0].hidden=false;
            checkUp();
            checkDown();

        });

        let tdButtonsDown = $(`<a href="#">`);
        tdButtonsDown.text("[Down]");
        tdButtonsDown.on("click",function () {
            let arr = $(`tr`);
            let topElementIndex;
            let currentElementIndex;
            for (let i = 2; i < arr.length; i++) {
                if(arr[i].firstChild.textContent===country){
                    topElementIndex=i-1;
                    currentElementIndex=i;
                }
            }
            arr.insertBefore(arr[currentElementIndex]);
            arr[topElementIndex].childNodes[2].childNodes[1].hidden=false;
            checkUp();
            checkDown();

        });

        let tdButtonsDelete = $(`<a href="#">`);
        tdButtonsDelete.text("[Delete]");
        tdButtonsDelete.on("click",function () {
            tr.fadeOut(1000);
            setTimeout(1000,function () {
                tr.remove();
                checkUp();
                checkDown();
            })
        });

        tdButtons.append(tdButtonsUp);
        tdButtons.append(tdButtonsDown);
        tdButtons.append(tdButtonsDelete);

        tr.append(tdButtons);

        $(`#countriesTable`).append(tr);
        checkUp();
        checkDown();
    }

    function checkDown() {
        let arr = $(`tr`).splice(2);

        if(arr.length>=1){
            if(arr[arr.length-1].childNodes[2].childNodes[1].textContent==="[Down]"){
                arr[arr.length-1].childNodes[2].childNodes[1].hidden=true;
            }
        }
    }
}
