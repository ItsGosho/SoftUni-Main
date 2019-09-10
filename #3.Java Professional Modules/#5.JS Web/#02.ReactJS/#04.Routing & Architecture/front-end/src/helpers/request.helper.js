import {RequestMethods, RequestHeaders, AuthenticationHeaderType} from "../constants/request.constants";

const RequestHelper = {

    async requestJson(url) {
        return await fetch(url).then(this.transformDataToJson);
    },

    async postDataAuth(url, data, authorizationToken) {
        return await fetch(url, {
            method: RequestMethods.POST,
            headers: {
                [RequestHeaders.AUTHORIZATION]: `${AuthenticationHeaderType.BEARER} ${authorizationToken}`
            },
            body: JSON.stringify(data)
        }).then(this.transformDataToJson);
    },

    async postData(url, data) {
        return await fetch(url, {
            method: RequestMethods.POST,
            body: JSON.stringify(data)
        }).then(this.transformDataToJson);
    },

    transformDataToJson(data) {
        return data.json();
    },

};

export default RequestHelper;