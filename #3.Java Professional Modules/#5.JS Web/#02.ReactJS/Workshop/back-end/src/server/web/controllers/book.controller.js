import Express from "express";
import {BookRoutingURLs} from "../../constants/web/routing.urls.constants";
import BookServices from "../../services/book.services";
import RestResponseHelper from "../helpers/rest.response.helper";
import RestResponseMessages from "../../constants/web/rest.message.constants";

const Router = Express.Router();

Router.post(BookRoutingURLs.CREATE, async (request, response) => {
    let {title, description, price, image, author, genres} = request.body;

    genres = genres.split(/[, ]+/);

    let book = {
        title,
        description,
        price,
        image,
        author,
        genres
    };

    await BookServices.save(book);

    RestResponseHelper.respondSuccessful(response, RestResponseMessages.BOOK_CREATED_SUCCESSFULLY)
});

Router.post(BookRoutingURLs.EDIT, async (request, response) => {
    let {title, description, price, image, author, genres} = request.body;
    let bookId = request.params.id;

    genres = genres.split(/[, ]+/);

    let book = {
        title,
        description,
        price,
        image,
        author,
        genres
    };

    await BookServices.edit(bookId, book);

    RestResponseHelper.respondSuccessful(response, RestResponseMessages.BOOK_EDITED_SUCCESSFULLY)
});

Router.get(BookRoutingURLs.ALL, async (request, response) => {
    /*
    * TODO:
    *  1.Дали user-a е логнат?
    */

    let books = await BookServices.findAll();

    RestResponseHelper.respondSuccessful(response, RestResponseMessages.BOOKS_FETCHED_SUCCESSFULLY, books)
});

Router.post(BookRoutingURLs.REVIEW, (request, response) => {
    /*
    * TODO:
    *  1.Дали user-a е логнат
    *  2.Дали има книга с това ID
    *  3.Дали REVIEW-то е поне 4 символа
    *  4.Създавам обекта така:
    *  let reviewObj = {
        review,
        createdBy: username
       }
     * 6.И го пъхам в на book-a reviews масива
    *  7.Respond-вам successful с "Review has been published!"
    * */
});

Router.post(BookRoutingURLs.LIKE, (request, response) => {
    /*
    * TODO:
    *  1.Дали user-a е логнат
    *  2.Дали има книга с това ID
    *  3.Дали вече НЕ я е харесал
    *  4.И във на book likes просто пъхам username-a му
    *  5.Respond-вам successful с "Liked successfully!"
    * */
});

Router.post(BookRoutingURLs.UNLIKE, (request, response) => {
    /*
    * TODO:
    *  1.Дали user-a е логнат
    *  2.Дали има книга с това ID
    *  3.Дали вече я е харесал
    *  4.И във на book likes просто махам username-a му
    *  5.Respond-вам successful с "Like removed!"
    * */
});

Router.post(BookRoutingURLs.DELETE,async (request, response) => {
    let id = request.params.id;

    await BookServices.deleteById(id);
    RestResponseHelper.respondSuccessful(response, RestResponseMessages.BOOK_DELETED_SUCCESSFULLY)
});

export default Router;