function increment(string) {

    let wrapper = $(string);
    let textArena = $(`<textarea>`);
    textArena.addClass("counter");
    textArena.prop("disabled",true);
    textArena.text(0);

    let buttonIncrement=$(`<button>`);
    buttonIncrement.addClass("btn");
    buttonIncrement.attr("id","incrementBtn");
    buttonIncrement.text("Increment");

    let buttonAdd=$(`<button>`);
    buttonAdd.addClass("btn");
    buttonAdd.attr("id","addBtn");
    buttonAdd.text("Add");

    let ul = $(`<ul>`);
    ul.addClass("results");

    wrapper.append(textArena);
    wrapper.append(buttonIncrement);
    wrapper.append(buttonAdd);
    wrapper.append(ul);

    $(`#incrementBtn`).on("click",function () {
        $(`.counter`).text(parseInt($(`.counter`).text())+1);
    })

    $(`#addBtn`).on("click",function () {
        let ul = $(`ul`);
        let li = $('<li>');
        li.text(parseInt($(`.counter`).text()));
        ul.append(li);
    })
}
