const DATABASE_URL = "https://test-project-10122018.firebaseio.com/phonebooks";

$(`#btnLoad`).on(`click`,function () {
    $.ajax({
        url: DATABASE_URL+".json",
        success: displayResult
    })
});

$(`#btnCreate`).on(`click`,function () {
     let person = $(`#person`).val();
     let phone = $(`#phone`).val();

     let res = JSON.stringify({person:person,phone:phone});

    $.ajax({
        type: 'Post',
        url: DATABASE_URL+".json",
        data: res,
        success: function (res) {
           let id = res.name;
           add(id,person,phone);
        }
    })
});

function displayResult(res) {
    $(`#phonebook`).empty();
    for (let [key, value] of Object.entries(res)) {
       add(key,value.person,value.phone)
    }
}

function add(id,person,phone) {
    let li = $(`<li>`);
    li.text(person+": "+phone);
    let deleteButt = $(`<a href = "#"> Delete</a>`);
    deleteButt.on(`click`,function () {
        $.ajax({
            type: 'Delete',
            url: DATABASE_URL+"/"+id+".json",
            success: function () {
                li.remove();
            }
        })
    });
    li.append(deleteButt);

    console.log(id, person,phone);
    $(`#phonebook`).append(li);
}