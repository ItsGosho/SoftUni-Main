$(async () => {
    //Handlebars.registerPartial("details", await $.get(`templates\\details.hbs`));
    Handlebars.registerPartial("notAuthenticatedMenu", await $.get(`templates\\notAuthenticatedMenu.hbs`));
    Handlebars.registerPartial("authenticatedMenu", await $.get(`templates\\authenticatedMenu.hbs`));
    displayMenuElements();
    app.run();
});