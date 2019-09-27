import BookRepository from "../repositories/book.repository";

const BookServices = {

    async save(book) {
        return BookRepository.save(book);
    },

    async findById(id) {
        return BookRepository.findById(id);
    },

    async deleteById(id) {
        return BookRepository.deleteById(id);
    },

    async findAll() {
        return BookRepository.findAll();
    },

    async findByTitle(title) {
        return BookRepository.findByTitle(title);
    },

    async totalBooks() {
        return BookRepository.findTotal();
    },

    async edit(bookId, book) {

        let originalBook = await BookRepository.findById(bookId);

        originalBook.title = book.title;
        originalBook.description = book.description;
        originalBook.price = book.price;
        originalBook.image = book.image;
        originalBook.author = book.author;
        originalBook.genres = book.genres;

        await BookRepository.save(originalBook);
    },

    async like(book, user) {

        book.likes.push(user.username);

        await BookRepository.save(book);
    },

    async unlike(book, user) {

        book.likes = book.likes.filter(x => x !== user.username);

        await BookRepository.save(book);
    }
};

export default BookServices;