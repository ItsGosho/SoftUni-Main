module.exports = (request, response, next) => {
    console.log('JWT Token validation middleware has been called!'.cyan);
    next();
};

