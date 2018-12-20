const BASE_URL = 'https://baas.kinvey.com/';
const APP_KEY = 'kid_rJV1Rm2yV';
const APP_SECRET = '14e840b7d45d459b948d854aeb8b4741';
const AUTH_HEADERS = {'Authorization': "Basic " + btoa(APP_KEY + ":" + APP_SECRET)};
const BOOKS_PER_PAGE = 10;

function registerUser() {
    let username = $(`#formRegister input[name = "username"]`)[0].value;
    let password = $(`#formRegister input[name = "passwd"]`)[0].value;

    $.ajax({
        method: "POST",
        headers: AUTH_HEADERS,
        url: BASE_URL + "user/" + APP_KEY,
        data: {username: username, password: password}
    }).then(function (res) {
        signInUser(res, 'Registration successful.')
    }).catch(handleAjaxError);
}

function logoutUser() {
    sessionStorage.removeItem("authToken");
    sessionStorage.removeItem("username");
    showHomeView();
    showHideMenuLinks();
    showInfo('Logout successful.')
}

function signInUser(res, message) {
    saveAuthInSession(res);
    showHomeView();
    showHideMenuLinks();
    showInfo(message);
}

function saveAuthInSession(userInfo) {
    sessionStorage.setItem("authToken", userInfo._kmd.authtoken);
    sessionStorage.setItem("username", userInfo.username);
}

function loginUser() {
    let username = $(`#formLogin input[name = "username"]`)[0].value;
    let password = $(`#formLogin input[name = "passwd"]`)[0].value;
    $.ajax({
        method: "POST",
        headers: AUTH_HEADERS,
        url: BASE_URL + "user/" + APP_KEY + "/login",
        data: {username: username, password: password}
    }).then(function (res) {
        signInUser(res, 'Login successful.')
    }).catch(handleAjaxError);
}

function listBooks() {

    $.ajax({
        method: "GET",
        headers: {Authorization: 'Kinvey ' + sessionStorage.getItem('authToken')},
        url: BASE_URL + "appdata/" + APP_KEY + "/books",
    }).then(function (res) {
        displayPaginationAndBooks(res.reverse())
    }).catch(handleAjaxError);
}


function createBook() {
    let title = $(`#formCreateBook input[name = "title"]`)[0].value;
    let author= $(`#formCreateBook input[name = "author"]`)[0].value;
    let description= $(`#formCreateBook textarea[name = "description"]`)[0].value;
    $.ajax({
        method: "POST",
        headers: {Authorization: 'Kinvey ' + sessionStorage.getItem('authToken')},
        url: BASE_URL + "appdata/" + APP_KEY + "/books",
        data: {title:title,author:author,description:description}
    }).then(function (res) {
         console.log(res);
        showInfo('Book created.')
    }).catch(handleAjaxError);
}

function deleteBook(book) {
    $.ajax({
        method: "DELETE",
        url: BASE_URL + 'appdata/' + APP_KEY + '/books/' + book._id,
        headers: {Authorization: 'Kinvey ' + sessionStorage.getItem('authToken')}
    }).then(function (res) {
        console.log(res);
        showInfo('Book deleted.')
    }).catch(handleAjaxError)
}

function loadBookForEdit(book) {
    showView("viewEditBook");
    $(`#formEditBook input[name = "id"]`).val(book._id);
    $(`#formEditBook input[name = "title"]`).val(book.title);
    $(`#formEditBook input[name = "author"]`).val(book.title);
    $(`#formEditBook textarea[name = "description"]`).val(book.description);
}

function editBook() {
    $.ajax({
        type: "PUT",
        url: BASE_URL + 'appdata/' + APP_KEY + '/books/' + $(`#formEditBook input[name = "id"]`).val(),
        headers: {Authorization: 'Kinvey ' + sessionStorage.getItem('authToken')},
        data: {title:  $(`#formEditBook input[name = "title"]`).val(),author:  $(`#formEditBook input[name = "author"]`).val(),
        description:  $(`#formEditBook input[name = "description"]`).val()}
    }).then(function () {
        showInfo('Book edited.')
    }).catch(handleAjaxError);
}

function displayPaginationAndBooks(books) {
    let len = $(`#books`).find(`table`)[0].children[0].children.length-1;
    for (let i = len; i > 2; i--) {
            $(`#books`).find(`table`)[0].children[0].children[i].remove();
    }
    let pagination = $('#pagination-demo')
    if (pagination.data("twbs-pagination")) {
        pagination.twbsPagination('destroy')
    }
    pagination.twbsPagination({
        totalPages: Math.ceil(books.length / BOOKS_PER_PAGE),
        visiblePages: 5,
        next: 'Next',
        prev: 'Prev',
        onPageClick: function (event, page) {
            let startBook = (page - 1) * BOOKS_PER_PAGE;
            let endBook = Math.min(startBook + BOOKS_PER_PAGE, books.length);
            $(`a:contains(${page})`).addClass('active');
            for (let i = startBook; i < endBook; i++) {
                let trWrapper = $(`<tr></tr>`);
                let tdTitle = $(`<td>${books[i].title}</td>`);
                let tdAuthor = $(`<td>${books[i].author}</td>`);
                let tdDescription = $(`<td>${books[i].description}</td>`);
                let tdButtons = $(`<td></td>`);
                let buttonDelete = $(`<a href="#">[Delete]</a>`);
                let buttonEdit = $(`<a href="#">[Edit]</a>`);
                buttonDelete.on(`click`,function () {
                    deleteBook(books[i])
                    trWrapper.remove();
                });
                buttonEdit.on(`click`,function () {
                    loadBookForEdit(books[i])
                });
                tdButtons.append(buttonDelete);
                tdButtons.append(buttonEdit);
                trWrapper.append(tdTitle);
                trWrapper.append(tdAuthor);
                trWrapper.append(tdDescription);
                trWrapper.append(tdButtons);

                $(`#books`).find(`table`).append(trWrapper);
            }
            showView("viewBooks")
        }
    })
}

function handleAjaxError(response) {
    let errorMsg = JSON.stringify(response)
    if (response.readyState === 0)
        errorMsg = "Cannot connect due to network error."
    if (response.responseJSON && response.responseJSON.description)
        errorMsg = response.responseJSON.description
    showError(errorMsg)
}