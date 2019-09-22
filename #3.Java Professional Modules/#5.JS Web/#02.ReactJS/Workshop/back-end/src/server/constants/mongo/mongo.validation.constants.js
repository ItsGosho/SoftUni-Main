const MODEL = {
    USER: {
        USERNAME_REQUIRED: 'Username is required!',
        EMAIL_REQUIRED: 'Email is required!',
    },
    TOKEN: {
        TOKEN_REQUIRED: 'Token is required!'
    },
    ROLE: {
        NAME_REQUIRED: 'Role name is required!'
    },
    MOVIE: {}
};

const UserValidationConstants = MODEL.USER;
const TokenValidationConstants = MODEL.TOKEN;
const RoleValidationConstants = MODEL.ROLE;
const MovieValidationConstants = MODEL.MOVIE;

export {
    UserValidationConstants,
    TokenValidationConstants,
    RoleValidationConstants,
    MovieValidationConstants,
}