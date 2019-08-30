const Router = require('express').Router();
const RoutingURLs = require('../../constants/routing.urls');
const ProductServices = require('../../services/product.services');
const CategoryServices = require('../../services/category.services');
const DropboxServices = require('../../services/dropbox.services');
const ViewPaths = require('../../constants/view.path.constants');

Router.get(RoutingURLs.PRODUCT.ADD, async (request, response) => {
    let categories = await CategoryServices.findAll();

    response.render(ViewPaths.PRODUCT.CREATE_PRODUCT, {user: request.user,categories});
});

Router.post(RoutingURLs.PRODUCT.ADD, async (request, response) => {

    let {name, description, price, category} = request.body;
    let image = request.files.image;

    let path = await ProductServices.uploadImage(image);

    let product = {
        name: name,
        description: description,
        price: price,
        category: category,
        image: path
    };

    product = await ProductServices.save(product);
    await CategoryServices.addProduct(product.category, product._id);
    response.redirect(RoutingURLs.HOME);
});

Router.get(RoutingURLs.CATEGORY.ALL_PRODUCT_BY_CATEGORY, async (request, response) => {
    let category = await CategoryServices.findByName(request.params.category);
    let products = await ProductServices.findAllByCategory(category.id);

    response.render(ViewPaths.CATEGORY.CATEGORY_PRODUCTS, {user: request.user,products, category});
});

Router.get(RoutingURLs.PRODUCT.EDIT, async (request, response) => {
    let productId = request.params.id;
    let product = await ProductServices.findById(productId);
    let categories = await CategoryServices.findAll();

    response.render(ViewPaths.PRODUCT.EDIT_PRODUCT, {user: request.user,product, categories});
});

Router.post(RoutingURLs.PRODUCT.EDIT, async (request, response) => {
    let id = request.params.id;
    let {name, description, price, category} = request.body;
    let image = request.files.image;

    let product = {
        name: name,
        description: description,
        price: price,
        category: category
    };

    if (image.originalFilename !== "") {
        let originalImage = await ProductServices.findByIdWIM(id);
        await DropboxServices.deleteFile(originalImage.image);
        product.image = await ProductServices.uploadImage(image);
    }

    await ProductServices.updateById(id,product);

    response.redirect(RoutingURLs.HOME);
});

Router.get(RoutingURLs.PRODUCT.DELETE, async (request, response) => {
    let productId = request.params.id;
    let product = await ProductServices.findById(productId);

    response.render(ViewPaths.PRODUCT.DELETE_PRODUCT, {user: request.user,product});
});

Router.post(RoutingURLs.PRODUCT.DELETE, async (request, response) => {
    let productId = request.params.id;
    await ProductServices.removeById(productId);
    response.redirect(RoutingURLs.HOME);
});

Router.get(RoutingURLs.PRODUCT.BUY, async (request, response) => {
    let productId = request.params.id;
    let product = await ProductServices.findById(productId);

    response.render(ViewPaths.PRODUCT.BUY_PRODUCT, {user: request.user,product});
});

module.exports = Router;