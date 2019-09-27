const RequestValidationMessages = {
    UNIVERSAL: {
        PROPERTY_NOT_STRING: '%s must be string!',
        PROPERTY_NOT_NUMBER: '%s must be number!',
    },
    USER: {
        CREDENTIALS_NOT_VALID: 'Credentials are invalid!',
        USERNAME_DOESNT_EXIST: 'Username is not present!',
        USERNAME_ALREADY_EXIST: 'Username already exist!',
        EMAIL_ALREADY_EXIST: 'Email already exist!',
        USERNAME_TOO_SHORT: 'Username must be at least 3 characters long!',
        USERNAME_TOO_LONG: 'Username must be max 50 characters long!',
        PASSWORDS_DOESNT_MATCH: 'Passwords doesn\'t match!',
        EMAIL_NOT_VALID: 'Email is not valid!'
    },
    BOOK: {
        BOOK_NOT_FOUND: 'Book with this id wasn\'t found!',

        REVIEW_TOO_SHORT: 'Review length must be at least 4!',

        TITLE_TOO_SHORT: 'Title length at least 2!',
        TITLE_EXISTS: 'Book with this title already exists!',

        DESCRIPTION_LENGTH_NOT_IN_RANGE: 'Description must be between 10 and 200 characters long!',

        PRICE_NOT_NEGATIVE: 'Price must be greater than 0!',

        IMAGE_NOT_STARTING_WITH: 'Image must start with http:// or https://',

        BOOK_ALREADY_LIKED: 'Book is already liked!',
        BOOK_NOT_LIKED: 'Book is not liked!',
    }
};

const RequestValidationRestrictions = {
    USER: {
        USERNAME_MIN_LENGTH: 3,
        USERNAME_MAX_LENGTH: 50,
    },
    BOOK: {
        TITLE_MIN_LENGTH: 2,
        REVIEW_MIN_LENGTH: 4,
        DESCRIPTION_MIN_LENGTH: 10,
        DESCRIPTION_MAX_LENGTH: 200,
        PRICE_MIN: 0,
        IMAGE_STARTING_1: 'http://',
        IMAGE_STARTING_2: 'https://',
    }
};

const UniversalRequestValidationMessages = RequestValidationMessages.UNIVERSAL;
const UserRequestValidationMessages = RequestValidationMessages.USER;
const BookRequestValidationMessages = RequestValidationMessages.BOOK;

const UserRequestValidationRestriction = RequestValidationRestrictions.USER;
const BookRequestValidationRestriction = RequestValidationRestrictions.BOOK;

export {
    UniversalRequestValidationMessages,
    UserRequestValidationMessages,
    BookRequestValidationMessages,

    UserRequestValidationRestriction,
    BookRequestValidationRestriction,
}