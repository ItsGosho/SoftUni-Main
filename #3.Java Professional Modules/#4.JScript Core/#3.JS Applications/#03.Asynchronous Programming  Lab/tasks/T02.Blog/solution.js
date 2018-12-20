const URL_POSTS = "https://baas.kinvey.com/appdata/kid_rJV1Rm2yV/posts";
const URL_COMMENTS = "https://baas.kinvey.com/appdata/kid_rJV1Rm2yV/comments";
const LOAD_POSTS_BUTTON = $(`#btnLoadPosts`);
const POSTS_SELECT = $(`#posts`);
const VIEW_POST_BUTTON = $(`#btnViewPost`);
const POST_TITLE_HEADER = $(`#post-title`);
const POST_BODY_HEADER = $(`#post-body`);
const POST_COMMENTS_UL = $(`#post-comments`);

function attachEvents() {
    LOAD_POSTS_BUTTON.attr("disabled", true);
    $.get({
        url: URL_POSTS,
        type: "Get",
        headers: {"Authorization":"Basic " + btoa("guest:guest")}
    }).then(function (result) {
        LOAD_POSTS_BUTTON.attr("disabled", false);
        LOAD_POSTS_BUTTON.on(`click`,function () {
            POSTS_SELECT.empty();
            for (let i = 0; i < result.length; i++) {
                let newOption = $(`<option value = ${result[i]._id}>${result[i].title}</option>`)
                POSTS_SELECT.append(newOption);
            }
        });
    });

    VIEW_POST_BUTTON.on(`click`,function () {
        let val = POSTS_SELECT.val();
        let p1 = $.get({
            url: URL_POSTS+"/"+val,
            type: "Get",
            headers: {"Authorization":"Basic " + btoa("guest:guest")}
        }).then(function (result) {
            let p1 = $.get({
                url: URL_COMMENTS+"/?query="+JSON.stringify({post_id:val}),
                type: "Get",
                headers: {"Authorization":"Basic " + btoa("guest:guest")}
            }).then(function (cmm) {
                POST_COMMENTS_UL.empty();
                POST_TITLE_HEADER.text(result.title);
                POST_BODY_HEADER.text(result.body);
                for (let i = 0; i < cmm.length; i++) {
                    let newLi = $(`<li>${cmm[i].comment}</li>`);
                    POST_COMMENTS_UL.append(newLi);
                }
            });
        });
    });

}