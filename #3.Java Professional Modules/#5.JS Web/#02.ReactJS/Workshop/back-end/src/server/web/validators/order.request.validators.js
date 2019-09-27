import UserServices from "../../services/user.services";
import {
    BookRequestValidationMessages,
    BookRequestValidationRestriction, OrderRequestValidationMessages,
    UniversalRequestValidationMessages,
    UserRequestValidationMessages
} from "../../constants/web/request.validation.constants";
import Format from "sprintf-js";
import BookServices from "../../services/book.services";
import JWTHelper from "../helpers/jwt.helper";
import OrderServices from "../../services/order.services";
import OrderStatus from "../../domain/models/enums/order.status.enums";

const OrderRequestValidators = {
    orderPresent: (idField) => {
        return async (data) => {
            let field = data[idField];

            let order = await OrderServices.findById(field);

            if (order === null) {
                return Promise.reject(OrderRequestValidationMessages.ORDER_NOT_FOUND);
            }
        }
    },

    orderNotApproved: (idField) => {
        return async (data) => {
            let field = data[idField];

            let order = await OrderServices.findById(field);

            if (order.status === OrderStatus.APPROVED) {
                return Promise.reject(OrderRequestValidationMessages.ORDER_ALREADY_APPROVED);
            }
        }
    },
};

export default OrderRequestValidators;