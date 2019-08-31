import CategoryModel from '../domain/models/category.model';


const CategoryRepository = {

    async save(category) {
        return new CategoryModel(category).save();
    },

    async findAll() {
        return CategoryModel.find().exec();
    },

    async findById(id) {
        return CategoryModel.findOne({'_id': id}).exec();
    },

    async findByName(name) {
        return CategoryModel.findOne({'name': name}).exec();
    },

};

export default CategoryRepository;