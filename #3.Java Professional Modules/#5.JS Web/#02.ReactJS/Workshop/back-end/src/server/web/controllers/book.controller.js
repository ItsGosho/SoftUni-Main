import Express from "express";
import {BookRoutingURLs} from "../../constants/web/routing.urls.constants";

const Router = Express.Router();

Router.post(BookRoutingURLs.CREATE,(request,response)=>{
    /*
    * TODO:
    *  1.Дали user-a е логнат
    *  2.Дали user-a е [ADMIN]
    *  3.Дали на book-a TITLE-a e String,Length > 2 ,Doesnt Exist
    *  4.Дали на book-a DESCRIPTION-a е String,Between 10 & 200
    *  5.Дали на book-a PRICE-a е Number,Value > 0
    *  6.Дали на book-a IMAGE-a е String,Starts with http:// || https://
    *  7.Взимам Request Body-то (request.body)
    *  8.Слагам и user-a за creator
    *  9.Respond-вам successful с "Book has been created" и вече запазената книга
    * */
});