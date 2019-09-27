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
        CREATOR_REQUIRED: 'Creator is required!'
    },
    ORDER: {
        CREATOR_REQUIRED: 'Creator is required!',
        DATE_REQUIRED: 'Date is required!',
        STATUS_INVALID: 'Status is invalid, valid values include [Pending, Approved, Delivered].',
        BOOKS_REQUIRED: 'Books is required!'
    }
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