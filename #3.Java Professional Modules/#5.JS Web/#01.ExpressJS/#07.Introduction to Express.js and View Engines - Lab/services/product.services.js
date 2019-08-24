const ProductRepository = require('../repositories/product.repository');
const CategoryServices = require('../services/category.services');
const DropboxServices = require('../services/dropbox.services');

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

let uploadImage = (image, callback) => {
    let file = FileSystem.readFileSync(image.path);
    let extension = image.name.substring(image.name.lastIndexOf('.'));
    let path = `${ShortId.generate()}${extension}`;
    DropboxServices.uploadFile(file, path);

    callback(path);
};

let parseProducts = async (products) => {
    for (let product of products) {
        await parseProduct(product);
    }
};

let parseProduct = async (product) => {
    let data = await DropboxServices.downloadFile(product.image);
    product.image = 'data:image/jpeg;base64, ' + Buffer.from(data.fileBinary).toString('base64');
    product.category = await CategoryServices.findById(product.category);
};

let findById = async (id) => {
    let product = await ProductRepository.findById(id);
    await parseProduct(product);
    return product;
};

module.exports = {save, findAll, uploadImage, findAllByCategory, findById};