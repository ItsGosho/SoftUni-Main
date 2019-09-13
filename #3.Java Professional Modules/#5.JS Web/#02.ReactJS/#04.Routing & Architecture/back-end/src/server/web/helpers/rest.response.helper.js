const RestResponseHeler = {

    respondError(response, error) {
        response.status(400).json({error});
    },
    respondSuccessful(response, message, data) {
        response.status(400).json({message, data});
    }

};

export default RestResponseHeler;