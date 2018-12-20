function attachEvents() {
    const DB_URL = "https://baas.kinvey.com/appdata/kid_rJV1Rm2yV/biggestCatches";
    const auth = {"Authorization": "Basic " + btoa("guest:guest")};
    const catches = $(`#catches`);
    const buttonLoad = $(`.load`);
    const buttonCreate = $(`.add`);

    catches.empty();

    buttonLoad.on(`click`, loadAllCatches);
    buttonCreate.on(`click`, makeCatch);


    function loadAllCatches() {
        catches.empty();
        let p1 = $.ajax({
            url: DB_URL,
            headers: auth
        });

        Promise.all([p1]).then(function (res) {

            for (let i = 0; i < res[0].length; i++) {
                let obj = res[0][i];
                attachCatch(obj._id,obj.angler,obj.weight,obj.species,obj.location,obj.bait,obj.captureTime)
            }
        }).catch(function (err) {
            console.log(err);
        });
    }

    function makeCatch() {
        let angler = $(`#addForm`).children()[2].value;
        let weight = $(`#addForm`).children()[4].value;
        let species = $(`#addForm`).children()[6].value;
        let location = $(`#addForm`).children()[8].value;
        let bait = $(`#addForm`).children()[10].value;
        let captureTime = $(`#addForm`).children()[12].value;

        let json = {"angler":angler,"weight":weight,"species":species,"location":location,"bait":bait,"captureTime":captureTime};

        $.ajax({
            type: "Post",
            url: DB_URL,
            headers: auth,
            data: json,
            success: function (res) {
              attachCatch(res._id,res.angler,res.weight,res.species,res.location,res.bait,res.captureTime)
            },
            error: function (err) {
                console.log(err);
            }
        })
    }

    function attachCatch(id,angler, weight, species, location, bait, captureTime) {
        let newCatch = $(`<div class="catch" data-id=${id}></div>`);

        let labelAngler = $(`<label>Angler</label>`);
        let valueAngler = $(`<input type="text" class="angler" value=${angler} />`);

        let labelWeight = $(`<label>Weight</label>`);
        let valueWeight = $(`<input type="number" class="weight" value=${weight} />`);

        let labelSpecies = $(`<label>Species</label>`);
        let valueSpecies = $(`<input type="text" class="species" value=${species} />`);

        let labelLocation = $(`<label>Location</label>`);
        let valueLocation = $(`<input type="text" class="location" value=${location} />`);

        let labelBait = $(`<label>Bait</label>`);
        let valueBait = $(`<input type="text" class="bait" value=${bait} />`);

        let labelCaptureTime = $(`<label>Capture Time</label>`);
        let valueCaptureTime = $(`<input type="number" class="captureTime" value=${captureTime} />`);

        let buttonUpdate = $(`<button class="update">Update</button>`);
        let buttonDelete = $(`<button class="delete">Delete</button>`);


        buttonDelete.on(`click`,function () {
            $.ajax({
                type: "Delete",
                url: DB_URL+"/"+id,
                headers: auth,
                success: function (res) {
                    newCatch.remove();
                },
                error: function (err) {
                    console.log(err);
                }
            })
        });
        buttonUpdate.on(`click`,function () {
            let json = {"angler":valueAngler.val(),"weight":valueWeight.val(),"species":valueSpecies.val(),"location":valueLocation.val(),"bait":valueBait.val(),"captureTime":valueCaptureTime.val()};
            $.ajax({
                type: "Put",
                url: DB_URL+"/"+id,
                headers: auth,
                data: json,
                success: function (res) {
                    console.log(res);
                },
                error: function (err) {
                    console.log(err);
                }
            })
        });

        newCatch.append(labelAngler);
        newCatch.append(valueAngler);
        newCatch.append(labelWeight);
        newCatch.append(valueWeight);
        newCatch.append(labelSpecies);
        newCatch.append(valueSpecies);
        newCatch.append(labelLocation);
        newCatch.append(valueLocation);
        newCatch.append(labelBait);
        newCatch.append(valueBait);
        newCatch.append(labelCaptureTime);
        newCatch.append(valueCaptureTime);
        newCatch.append(buttonUpdate);
        newCatch.append(buttonDelete);

        catches.append(newCatch);
    }
}