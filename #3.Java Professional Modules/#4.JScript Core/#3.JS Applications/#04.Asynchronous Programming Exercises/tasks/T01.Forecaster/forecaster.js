function attachEvents() {
    let LOCATIONS_URL = 'https://judgetests.firebaseio.com/locations.json';
    let TODAY_WEATHER_URL = `https://judgetests.firebaseio.com/forecast/today/`;
    let UPCOMING_WEATHER_URL = `https://judgetests.firebaseio.com/forecast/upcoming/`;

    const LOCATION_TEXT = $(`#location`);
    const LOCATION_SUBMIT = $(`#submit`);
    const FORECAST_DISPLAY = $(`#forecast`);
    const CURRENT_BLOCK = $(`#current`);
    const UPCOMING_BLOCK = $(`#upcoming`);

    LOCATION_SUBMIT.on(`click`, getLocation);

    function getLocation() {
        let locationName = LOCATION_TEXT.val();

        let p1 = $.get(LOCATIONS_URL).then(function (result) {
            let locationObj = result.filter(x => x.name.toLowerCase() === locationName.toLowerCase());

            TODAY_WEATHER_URL += locationObj[0].code + ".json";

            let p2 = $.get(TODAY_WEATHER_URL);
            let p3 = $.get(UPCOMING_WEATHER_URL+locationObj[0].code+".json");

            Promise.all([p2,p3]).then(function (res) {
                console.log(res);

                CURRENT_BLOCK.append(getWeatherSymbolSpan(res[0].forecast.condition,"condition symbol"));
                let conditionWrapper = $(`<span class="condition">`);
                let locationSPAN = $(`<span class="forecast-data">${res[0].name}</span>`);
                let temperatureSPAN = $(`<span class="forecast-data">${res[0].forecast.low}°/${res[0].forecast.high}°</span>`);
                let conditionSPAN = $(`<span class="forecast-data">${res[0].forecast.condition}</span>`);
                conditionWrapper.append(locationSPAN);
                conditionWrapper.append(temperatureSPAN);
                conditionWrapper.append(conditionSPAN);
                CURRENT_BLOCK.append(conditionWrapper);

                for (let i = 0; i <res[1].forecast.length ; i++) {
                    let obj = res[1].forecast[i];
                    let upcomingWrapper2 = $(`<span class="upcoming">`);
                    let symbolSpan2 = getWeatherSymbolSpan(obj.condition,'symbol');
                    let temperatureSPAN2 = $(`<span class="forecast-data">${obj.low}°/${obj.high}°</span>`);
                    let conditionSPAN2 = $(`<span class="forecast-data">${obj.condition}</span>`);
                    upcomingWrapper2.append(symbolSpan2);
                    upcomingWrapper2.append(temperatureSPAN2);
                    upcomingWrapper2.append(conditionSPAN2);
                    UPCOMING_BLOCK.append(upcomingWrapper2);
                }

                FORECAST_DISPLAY.css({'display' : 'inline-block'});
            })
        });

        function getWeatherSymbolSpan(condition,className) {
            switch (condition) {
                case "Sunny":
                    return $(`<span><class = ${className}>☀</span>`);
                case "Partly sunny":
                     return $(`<span><class = ${className}>⛅</span>`);
                case "Overcast":
                    return $(`<span><class = ${className}>☁</span>`);
                case "Rain":
                    return $(`<span><class = ${className}>☂</span>`);
            }
        }
    }
}