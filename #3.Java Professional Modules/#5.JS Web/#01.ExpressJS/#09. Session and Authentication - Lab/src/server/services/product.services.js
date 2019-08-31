import ProductRepository from '../repositories/product.repository';
import CategoryServices from './category.services';
import DropboxServices from './dropbox.services';
import ShortId from 'shortid';
import FileSystem from 'fs';

const ProductServices = {

    async save(product) {
        return ProductRepository.save(product);
    },

    async findAll() {
        let products = await ProductRepository.findAll();
        await this.parseProducts(products);

        return products;
    },

    async findAllByCategory(categoryId) {
        let products = await ProductRepository.findAllByCategoryId(categoryId);
        await this.parseProducts(products);

        return products;
    },

    async uploadImage(image) {
        let file = FileSystem.readFileSync(image.path);
        let extension = image.name.substring(image.name.lastIndexOf('.'));
        let path = `${ShortId.generate()}${extension}`;
        DropboxServices.uploadFile(file, path);

        return path;
    },

    async parseProducts(products) {
        for (let product of products) {
            await this.parseProduct(product);
        }
    },

    async parseProduct(product) {
        if (product.image !== null) {
            let data = await DropboxServices.downloadFile(product.image);
            product.image = 'data:image/jpeg;base64, ' + Buffer.from(data.fileBinary).toString('base64');
            product.category = await CategoryServices.findById(product.category);
        }
    },

    async findById(id) {
        let product = await ProductRepository.findById(id);
        await this.parseProduct(product);
        return product;
    },

    async findByIdWIM(id) {
        return await ProductRepository.findById(id);
    },

    async removeById(id) {
        let product = await ProductRepository.findById(id);
        await DropboxServices.deleteFile(product.image);
        return await ProductRepository.removeById(id);
    },

    async updateById(id, product) {
        return await ProductRepository.update(id, product);
    },

    async createProduct(image, creator, product) {
        product.image = await this.uploadImage(image);
        product.creator = creator.id;
        product = await this.save(product);
        creator.createdProducts.push(product);
        creator.save();
        await CategoryServices.addProduct(product.category, product.id)
    },

    async buy(user, product) {
        if (!product.isBought) {
            product.isBought = true;
            product.buyer = user.id;
            product.save();

            user.boughtProducts.push(product);
            user.save();
        }
    }

};

export default ProductServices;