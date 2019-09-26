import UserServices from "../../services/user.services";
import {UserRequestValidationMessages} from "../../constants/web/request.validation.constants";


const BookRequestValidators = {

    isString: (field) => {
        return async (data) => {
            let field = data[field];

            if(typeof field !== 'string'){
                return Promise.reject();
            }
        }
    }
};

export default BookRequestValidators;