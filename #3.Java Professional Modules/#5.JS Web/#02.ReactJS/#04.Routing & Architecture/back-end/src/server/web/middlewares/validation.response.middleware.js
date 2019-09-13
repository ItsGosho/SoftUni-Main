const {validationResult: ValidationResult} = require('express-validator');

export default(request, response, next) => {
    const errors = ValidationResult(request);
    if (!errors.isEmpty()) {
        return response.status(400).json({error: errors.array()[0]});
    }
    next();
};