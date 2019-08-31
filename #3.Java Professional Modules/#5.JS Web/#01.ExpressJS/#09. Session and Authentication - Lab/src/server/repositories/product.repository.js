import ProductModel from '../domain/models/product.model';


const ProductRepository = {

    async save(product) {
        return new ProductModel(product).save();
    },

    async findAll() {
        return ProductModel.find().exec();
    },

    async findAllByCategoryId(categoryId) {
        return ProductModel.find({'category': categoryId}).exec();
    },

    async findById(id) {
        return ProductModel.findOne({'_id': id}).exec();
    },

    async removeById(id) {
        return ProductModel.deleteOne({'_id': id}).exec();
    },

    async update(id, product) {
        return ProductModel.updateOne({'_id': id}, product).exec();
    },

};

export default ProductRepository;