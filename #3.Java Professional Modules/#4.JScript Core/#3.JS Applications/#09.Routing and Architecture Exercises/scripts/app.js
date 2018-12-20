$(async () => {
    Handlebars.registerPartial("header",Handlebars.compile(await $.get(`templates\\common\\header.hbs`))());
    Handlebars.registerPartial("footer",Handlebars.compile(await $.get(`templates\\common\\footer.hbs`))());
    Handlebars.registerPartial("loginForm",Handlebars.compile(await $.get(`templates\\login\\loginForm.hbs`))());
    Handlebars.registerPartial("registerForm",Handlebars.compile(await $.get(`templates\\register\\registerForm.hbs`))());

    const app = Sammy('#main', function () {

        loadHome();

        this.get(`#/home`,async function () {
            loadHome();
        });

        this.get(`#/about`,async function () {
            let template = Handlebars.compile(await $.get(`templates\\about\\about.hbs`));
            $(`#main`).html(template());
        });

        this.get(`#/login`,async function () {
            let template = Handlebars.compile(await $.get(`templates\\login\\loginPage.hbs`));
            $(`#main`).html(template());
        });

        this.get(`#/register`,async function () {
            let template = Handlebars.compile(await $.get(`templates\\register\\registerPage.hbs`));
            $(`#main`).html(template());
        });

        this.post(`#/register`,function (context) {
            auth.register(context.params.username,context.params.password,context.params.repeatPassword);
            this.redirect(`#/login`);
        });

        this.post(`#/login`,function (context) {
            this.then(function () {
                let data = auth.login(context.params.username,context.params.password);
                auth.saveSession(data);
                this.redirect(`#/login`);
            })
        });

        async function loadHome() {
            let template = Handlebars.compile(await $.get(`templates\\home\\home.hbs`));
            $(`#main`).html(template());
        }
    });

    app.run();
});