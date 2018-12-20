$(async () => {
    const USERS_BODY = $(`#list .content`);
    const DETAILS_BODY = $(`#details .content`);

    let usersTemplate = Handlebars.compile(await $.get(`templates\\content-template.hbs`));
    let userInfoTemplate = Handlebars.compile(await $.get(`templates\\info.hbs`));

    let usersDataJSON = await $.get(`data.json`);

    for (const user of usersDataJSON) {

        let userHTML = $($.parseHTML(usersTemplate(user)));

        userHTML.on(`click`,function () {
            DETAILS_BODY.empty();
            let userINFO = $.parseHTML(userInfoTemplate(user));
            DETAILS_BODY.append(userINFO);
        });
        USERS_BODY.append(userHTML);
    }

    DETAILS_BODY.html("<h1>TODO</h1>");
});