import StatusCodes from "../../constants/web/status.code.constants";

const RestResponseHelper = {

    respondError(response, error) {
        response.status(StatusCodes.OK).json({error});
    },
    respondErrorMessage(response, message) {
        response.status(StatusCodes.BAD_REQUEST).json({error: {msg: message}});
    },
    respondSuccessful(response, message, data) {
        response.status(StatusCodes.BAD_REQUEST).json({message, data});
    }

};

export default RestResponseHelper;