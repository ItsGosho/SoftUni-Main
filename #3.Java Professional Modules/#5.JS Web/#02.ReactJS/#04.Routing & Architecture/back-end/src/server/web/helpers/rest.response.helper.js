const RestResponseHelper = {

    respondError(response, error) {
        response.status(200).json({error});
    },
    respondSuccessful(response, message, data) {
        response.status(400).json({message, data});
    }

};

export default RestResponseHelper;