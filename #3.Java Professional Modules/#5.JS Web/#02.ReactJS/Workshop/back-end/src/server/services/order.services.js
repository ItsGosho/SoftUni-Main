import OrderRepository from "../repositories/order.repository";

const OrderServices = {

    async createOrder(user, booksIds) {
        let order = {
            creator: user.id,
            books: booksIds
        };

        await OrderRepository.save(order);
    }

};

export default OrderServices;