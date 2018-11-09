function addSticker() {
    let titleField = $(`.title`);
    let contentField = $(`.content`);

    if(titleField.val() !=="" && contentField.val() !==""){
        let newLi= $(`<li>`);
        newLi.attr(`class`,`note-content`);
        let buttonX = $(`<a>`);
        buttonX.attr(`class`,`button`);
        buttonX.on(`click`,function () {
            newLi.remove();
        });
        buttonX.text("x");
        let h2 = $(`<h2>`);
        h2.text(titleField.val());
        let p = $(`<p>`);
        p.text(contentField.val());
        newLi.append(buttonX);
        newLi.append(h2);
        newLi.append($(`<hr>`));
        newLi.append(p);

        $(`#sticker-list`).append(newLi);

        titleField.val("");
        contentField.val("");
    }
}