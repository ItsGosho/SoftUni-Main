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

    TEAM: {
        NAME_ALREADY_EXIST: 'Name already exist!',
        USER_ALREADY_EXIST: 'User already assigned!'
    },

    PROJECT: {
        NAME_ALREADY_EXIST: 'Name already exist!'
    }
};

const RequestValidationRestrictions = {
    USER: {
        USERNAME_MIN_LENGTH: 3,
        USERNAME_MAX_LENGTH: 50,
    }
};

const UserRequestValidationMessages = RequestValidationMessages.USER;
const ProjectRequestValidationMessages = RequestValidationMessages.PROJECT;
const TeamRequestValidationMessages = RequestValidationMessages.TEAM;

const UserRequestValidationRestriction = RequestValidationRestrictions.USER;

export {
    UserRequestValidationMessages,
    ProjectRequestValidationMessages,
    TeamRequestValidationMessages,

    UserRequestValidationRestriction,
}