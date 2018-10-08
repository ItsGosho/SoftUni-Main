function attachEventsListeners() {
    let buttonConvert = document.getElementById("convert");
    buttonConvert.addEventListener("click",function () {
        let inputDistance = document.getElementById("inputDistance").value;
        let resultR = document.getElementById("outputDistance");
        let inputType = document.getElementById("inputUnits").value;
        let outputType = document.getElementById("outputUnits").value;

        let inputToM = 0;
        let result = 0;
        switch (inputType){
            case 'km':
                inputToM = inputDistance * 1000;
                break;
            case 'm':
                inputToM = inputDistance;
                break;
            case 'cm':
                inputToM = inputDistance * 0.01;
                break;
            case 'mm':
                inputToM = inputDistance * 0.001;
                break;
            case 'mi':
                inputToM = inputDistance * 1609.34;
                break;
            case 'yrd':
                inputToM = inputDistance * 0.9144;
                break;
            case 'ft':
                inputToM = inputDistance * 0.3048;
                break;
            case 'in':
                inputToM = inputDistance * 0.0254;
                break;
        }

        switch (outputType){
            case 'km':
                result = inputToM / 1000;
                break;
            case 'm':
                result = inputToM;
                break;
            case 'cm':
                result = inputToM / 0.01;
                break;
            case 'mm':
                result = inputToM / 0.001;
                break;
            case 'mi':
                result = inputToM / 1609.34;
                break;
            case 'yrd':
                result = inputToM / 0.9144;
                break;
            case 'ft':
                result = inputToM / 0.3048;
                break;
            case 'in':
                result = inputToM / 0.0254;
                break;
        }
        resultR.value = result;

    })
}
