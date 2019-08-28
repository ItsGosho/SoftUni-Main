const ProductRepository = require('../repositories/product.repository');
const CategoryServices = require('./category.services');
const DropboxServices = require('./dropbox.services');

const ShortId = require('shortid');
const FileSystem = require('fs');

let save = (product, callback) => {
    return ProductRepository.save(product, (e, savedProduct) => {
        callback(e, savedProduct);
    });
};

let findAll = async () => {
    let products = await ProductRepository.findAll();
    await parseProducts(products);


    return products;
};

let findAllByCategory = async (categoryId) => {
    let products = await ProductRepository.findAllByCategoryId(categoryId);
    await parseProducts(products);

    return products;
};

let uploadImage = (image) => {
    let file = FileSystem.readFileSync(image.path);
    let extension = image.name.substring(image.name.lastIndexOf('.'));
    let path = `${ShortId.generate()}${extension}`;
    DropboxServices.uploadFile(file, path);

    return path;
};

let parseProducts = async (products) => {
    for (let product of products) {
        await parseProduct(product);
    }
};

let parseProduct = async (product) => {
    if(product.image !== null){
        let data = await DropboxServices.downloadFile(product.image);
        product.image = 'data:image/jpeg;base64, ' + Buffer.from(data.fileBinary).toString('base64');
        product.category = await CategoryServices.findById(product.category);
    }
};

let findById = async (id) => {
    let product = await ProductRepository.findById(id);
    await parseProduct(product);
    return product;
};

let findByIdWIM = async (id) => {
    return await ProductRepository.findById(id);
};

let removeById = async (id) => {
    let product = await ProductRepository.findById(id);
    DropboxServices.deleteFile(product.image);
    return await ProductRepository.removeById(id);
};

let updateById = async (id,product) =>{
    return await ProductRepository.update(id,product);
};

module.exports = {
    save,
    findAll,
    uploadImage,
    findAllByCategory,
    findById,
    removeById,
    updateById,
    findByIdWIM
};