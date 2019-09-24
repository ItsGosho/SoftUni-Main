const Model = {
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

const UserModelValidationMessages = Model.USER;
const TokenModelValidationMessages = Model.TOKEN;
const BookModelValidationMessages = Model.BOOK;
const OrderModelValidationMessages = Model.ORDER;

export {
    UserModelValidationMessages,
    TokenModelValidationMessages,
    BookModelValidationMessages,
    OrderModelValidationMessages,
}