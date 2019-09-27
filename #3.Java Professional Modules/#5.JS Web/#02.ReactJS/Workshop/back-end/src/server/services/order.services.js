import OrderRepository from "../repositories/order.repository";
import OrderStatus from "../domain/models/enums/order.status.enums";
import BookRepository from "../repositories/book.repository";

const OrderServices = {

    async createOrder(user, booksIds) {
        let order = {
            creator: user.id,
            books: booksIds
        };

        await OrderRepository.save(order);
    },

    async findAllByUserId(userId) {
        return OrderRepository.findAllByCreatorId(userId);
    },

    async findById(id) {
        return OrderRepository.findById(id);
    },

    async totalOrders() {
        return OrderRepository.findTotal();
    },

    async findAllByStatus(status) {
        return OrderRepository.findAllByStatus(status);
    },

    async approve(orderId) {
        let order = await OrderRepository.findById(orderId);
        order.status = OrderStatus.APPROVED;

        await OrderRepository.save(order);
    }
};

export default OrderServices;