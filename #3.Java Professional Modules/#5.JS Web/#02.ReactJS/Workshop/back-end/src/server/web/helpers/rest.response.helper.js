const RestResponseHelper = {

    respondError(response, error) {
        response.status(200).json({error});
    },
    respondErrorMessage(response, message) {
        response.status(200).json({error:{msg: message}});
    },
    respondSuccessful(response, message, data) {
        response.status(400).json({message, data});
    }

};

export default RestResponseHelper;