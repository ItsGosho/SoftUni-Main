function runUserLoginFormScript() {
    const URL = "http://localhost:8000/users/isvalid";

    $(`#loginUserSubmitButton`).on(`click`, function () {
        return check();
    });

    function check() {
        let errors = true;
        let username = $(`#username`).val();
        let password = $(`#password`).val();
        $.ajax({
            method: "GET",
            url: URL + "?username=" + username + "&password=" + password,
            dataType: 'json',
            async: false,
            success: function (result) {
                if (!result.valid) {
                    $(`#errorLogin`).text('Wrong username or password');
                    $(`#errorLogin`).show();
                    errors = false;
                }
            },
            error: function (error) {
                $(`#errorLogin`).text('Wrong username or password');
                $(`#errorLogin`).show();
                errors = false;
            }
        });
        return errors;
    }
}