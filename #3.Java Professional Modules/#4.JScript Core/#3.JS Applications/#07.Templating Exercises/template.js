$( () => {
    renderCatTemplate();

    async function renderCatTemplate() {
        const CATS_BODY = $(`#allCats`);

        let catTemplate = Handlebars.compile(await $.get(`templates\\status-code-cat.hbs`));
        let codes = {codes:await $.get(`codes.json`)};

        let result = catTemplate(codes);
        CATS_BODY.append(result);


        $(`.btn-primary`).on(`click`,function () {
            if($($(this).parent().children()[1]).css('display')!=="inline-block"){
                $($(this).parent().children()[1]).css('display', 'inline-block');
                $($(this).parent().children()[0]).text("Hide status code");
            }else{
                $($(this).parent().children()[1]).css('display', 'none');
            }
        });
    }

});
