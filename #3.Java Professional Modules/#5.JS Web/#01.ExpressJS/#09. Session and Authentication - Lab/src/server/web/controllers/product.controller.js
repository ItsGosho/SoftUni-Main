import Express from 'express';
import RoutingURLs from '../../constants/routing.urls';
import ProductServices from '../../services/product.services';
import CategoryServices from '../../services/category.services';
import DropboxServices from '../../services/dropbox.services';
import JWTHelper from '../helpers/jwt.helper';
import ViewPaths from '../../constants/resource.paths.constants';


const Router = Express.Router();


Router.get(RoutingURLs.PRODUCT.ADD, async (request, response) => {
    let categories = await CategoryServices.findAll();

    response.render(ViewPaths.PRODUCT.CREATE_PRODUCT, {user: request.user,categories});
});

Router.post(RoutingURLs.PRODUCT.ADD, async (request, response) => {

    let {name, description, price, category} = request.body;
    let image = request.files.image;
    let user = await JWTHelper.getCurrentUser(request);

    let product = {
        name: name,
        description: description,
        price: price,
        category: category,
    };

    await ProductServices.createProduct(image,user,product);
    response.redirect(RoutingURLs.BASE.HOME);
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

    response.redirect(RoutingURLs.BASE.HOME);
});

Router.get(RoutingURLs.PRODUCT.DELETE, async (request, response) => {
    let productId = request.params.id;
    let product = await ProductServices.findById(productId);

    response.render(ViewPaths.PRODUCT.DELETE_PRODUCT, {user: request.user,product});
});

Router.post(RoutingURLs.PRODUCT.DELETE, async (request, response) => {
    let productId = request.params.id;
    await ProductServices.removeById(productId);
    response.redirect(RoutingURLs.BASE.HOME);
});

Router.get(RoutingURLs.PRODUCT.BUY, async (request, response) => {
    let productId = request.params.id;
    let product = await ProductServices.findById(productId);

    response.render(ViewPaths.PRODUCT.BUY_PRODUCT, {user: request.user,product});
});

Router.post(RoutingURLs.PRODUCT.BUY, async (request, response) => {
    let productId = request.params.id;
    let product = await ProductServices.findByIdWIM(productId);
    let user = await JWTHelper.getCurrentUser(request);

    await ProductServices.buy(user,product);

    response.redirect(RoutingURLs.BASE.HOME);
});

export default Router;