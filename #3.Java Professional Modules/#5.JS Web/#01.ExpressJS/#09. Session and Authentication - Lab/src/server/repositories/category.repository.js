import CategoryModel from '../domain/models/category.model';


let save = (category) => {
    return new CategoryModel(category).save();
};

let findAll = () => {
    return CategoryModel.find().exec();
};

let findById = (id) => {
    return CategoryModel.findOne({'_id': id}).exec();
};

let findByName = (name) => {
    return CategoryModel.findOne({'name': name}).exec();
};

export default {
    save,
    findAll,
    findById,
    findByName
};