const RequestValidationMessages = {
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
        TITLE_NOT_STRING: 'Title must be string!',
        TITLE_TOO_SHORT: 'Title length at least 2!',
        TITLE_EXISTS: 'Book with this title already exists!',

        DESCRIPTION_NOT_STRING: 'Description must be string!',
        DESCRIPTION_LENGTH_NOT_IN_RANGE: 'Description must be between 10 and 200 characters long!',

        PRICE_NOT_NUMBER: 'Price must be number!',
        PRICE_NOT_NEGATIVE: 'Price must be greater than 0!',

        IMAGE_NOT_STRING: 'Image must be string!',
        IMAGE_NOT_STARTING_WITH: 'Image must start with http:// or https://',
    }
};

const RequestValidationRestrictions = {
    USER: {
        USERNAME_MIN_LENGTH: 3,
        USERNAME_MAX_LENGTH: 50,
    },
    BOOK: {
        TITLE_MIN_LENGTH: 2,
        DESCRIPTION_MIN_LENGTH: 10,
        DESCRIPTION_MAX_LENGTH: 200,
        IMAGE_STARTING_1: 'http://',
        IMAGE_STARTING_2: 'https://',
    }
};

const UserRequestValidationMessages = RequestValidationMessages.USER;
const BookRequestValidationMessages = RequestValidationMessages.BOOK;

const UserRequestValidationRestriction = RequestValidationRestrictions.USER;
const BookRequestValidationRestriction = RequestValidationRestrictions.BOOK;

export {
    UserRequestValidationMessages,
    BookRequestValidationMessages,

    UserRequestValidationRestriction,
    BookRequestValidationRestriction,
}