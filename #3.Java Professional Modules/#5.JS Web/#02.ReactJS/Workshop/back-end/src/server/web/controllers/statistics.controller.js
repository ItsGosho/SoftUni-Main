import Express from "express";
import {StatisticsRoutingURLs} from "../../constants/web/routing.urls.constants";

const Router = Express.Router();

Router.get(StatisticsRoutingURLs.TOTAL_USERS, (request,response) => {
    /*
    * TODO:
    *  1.Check if there is logged in user
    *  2.Check if the user role is [ADMIN]
    *  3.Call the user services to find the total number of users in the database
    *  4.Return their count
    * */
});

Router.get(StatisticsRoutingURLs.TOTAL_BOOKS, (request,response) => {
    /*
    * TODO:
    *  1.Check if there is logged in user
    *  2.Check if the user role is [ADMIN]
    *  3.Call the books services to find the total number of books in the database
    *  4.Return their count
    * */
});

Router.get(StatisticsRoutingURLs.TOTAL_ORDERS, (request,response) => {
    /*
    * TODO:
    *  1.Check if there is logged in user
    *  2.Check if the user role is [ADMIN]
    *  3.Call the orders services to find the total number of orders in the database
    *  4.Return their count
    * */
});