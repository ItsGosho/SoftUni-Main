import {RequestMethods, RequestHeaders, ContentTypes} from "../constants/request.constants";

const RequestHelper = {

    async requestJson(url) {
        return fetch(url).then(this.transformDataToJson);
    },

    async postData(url, data) {
        return await fetch(url, {
            method: RequestMethods.POST,
            credentials: 'include',
            headers: {
                [RequestHeaders.CONTENT_TYPE]: ContentTypes.JSON
            },
            body: JSON.stringify(data)
        }).then(this.transformDataToJson);
    },

    transformDataToJson(data) {
        return data.json();
    },

};

export default RequestHelper;