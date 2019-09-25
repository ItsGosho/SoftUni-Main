import OrderModel from "../domain/models/order.model";


const OrderRepository = {

    async save(data) {
        return new OrderModel(data).save();
    },

    async deleteById(id) {

        return OrderModel.deleteOne({'_id': id}).exec();
    },

    async findById(id) {
        return OrderModel.findById(id).exec();
    },

    async findTotal() {
        return OrderModel.count({}).exec();
    },

    /*-----*/
};

export default OrderRepository;