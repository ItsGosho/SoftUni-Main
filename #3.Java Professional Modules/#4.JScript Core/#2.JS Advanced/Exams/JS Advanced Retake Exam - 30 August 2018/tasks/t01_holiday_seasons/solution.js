function addDestination(){

    let city = $(`.inputData`)[0].value;
    let country = $(`.inputData`)[1].value;
    let season = $(`#seasons`)[0].value;

    if(city!=="" && country!==""){
        let newTr = $(`<tr>`);

        let cityAndCountryTd = $(`<td>`);
        cityAndCountryTd.text(city+", "+country);
        newTr.append(cityAndCountryTd);

        season=(season.substr(0,1).toUpperCase())+(season.substr(1));
        let seasonTd = $(`<td>`);
        seasonTd.text(season);
        newTr.append(seasonTd);

        $(`#destinationsList`).append(newTr);

        if(season.toLowerCase()==="summer"){
           let ss =  parseInt($(`#summer`).val());
            $(`#summer`).val(ss+1);
        }else if(season.toLowerCase()==="autumn"){
            let ss =  parseInt($(`#autumn`).val());
            $(`#autumn`).val(ss+1);
        }else if(season.toLowerCase()==="winter"){
            let ss =  parseInt($(`#winter`).val());
            $(`#winter`).val(ss+1);
        }else if(season.toLowerCase()==="spring"){
            let ss =  parseInt($(`#spring`).val());
            $(`#spring`).val(ss+1);
        }
        $(`.inputData`).val("");
    }
}