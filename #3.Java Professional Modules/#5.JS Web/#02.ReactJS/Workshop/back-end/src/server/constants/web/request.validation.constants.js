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
    MOVIE: {
        TRAILER_URL_NOT_VALID: 'Trailer URL is invalid!',
        POSTER_URL_NOT_VALID: 'Poster URL is invalid!'
    }
};

const RequestValidationRestrictions = {
    USER: {
        USERNAME_MIN_LENGTH: 3,
        USERNAME_MAX_LENGTH: 50,
    }
};

const UserRequestValidationMessagesConstants = RequestValidationMessages.USER;

const UserRequestValidationRestrictionConstants = RequestValidationRestrictions.USER;

export {
    UserRequestValidationMessagesConstants,

    UserRequestValidationRestrictionConstants,
}