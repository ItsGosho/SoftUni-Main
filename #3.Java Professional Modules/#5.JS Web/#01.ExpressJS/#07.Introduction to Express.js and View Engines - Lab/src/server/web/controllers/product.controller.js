const Router = require('express').Router();
const RoutingURLs = require('../../constants/routing.urls');
const ProductServices = require('../../services/product.services');
const CategoryServices = require('../../services/category.services');
const DropboxServices = require('../../services/dropbox.services');
const ViewPaths = require('../../constants/view.path.constants');

Router.get(RoutingURLs.CREATE_PRODUCT, async (request, response) => {
    let categories = await CategoryServices.findAll();

    response.render(ViewPaths.PRODUCT.CREATE_PRODUCT, {categories});
});

Router.post(RoutingURLs.CREATE_PRODUCT, async (request, response) => {

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

    ProductServices.save(product, (e, result) => {
        CategoryServices.addProduct(result.category, result._id);
        response.redirect(RoutingURLs.HOME);
    });
});

Router.get(RoutingURLs.ALL_PRODUCT_BY_CATEGORY, async (request, response) => {
    let category = await CategoryServices.findByName(request.params.category);
    let products = await ProductServices.findAllByCategory(category.id);

    response.render(ViewPaths.CATEGORY.CATEGORY_PRODUCTS, {products, category});
});

Router.get(RoutingURLs.EDIT_PRODUCT_GET, async (request, response) => {
    let productId = request.params.id;
    let product = await ProductServices.findById(productId);
    let categories = await CategoryServices.findAll();

    response.render(ViewPaths.PRODUCT.EDIT_PRODUCT, {product, categories});
});

Router.post(RoutingURLs.EDIT_PRODUCT_POST, async (request, response) => {
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

Router.get(RoutingURLs.DELETE_PRODUCT_GET, async (request, response) => {
    let productId = request.params.id;
    let product = await ProductServices.findById(productId);

    response.render(ViewPaths.PRODUCT.DELETE_PRODUCT, {product});
});

Router.post(RoutingURLs.DELETE_PRODUCT_POST, async (request, response) => {
    let productId = request.params.id;
    await ProductServices.removeById(productId);
    response.redirect(RoutingURLs.HOME);
});

Router.get(RoutingURLs.BUY_PRODUCT_GET, async (request, response) => {
    let productId = request.params.id;
    let product = await ProductServices.findById(productId);

    response.render(ViewPaths.PRODUCT.BUY_PRODUCT, {product});
});

module.exports = Router;