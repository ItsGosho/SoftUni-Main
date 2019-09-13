import Express from 'express';


const Router = Express.Router();

Router.get('/test', async (request, response) => {
    response.send('<h1>test</h1>');
});


export default Router;