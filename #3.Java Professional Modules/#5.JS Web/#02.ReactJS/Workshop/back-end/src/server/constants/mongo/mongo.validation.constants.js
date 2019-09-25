const Model = {
    USER: {
        USERNAME_REQUIRED: 'Username is required!',
        EMAIL_REQUIRED: 'Email is required!',
    },
    TOKEN: {
        TOKEN_REQUIRED: 'Token is required!'
    },
    BOOK: {
        TITLE_REQUIRED: 'Title is required!',
        TITLE_UNIQUE: 'Title must be unique!',
        AUTHOR_REQUIRED: 'Author is required!',
        PRICE_REQUIRED: 'Price is required!',
        IMAGE_REQUIRED: 'Image is required!',
    },
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