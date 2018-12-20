const app = Sammy(`#main`, function () {
    this.use(`Handlebars`, `hbs`);

    this.get(`#/login`, async function () {
        if (isAuthorized()) {
            this.redirect('#/profile');
        } else {
            let template = Handlebars.compile(await $.get(`templates\\login.hbs`));
            $(`#main`).html(template());
        }
    });

    this.post(`#/login`, function (context) {
        if (isAuthorized()) {
            this.redirect('#/profile');
        } else {
            //MADE NOT ASYNC BECAUSE OF THE RESULT AND REDIRECT :)) @itsgosho
            if (login(context.params.username, context.params.password)) {
                this.redirect('#/profile');
            } else {
                this.redirect('#/login');
            }
        }
    });

    this.get(`#/register`, async function () {
        if (isAuthorized()) {
            this.redirect('#/profile');
        } else {
            let template = Handlebars.compile(await $.get(`templates\\register.hbs`));
            $(`#main`).html(template());
        }
    });

    this.post(`#/register`, function (context) {
        if (isAuthorized()) {
            this.redirect('#/profile');
        } else {
            //MADE NOT ASYNC BECAUSE OF THE RESULT AND REDIRECT :)) @itsgosho
            if (register(context.params.username, context.params.password, context.params.repeatPassword, context.params.firstName, context.params.lastName, context.params.email, context.params.telephone)) {
                this.redirect('#/profile');
            } else {
                this.redirect('#/login');
            }
        }
    });


    this.get(`#/profile`, async function () {
        if (!isAuthorized()) {
            this.redirect('#/login');
        } else {
            let user = getCurrentLoggedUser();

            let template = Handlebars.compile(await $.get(`templates\\profile.hbs`));
            $(`#main`).html(template(user));
        }
    });

    this.post(`#/profile`, function (context) {
        if (!isAuthorized()) {
            this.redirect('#/login');
        } else {
            updateUserData(context.params.firstName, context.params.lastName, context.params.email, context.params.telephone)
            this.redirect('#/profile');
        }
    });

    this.get(`#/link-contacts`,async function () {
        if (!isAuthorized()) {
            this.redirect('#/login');
        } else {
            let users = getAllUsers();
            let contacts = {contacts: users};
            let template = Handlebars.compile(await $.get(`templates\\contacts.hbs`));
            $(`#main`).html(template(contacts));
            let detailsTemplate = Handlebars.compile(await $.get(`templates\\details.hbs`));
            for (let userElement of $(`#contacts .content .contact`)) {
                $(userElement).on(`mouseover`,function () {
                    let id = $(this).attr(`data-id`);
                    let user = users.filter(x=>x._id===id)[0];
                    $(`#details`).html(detailsTemplate(user));
                })
            }
        }
    });


    this.get(`#/logout`, function () {
        if (!isAuthorized()) {
            console.log("No permission");
        } else {
            sessionStorage.clear();
            console.log("Successful logout");
        }
        this.redirect('#/login');
    });
});