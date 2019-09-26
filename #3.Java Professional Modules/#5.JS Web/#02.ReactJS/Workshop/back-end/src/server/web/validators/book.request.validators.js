import UserServices from "../../services/user.services";
import {
    BookRequestValidationMessages,
    BookRequestValidationRestriction,
    UniversalRequestValidationMessages,
    UserRequestValidationMessages
} from "../../constants/web/request.validation.constants";
import Format from "sprintf-js";
import BookServices from "../../services/book.services";

const ParseString = Format.sprintf;

const BookRequestValidators = {

    titleLengthValid: (titleField) => {
        return async (data) => {
            let field = data[titleField];

            if (typeof field !== 'string') {
                return Promise.reject(ParseString(UniversalRequestValidationMessages.PROPERTY_NOT_STRING, field));
            }

            if (field.length < BookRequestValidationRestriction.TITLE_MIN_LENGTH) {
                return Promise.reject(BookRequestValidationMessages.TITLE_TOO_SHORT);
            }
        }
    },

    descriptionLengthValid: (descriptionField) => {
        return async (data) => {
            let field = data[descriptionField];

            if (typeof field !== 'string') {
                return Promise.reject(ParseString(UniversalRequestValidationMessages.PROPERTY_NOT_STRING, field));
            }

            if (field.length < BookRequestValidationRestriction.DESCRIPTION_MIN_LENGTH && field.length > BookRequestValidationRestriction.DESCRIPTION_MAX_LENGTH) {
                return Promise.reject(BookRequestValidationMessages.DESCRIPTION_LENGTH_NOT_IN_RANGE);
            }
        }
    },

    titleNotPresent: (titleField) => {
        return async (data) => {
            let field = data[titleField];

            if (typeof field !== 'string') {
                return Promise.reject(ParseString(UniversalRequestValidationMessages.PROPERTY_NOT_STRING, field));
            }

            let book = BookServices.findByTitle(field);

            if (book !== null) {
                return Promise.reject(BookRequestValidationMessages.TITLE_EXISTS);
            }
        }
    },

    priceValid: (priceField) => {
        return async (data) => {
            let field = data[priceField];

            if (isNaN(field)) {
                return Promise.reject(ParseString(UniversalRequestValidationMessages.PROPERTY_NOT_NUMBER, field));
            }

            if (field < BookRequestValidationRestriction.PRICE_MIN) {
                return Promise.reject(BookRequestValidationMessages.PRICE_NOT_NEGATIVE);
            }
        }
    },

    imageValid: (imageField) => {
        return async (data) => {
            let field = data[imageField];

            if (typeof field !== 'string') {
                return Promise.reject(ParseString(UniversalRequestValidationMessages.PROPERTY_NOT_STRING, field));
            }

            if (field.startsWith(BookRequestValidationRestriction.IMAGE_STARTING_1) === false &&
                field.startsWith(BookRequestValidationRestriction.IMAGE_STARTING_2) === false) {
                return Promise.reject(BookRequestValidationMessages.IMAGE_NOT_STARTING_WITH);
            }
        }
    },
};

export default BookRequestValidators;