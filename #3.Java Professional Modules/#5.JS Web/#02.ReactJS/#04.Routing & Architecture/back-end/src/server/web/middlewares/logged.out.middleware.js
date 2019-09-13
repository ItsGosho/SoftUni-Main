export default (request, response, next) => {
    /*TODO: check with bearer token too*/
    let token = request.cookies.jwt;

    if (token === undefined) {
        next();
        return;
    }

    response.send('<center><h1 style="color:red">You must be logged out!</h1></center>')
};

