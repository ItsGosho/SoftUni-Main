function createBook(wrapper,name,author,ibn) {

    let divElement = $(`<div>`);
    divElement.attr("id","book1");
    divElement.css("border","medium none");

    let pTitleElement=$(`<p>`);
    pTitleElement.addClass("title");
    pTitleElement.text(name);

    let pAuthorElement=$(`<p>`);
    pTitleElement.addClass("author");
    pAuthorElement.text(author);

    let pISBN=$(`<p>`);
    pTitleElement.addClass("isbn");
    pISBN.text(ibn);

    let buttonSelect=$("<button>");
    buttonSelect.text("Select");
    buttonSelect.on("click",function () {
        divElement.css("border","2px solid blue");
    });
    let buttonDeselect=$("<button>");
    buttonDeselect.text("Deselect");
    buttonDeselect.on("click",function () {
        divElement.css("border","");
    });

    divElement.append(pTitleElement);
    divElement.append(pAuthorElement);
    divElement.append(pISBN);
    divElement.append(buttonSelect);
    divElement.append(buttonDeselect);

    $(wrapper).append(divElement);
}