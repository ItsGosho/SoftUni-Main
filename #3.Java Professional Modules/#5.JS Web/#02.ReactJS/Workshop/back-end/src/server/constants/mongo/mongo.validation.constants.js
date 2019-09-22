const MODEL = {
    USER: {
        USERNAME_REQUIRED: 'Username is required!',
        EMAIL_REQUIRED: 'Email is required!',
    },
    TOKEN: {
        TOKEN_REQUIRED: 'Token is required!'
    },
    BOOK: {},
    ORDER: {}
};

const UserValidationConstants = MODEL.USER;
const TokenValidationConstants = MODEL.TOKEN;
const BookValidationConstants = MODEL.BOOK;
const OrderValidationConstants = MODEL.ORDER;

export {
    UserValidationConstants,
    TokenValidationConstants,
    BookValidationConstants,
    OrderValidationConstants,
}