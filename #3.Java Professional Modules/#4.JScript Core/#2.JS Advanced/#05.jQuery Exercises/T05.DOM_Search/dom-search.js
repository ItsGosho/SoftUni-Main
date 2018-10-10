function domSearch(test,isCaseSensitive) {

    let container = $(test);
    container.addClass("items-control");

    let divControls = $(`<div>`);
    divControls.addClass("add-controls");
    let label = $(`<label>`);
    label.text("Enter text:");
    let input = $(`<input>`);
    let buttonAdd = $(`<a>`);
    buttonAdd.text("Add");
    buttonAdd.addClass("button");
    buttonAdd.css("display","inline-block");
    label.append(input);
    divControls.append(label);
    divControls.append(buttonAdd);

    let divSearch = $(`<div>`);
    divControls.addClass("search-controls");
    let labelSearch = $(`<label>`);
    labelSearch.text("Search:");
    let labelInput = $(`<input>`);
    labelSearch.append(labelInput);
    divSearch.append(labelSearch);

    let divResult = $(`<div>`);
    divResult.addClass("result-controls");
    let ul=$(`<ul>`);
    ul.addClass("items-list");
    divResult.append(ul);

    container.append(divControls);
    container.append(divSearch);
    container.append(divResult);


    $(`.button`).on("click",function () {
        let text = $(`input`)[0].value;
        let newLi= $(`<li>`);
        newLi.addClass("list-item");
        let a = $(`<a>`);
        a.addClass("button");
        a.text("X");
        a.on("click",function () {
            newLi.remove();
        });
        newLi.append(a);
        let strong = $(`<strong>`);
        strong.text(text);
        newLi.append(strong);
        $(`ul`).append(newLi);
    });

    $(`input`)[1].addEventListener("keyup",function () {
        let test=$(`ul`)[0].childNodes;
        let duma = $(`input`)[1].value;

        if(duma!=="") {
            for (let i = 0; i < test.length; i++) {
                //console.log(test[i]);

                if(isCaseSensitive){
                    if (test[i].childNodes[1].textContent.includes(duma)) {
                        test[i].style.display="";
                    } else {
                        test[i].style.display="none";
                    }
                }else{
                    if (test[i].childNodes[1].textContent.toUpperCase().includes(duma.toUpperCase())) {
                        test[i].style.display="";
                    } else {
                        test[i].style.display="none";
                    }
                }
            }
        }else{
            for (let i = 0; i < test.length; i++) {
                test[i].style.display="";
            }
        }
    });
}