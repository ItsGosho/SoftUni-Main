function start() {
   console.log(123);
}

async function showRegistration() {
    Handlebars.registerPartial('navbar',await $.get('templates\\navbars\\anonymous.hbs'));
    Handlebars.registerPartial('footer',await $.get('templates\\footers\\footer.hbs'));

    HandleBarsTools
        .makeTemplate({},
            'templates\\authentication\\register.hbs',
            document.getElementById('rooter'))
}

start();