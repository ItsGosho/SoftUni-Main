const REQUEST_VALIDATION_MESSAGES = {
    USER: {
        USERNAME_DOESNT_EXIST: 'Username is not present!',
        USERNAME_TOO_SHORT: 'Username must be at least!',
        PASSWORDS_DOESNT_MATCH: 'Passwords doesn\'t match!',
        EMAIL_NOT_VALID: 'Passwords doesn\'t match!'
    }
};

const {
    USER: UserRequestValidationConstants
} = REQUEST_VALIDATION_MESSAGES;

export {
    UserRequestValidationConstants
}