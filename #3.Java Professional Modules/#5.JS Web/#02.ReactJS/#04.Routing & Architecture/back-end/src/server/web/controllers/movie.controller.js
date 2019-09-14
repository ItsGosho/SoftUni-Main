import Express from 'express';
import UserServices from '../../services/user.services';
import JWTHelper from '../helpers/jwt.helper';
import {MovieRoutingURLs, UserRoutingURLs} from "../../constants/web/routing.urls";
import RestResponseHelper from "../helpers/rest.response.helper";
import RoleServices from "../../services/role.services";
import MovieServices from "../../services/movie.services";


const Router = Express.Router();

Router.post(MovieRoutingURLs.CREATE, async (request, response) => {
    let {title, storyLine, trailerUrl, poster} = request.body;

    let movie = {title, storyLine, trailerUrl, poster};

    movie = await MovieServices.save(movie);

    RestResponseHelper.respondSuccessful(response, 'Movie created successful!', movie);
});

Router.get(MovieRoutingURLs.ALL, async (request, response) => {
    let movies = await MovieServices.findAll();

    RestResponseHelper.respondSuccessful(response, 'Movies fetched successful!', movies);
});

export default Router;