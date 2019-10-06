const Model = {
    USER: {
        USERNAME_REQUIRED: 'Username is required!',
        EMAIL_REQUIRED: 'Email is required!',
    },
    JWT: {
        TOKEN_REQUIRED: 'JWT is required!'
    },
};

const UserModelValidationMessages = Model.USER;
const JWTModelValidationMessages = Model.JWT;

export {
    UserModelValidationMessages,
    JWTModelValidationMessages,
}