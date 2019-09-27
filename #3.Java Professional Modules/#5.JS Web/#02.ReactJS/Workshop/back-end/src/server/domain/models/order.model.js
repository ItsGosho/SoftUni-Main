import Mongoose from 'mongoose';
import Format from "sprintf-js";
import ModelNames from "../../constants/mongo/mongo.models.constants";
import {OrderModelLogging} from "../../constants/mongo/mongo.logging.constants";
import OrderStatus from "./enums/order.status.enums";
import {OrderModelValidationMessages} from "../../constants/mongo/mongo.validation.constants";

const Schema = Mongoose.Schema;
const Type = Schema.Types;
const ParseString = Format.sprintf;

const model = new Schema({
    creator: {
        type: Type.ObjectId,
        required: OrderModelValidationMessages.CREATOR_REQUIRED
    },
    books: [
        {
            type: Type.ObjectId,
            required: OrderModelValidationMessages.BOOKS_REQUIRED
        }
    ],
    date: {
        type: Type.Date,
        required: OrderModelValidationMessages.DATE_REQUIRED,
        default: Date.now
    },
    status: {
        type: Type.String,
        enum: {
            values: [OrderStatus.PENDING, OrderStatus.APPROVED, OrderStatus.DELIVERED],
            message: OrderModelValidationMessages.STATUS_INVALID
        },
        default: OrderStatus.PENDING,
    }
});

model.post('save', function (order) {
    console.log(OrderModelLogging.SAVE);
});

let OrderModel = Mongoose.model(ModelNames.ORDER, model);

export default OrderModel;