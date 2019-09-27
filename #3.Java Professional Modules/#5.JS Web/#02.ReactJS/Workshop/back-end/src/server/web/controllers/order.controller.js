import Express from "express";
import {OrderRoutingURLs} from "../../constants/web/routing.urls.constants";
import JWTHelper from "../helpers/jwt.helper";
import OrderServices from "../../services/order.services";
import RestResponseHelper from "../helpers/rest.response.helper";
import RestResponseMessages from "../../constants/web/rest.message.constants";

const Router = Express.Router();

Router.post(OrderRoutingURLs.CREATE, async (request, response) => {
    const {books} = request.body;
    const user = await JWTHelper.getCurrentUser(request);

    await OrderServices.createOrder(user, books);

    RestResponseHelper.respondSuccessful(response, RestResponseMessages.ORDERS_CREATED_SUCCESSFULLY)
});

Router.get(OrderRoutingURLs.MY, async (request, response) => {
    const user = await JWTHelper.getCurrentUser(request);

    let orders = await OrderServices.findAllByUserId(user.id);

    RestResponseHelper.respondSuccessful(response, RestResponseMessages.ORDERS_FETCHED_SUCCESSFULLY, orders)
});

Router.get(OrderRoutingURLs.ALL, (request, response) => {
    let {status} = request.query;

    console.log(status);

    RestResponseHelper.respondSuccessful(response, RestResponseMessages.ORDERS_FETCHED_SUCCESSFULLY, null)
});

Router.post(OrderRoutingURLs.APPROVE, (request, response) => {
    /*
    * TODO:
    *  1.Дали user-a е логнат
    *  2.Дали user-a е [ADMIN]
    *  3.Дали съществува такъв order
    *  4.Взимам ID-то на order-a (request.params.id)
    *  5.Сменям му статуса на Approve
    *  6.Save-aм го
    *  6.Respond-вам successful с "Orders has been approved!"
    * */
});

export default Router;