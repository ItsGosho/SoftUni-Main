const WebTools = {

    addToSession(key, value) {
        sessionStorage.setItem(key, value);
    },

    /*
    * Parameters:
    * @arguments: ID`s of fields which have value
    *
    * Will clear the value of the provided args
    * */
    clearParametersValue() {
        for (let i = 0; i < arguments.length; i++) {
            document.getElementById(arguments[i]).value = '';
        }
    },

    getParam(key) {
        return sessionStorage.getItem(key);
    },

    clearSession() {
        sessionStorage.clear();
    },

    isLoggedIn() {
        let authenticationToken = sessionStorage.getItem(LocalStorageParam.AUTHENTICATION_TOKEN);
        return authenticationToken !== null;
    },

    /*
    * Parameters:
    * @path: The path where the file is with the extensions ex: templates\\asd.hbs
    *
    * @returns The file as string
    * */
    getHTMLFile(path) {
        let result;

        $.ajax({
            type: 'GET',
            url: path,
            async: false,
        }).done(function (htmlContent) {
            result = htmlContent;
        }).fail(function (error) {
            throw new Error('There was error with getting file in [getHTMLFile]!');
        });

        return result;
    }

};