import Express from "express";
import {BookRoutingURLs} from "../../constants/web/routing.urls.constants";
import BookServices from "../../services/book.services";
import RestResponseHelper from "../helpers/rest.response.helper";
import RestResponseMessages from "../../constants/web/rest.message.constants";
import JWTHelper from "../helpers/jwt.helper";

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
    let books = await BookServices.findAll();

    RestResponseHelper.respondSuccessful(response, RestResponseMessages.BOOKS_FETCHED_SUCCESSFULLY, books)
});

Router.post(BookRoutingURLs.REVIEW, async (request, response) => {
    let {review} = request.body;
    let id = request.params.id;

    let book = await BookServices.findById(id);
    let user = await JWTHelper.getCurrentUser(request);

    let reviewObj = {
        review,
        createdBy: user.username
    };

    book.reviews.push(reviewObj);
    await BookServices.save(book);

    RestResponseHelper.respondSuccessful(response, RestResponseMessages.BOOK_REVIEWED_SUCCESSFULLY)
});

Router.post(BookRoutingURLs.LIKE, async (request, response) => {
    let id = request.params.id;
    let book = await BookServices.findById(id);
    let user = await JWTHelper.getCurrentUser(request);

    await BookServices.like(book, user);

    RestResponseHelper.respondSuccessful(response, RestResponseMessages.BOOK_LIKED_SUCCESSFULLY)
});

Router.post(BookRoutingURLs.UNLIKE, async (request, response) => {
    let id = request.params.id;
    let book = await BookServices.findById(id);
    let user = await JWTHelper.getCurrentUser(request);

    await BookServices.unlike(book, user);

    RestResponseHelper.respondSuccessful(response, RestResponseMessages.BOOK_REMOVE_LIKE_SUCCESSFULLY)
});

Router.post(BookRoutingURLs.DELETE, async (request, response) => {
    let id = request.params.id;

    await BookServices.deleteById(id);
    RestResponseHelper.respondSuccessful(response, RestResponseMessages.BOOK_DELETED_SUCCESSFULLY)
});

export default Router;