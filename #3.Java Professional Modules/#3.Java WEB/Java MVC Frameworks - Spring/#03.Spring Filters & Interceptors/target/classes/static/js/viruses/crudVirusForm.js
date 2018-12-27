function runAddVirusFormScript() {
    //style="display: none"
    const ERROR_INVALID_NAME = "Name must be in range of 3 and 10 characters long.";
    const ERROR_INVALID_DESCRIPTION = "Description must be in range of 5 and 100 characters long.";
    const ERROR_INVALID_SIDE_EFFECTS = "Side Effects must not exceed 50 characters.";
    const ERROR_INVALID_CREATOR = "Creator must be 'Corp' or 'corp'!";
    const ERROR_INVALID_MUTATION = "You must check a mutation type!";
    const ERROR_INVALID_TURNOVER_RATE = "Turnover rate must be between 1 and 100";
    const ERROR_INVALID_HOURS_UNTIL_TURN = "Turnover rate must be between 1 and 12";
    const ERROR_INVALID_DATE = "Date should be before today :)!";

    $(`#name`).on(`keyup keypress`, function () {
        let value = $(`#name`).val().trim();
        if (value.length < 3 || value.length > 10) {
            $(`#name`).addClass("border border-danger");
            $(`#errorName`).text(ERROR_INVALID_NAME);
            $(`#errorName`).show();
        } else {
            $(`#name`).removeClass("border border-danger");
            $(`#name`).addClass("border border-success");
            $(`#errorName`).hide();
        }
    });

    $(`#description`).on(`keyup keypress`, function () {
        let value = $(`#description`).val().trim();
        if (value.length < 5 || value.length > 100) {
            $(`#description`).addClass("border border-danger");
            $(`#errorDescription`).text(ERROR_INVALID_DESCRIPTION);
            $(`#errorDescription`).show();
        } else {
            $(`#description`).removeClass("border border-danger");
            $(`#description`).addClass("border border-success");
            $(`#errorDescription`).hide();
        }
    });

    $(`#sideEffects`).on(`keyup keypress`, function () {
        let value = $(`#sideEffects`).val().trim();
        if (value.length > 50) {
            $(`#sideEffects`).addClass("border border-danger");
            $(`#errorSideEffects`).text(ERROR_INVALID_SIDE_EFFECTS);
            $(`#errorSideEffects`).show();
        } else {
            $(`#sideEffects`).removeClass("border border-danger");
            $(`#sideEffects`).addClass("border border-success");
            $(`#errorSideEffects`).hide();
        }
    });

    $(`#creator`).on(`keyup keypress`, function () {
        let value = $(`#creator`).val().trim();
        if (value === "Corp" || value === "corp") {
            $(`#creator`).removeClass("border border-danger");
            $(`#creator`).addClass("border border-success");
            $(`#errorCreator`).hide();
        } else {
            $(`#creator`).addClass("border border-danger");
            $(`#errorCreator`).text(ERROR_INVALID_CREATOR);
            $(`#errorCreator`).show();
        }
    });

//One of them must be checked!
    $(`#errorMutation`).text(ERROR_INVALID_MUTATION);
    $(`#errorMutation`).show();

    $(`#zombieRadio`).change(function () {
        $(`#errorMutation`).hide();
    });

    $(`#tyrantRadio`).change(function () {
        $(`#errorMutation`).hide();
    });

    $(`#giantSpiderRadio`).change(function () {
        $(`#errorMutation`).hide();
    });
//-----------------------------------------

    $(`#turnoverRate`).on(`keyup keypress`, function () {
        let value = Number($(`#turnoverRate`).val().trim());
        if (value < 1 || value > 100) {
            $(`#turnoverRate`).addClass("border border-danger");
            $(`#errorTurnoverRate`).text(ERROR_INVALID_TURNOVER_RATE);
            $(`#errorTurnoverRate`).show();
        } else {
            $(`#turnoverRate`).removeClass("border border-danger");
            $(`#turnoverRate`).addClass("border border-success");
            $(`#errorTurnoverRate`).hide();
        }
    });

    $(`#hoursUntilTurn`).on(`keyup keypress`, function () {
        let value = Number($(`#hoursUntilTurn`).val().trim());
        if (value < 1 || value > 12) {
            $(`#hoursUntilTurn`).addClass("border border-danger");
            $(`#errorHoursUntilTurn`).text(ERROR_INVALID_HOURS_UNTIL_TURN);
            $(`#errorHoursUntilTurn`).show();
        } else {
            $(`#hoursUntilTurn`).removeClass("border border-danger");
            $(`#hoursUntilTurn`).addClass("border border-success");
            $(`#errorHoursUntilTurn`).hide();
        }
    });

    $(`#realeseDate`).change(function () {
        let date = new Date($(`#realeseDate`).val());
        let currentDate = new Date();
        if(date<currentDate){
            $(`#realeseDate`).removeClass("border border-danger");
            $(`#realeseDate`).addClass("border border-success");
            $(`#errorRealeseDate`).hide();
        }else{
            $(`#realeseDate`).addClass("border border-danger");
            $(`#errorRealeseDate`).text(ERROR_INVALID_DATE);
            $(`#errorRealeseDate`).show();
        }
    });


    $(`#submitVirusButton`).on(`click`, function () {
        if ($(`#deadly`).is(":checked")) {
            $(`#deadly`).val(true);
        }
        if ($(`#curable`).is(":checked")) {
            $(`#curable`).val(true);
        }
    });

//itsgosho!
}