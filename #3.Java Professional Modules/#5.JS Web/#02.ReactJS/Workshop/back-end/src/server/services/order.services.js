import OrderRepository from "../repositories/order.repository";

const OrderServices = {

    async createOrder(user, booksIds) {
        let order = {
            creator: user.id,
            books: booksIds
        };

        await OrderRepository.save(order);
    },

    async findAllByUserId(userId){
        return OrderRepository.findAllByCreatorId(userId);
    }

};

export default OrderServices;