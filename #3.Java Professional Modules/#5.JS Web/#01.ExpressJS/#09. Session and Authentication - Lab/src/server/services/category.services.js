import CategoryRepository from '../repositories/category.repository';


const CategoryServices = {

    async save(category) {
        return CategoryRepository.save;
    },

    async findAll() {
        return CategoryRepository.findAll;
    },

    async addProduct(categoryId, productId) {
        let category = await CategoryRepository.findById(categoryId);
        category.products.push(productId);
        return category.save();
    },

    async findById(id) {
        return CategoryRepository.findById(id);
    },

    async findByName(name) {
        return CategoryRepository.findByName(name);
    },

    async addCategory(creator, category) {
        category.creator = creator.id;
        category = await save(category);
        creator.createdCategories.push(category);
        creator.save();
    },
};

export default CategoryServices;