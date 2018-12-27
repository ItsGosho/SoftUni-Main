function runUserRegisterFormScript() {
    let errors = false;
    const ERROR_INVALID_CONFIRM_PASSWORD = "Passwords must match!";
    const ERROR_INVALID_USERNAME = "Username already exists!";
    const ERROR_INVALID_EMAIL = "Email already exists!";

    $(`#username`).on(`keyup keypress`,checkUsernameValidation);
    $(`#email`).on(`keyup keypress`,checkEmailValidation);

    $(`#confirmPassword`).on(`keyup keypress`,checkPasswordsValidation);
    $(`#password`).on(`keyup keypress`,checkPasswordsValidation);

    function checkUsernameValidation() {
        let username = $(`#username`).val().trim();
        $.ajax({
            method: "GET",
            url: "http://localhost:8000/users/exists?username="+username,
            success: function (result) {
                if(result.exists){
                    $(`#username`).addClass("border border-danger");
                    $(`#errorUsername`).text(ERROR_INVALID_USERNAME);
                    $(`#errorUsername`).show();
                    errors = true;
                }else{
                    $(`#username`).removeClass("border border-danger");
                    $(`#username`).addClass("border border-success");
                    $(`#errorUsername`).hide();
                    errors = false;
                }
            },
            error: function (error) {

            }
        });
    }

    function checkEmailValidation() {
        let email = $(`#email`).val().trim();
        $.ajax({
            method: "GET",
            url: "http://localhost:8000/users/exists?email="+email,
            success: function (result) {
                if(result.exists){
                    $(`#email`).addClass("border border-danger");
                    $(`#errorEmail`).text(ERROR_INVALID_EMAIL);
                    $(`#errorEmail`).show();
                    errors = true;
                }else{
                    $(`#email`).removeClass("border border-danger");
                    $(`#email`).addClass("border border-success");
                    $(`#errorEmail`).hide();
                    errors = false;
                }
            },
            error: function (error) {

            }
        });
    }

    function checkPasswordsValidation() {
        let value = $(`#password`).val().trim();
        let confValue = $(`#confirmPassword`).val().trim();

        if (value === confValue) {
            $(`#confirmPassword`).removeClass("border border-danger");
            $(`#confirmPassword`).addClass("border border-success");
            $(`#password`).removeClass("border border-danger");
            $(`#password`).addClass("border border-success");
            $(`#errorConfirmPassword`).hide();
            errors = false;
        } else {
            $(`#confirmPassword`).addClass("border border-danger");
            $(`#password`).addClass("border border-danger");
            $(`#errorConfirmPassword`).text(ERROR_INVALID_CONFIRM_PASSWORD);
            $(`#errorConfirmPassword`).show();
            errors = true;
        }
    }

    $(`#registerUserSubmitButton`).on(`click`,function () {
        if(errors){
            return false;
        }
        return true;
    });
}