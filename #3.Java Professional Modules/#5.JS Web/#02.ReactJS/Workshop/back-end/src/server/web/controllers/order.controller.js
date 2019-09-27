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

Router.get(OrderRoutingURLs.ALL, async (request, response) => {
    let {status} = request.query;

    let orders = await OrderServices.findAllByStatus(status);

    RestResponseHelper.respondSuccessful(response, RestResponseMessages.ORDERS_FETCHED_SUCCESSFULLY, orders)
});

Router.post(OrderRoutingURLs.APPROVE, async (request, response) => {
    let {id} = request.params;

    await OrderServices.approve(id);

    RestResponseHelper.respondSuccessful(response, RestResponseMessages.ORDER_APPROVED_SUCCESSFULLY)
});

export default Router;