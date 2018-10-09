function search() {
    let search = $("#searchText").val();
    let elements = $(`#towns li:contains('${search.trim()}')`);
    let size=elements.length;
    elements.css('font-weight', 'bold');


    $(`#result`).text(size+" matches found.");

}
