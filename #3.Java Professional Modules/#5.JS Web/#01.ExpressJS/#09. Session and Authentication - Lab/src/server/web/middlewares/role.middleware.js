module.exports = (role) => {
    return (request, response, next) => {
        /*
        * TODO:
        *  This middleware will be called and if the user in the session has the desired role it will continue
        * */
        next();
    }
};

