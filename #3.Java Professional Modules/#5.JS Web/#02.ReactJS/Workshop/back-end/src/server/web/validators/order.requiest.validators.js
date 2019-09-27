import UserServices from "../../services/user.services";
import {
    BookRequestValidationMessages,
    BookRequestValidationRestriction,
    UniversalRequestValidationMessages,
    UserRequestValidationMessages
} from "../../constants/web/request.validation.constants";
import Format from "sprintf-js";
import BookServices from "../../services/book.services";
import JWTHelper from "../helpers/jwt.helper";

const OrderRequestValidators = {};

export default OrderRequestValidators;