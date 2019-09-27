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

    await OrderServices.createOrder(user,books);

    RestResponseHelper.respondSuccessful(response,RestResponseMessages.ORDERS_CREATED_SUCCESSFULLY)
});

Router.post(OrderRoutingURLs.MY, (request, response) => {
    /*
    * TODO:
    *  1.Дали user-a е логнат
    *  2.Взимам на user-a ID-то и му намирам всички order-и
    *  3.Respond-вам successful с "Orders have been fetched!" и order-ите
    * */
});

Router.post(OrderRoutingURLs.ALL, (request, response) => {
    /*
    * TODO:
    *  1.Дали user-a е логнат
    *  2.Дали user-a е [ADMIN]
    *  3.Взимам QUERY PARAM за сега с status (request.query.status)
    *  4.Взимам всички order-и,които имат този статус
    *  5.Respond-вам successful с "Orders have been fetched!" и order-ите
    * */
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