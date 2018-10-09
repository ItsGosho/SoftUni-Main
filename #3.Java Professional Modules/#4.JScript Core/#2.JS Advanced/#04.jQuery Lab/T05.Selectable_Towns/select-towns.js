function attachEvents() {

    $(`#items li`).on('click',function () {
       if($(this).css('background-color')==='rgb(221, 221, 221)'){
           $(this).removeAttr('data-selected');
           $(this).css('background-color','');
       }else{
           $(this).attr('data-selected', 'true');
           $(this).css('background-color', '#DDD');
       }
    });


    $('#showTownsButton').on('click', function() {
        let selectedLi = $('#items li[data-selected=true]');
        let towns = selectedLi
            .toArray()
            .map(li => li.textContent)
            .join(', ');
        $('#selectedTowns').text("Selected towns: " + towns);
    });
}