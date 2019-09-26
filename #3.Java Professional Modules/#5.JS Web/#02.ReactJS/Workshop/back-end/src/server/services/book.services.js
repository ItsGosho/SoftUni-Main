import BookRepository from "../repositories/book.repository";

const BookServices = {

    async save(book) {
        return BookRepository.save(book);
    },

    async findByTitle(title) {
        return BookRepository.findByTitle(title);
    }
};

export default BookServices;