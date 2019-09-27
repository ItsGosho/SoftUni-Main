import Express from "express";
import {StatisticsRoutingURLs} from "../../constants/web/routing.urls.constants";
import UserServices from "../../services/user.services";
import RestResponseHelper from "../helpers/rest.response.helper";
import RestResponseMessages from "../../constants/web/rest.message.constants";
import BookServices from "../../services/book.services";
import OrderServices from "../../services/order.services";

const Router = Express.Router();

Router.get(StatisticsRoutingURLs.TOTAL_USERS, async (request, response) => {
    let total = await UserServices.totalUsers();

    RestResponseHelper.respondSuccessful(response, RestResponseMessages.STATISTICS_FETCHED_SUCCESSFULLY, total);
});

Router.get(StatisticsRoutingURLs.TOTAL_BOOKS,async (request, response) => {
    let total = await BookServices.totalBooks();

    RestResponseHelper.respondSuccessful(response, RestResponseMessages.STATISTICS_FETCHED_SUCCESSFULLY, total);
});

Router.get(StatisticsRoutingURLs.TOTAL_ORDERS,async (request, response) => {
    let total = await OrderServices.totalOrders();

    RestResponseHelper.respondSuccessful(response, RestResponseMessages.STATISTICS_FETCHED_SUCCESSFULLY, total);
});

export default Router;