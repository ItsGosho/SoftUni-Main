import BookRepository from "../repositories/book.repository";

const BookServices = {

    async save(book) {
        return BookRepository.save(book);
    },

    async findById(id) {
        return BookRepository.findById(id);
    },

    async deleteById(id){
        return BookRepository.deleteById(id);
    },

    async findAll() {
        return BookRepository.findAll();
    },

    async findByTitle(title) {
        return BookRepository.findByTitle(title);
    },

    async edit(bookId, book) {

        let originalBook = await BookRepository.findById(bookId);

        originalBook.title = book.title;
        originalBook.description = book.description;
        originalBook.price = book.price;
        originalBook.image = book.image;
        originalBook.author = book.author;
        originalBook.genres = book.genres;

        originalBook.save();
    },
};

export default BookServices;