function displayMenuElements() {
    if (!this.isAuthorized()) {
        $(`#linkContacts`).hide();
        $(`#linkProfile`).hide();
        $(`#linkLogout`).hide();

        $(`#linkLogin`).show();
        $(`#linkRegister`).show();
    } else {
        $(`#linkLogin`).hide();
        $(`#linkRegister`).hide();

        $(`#linkContacts`).show();
        $(`#linkProfile`).show();
        $(`#linkLogout`).show();
    }
}

function showView(viewName) {
    $('main > section').hide();
    $(`#${viewName}`).show();
}