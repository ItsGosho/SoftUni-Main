import BookModel from "../domain/models/book.model";


const BookRepository = {

    async save(data) {
        return new BookModel(data).save();
    },

    async deleteById(id) {

        return BookModel.deleteOne({'_id': id}).exec();
    },

    async findById(id) {
        return BookModel.findById(id).exec();
    },

    async findTotal() {
        return BookModel.count({}).exec();
    },

    /*-----*/
};

export default BookRepository;