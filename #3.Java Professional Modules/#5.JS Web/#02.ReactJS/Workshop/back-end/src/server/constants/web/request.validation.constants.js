const REQUEST_VALIDATION_MESSAGES = {
    USER: {
        USERNAME_DOESNT_EXIST: 'Username is not present!',
        USERNAME_ALREADY_EXIST: 'Username already exist!',
        EMAIL_ALREADY_EXIST: 'Email already exist!',
        USERNAME_TOO_SHORT: 'Username must be at least 3 characters long!',
        USERNAME_TOO_LONG: 'Username must be max 50 characters long!',
        PASSWORDS_DOESNT_MATCH: 'Passwords doesn\'t match!',
        EMAIL_NOT_VALID: 'Email is not valid!'
    },
    MOVIE: {
        TRAILER_URL_NOT_VALID: 'Trailer URL is invalid!',
        POSTER_URL_NOT_VALID: 'Poster URL is invalid!'
    }
};

const REQUEST_VALIDATION_RESTRICTIONS = {
    USER: {
        USERNAME_MIN_LENGTH: 3,
        USERNAME_MAX_LENGTH: 50,
    },
    MOVIE: {
        TITLE_MIN_LENGTH: 3,
        STORYLINE_MIN_LENGTH: 3
    }
};

const UserRequestValidationMessagesConstants = REQUEST_VALIDATION_MESSAGES.USER;
const MovieRequestValidationMessagesConstants = REQUEST_VALIDATION_MESSAGES.MOVIE;

const UserRequestValidationRestrictionConstants = REQUEST_VALIDATION_RESTRICTIONS.USER;
const MovieRequestValidationRestrictionConstants = REQUEST_VALIDATION_RESTRICTIONS.MOVIE;

export {
    UserRequestValidationMessagesConstants,
    MovieRequestValidationMessagesConstants,

    UserRequestValidationRestrictionConstants,
    MovieRequestValidationRestrictionConstants
}