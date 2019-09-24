import RestResponseHelper from "../helpers/rest.response.helper";

const {validationResult: ValidationResult} = require('express-validator');

//Proceed validation messages if there is validation error in express-validator
const ValidationResponseMiddleware = (request, response, next) => {
    const errors = ValidationResult(request);

    if (!errors.isEmpty()) {
        return RestResponseHelper.respondError(response, errors.array()[0]);
    }

    next();
};

export default ValidationResponseMiddleware;