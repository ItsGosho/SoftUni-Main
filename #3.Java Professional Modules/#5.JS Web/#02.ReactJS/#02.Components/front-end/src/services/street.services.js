import RestURLConstants from "../constants/rest.url.constants";

const Streets = RestURLConstants.STREETS;

const StreetServices = {

    async getAllStreets() {
        let result = await fetch(Streets.ALL).then((data) => data.json());
        return result.streets;
    }

};

export default StreetServices;