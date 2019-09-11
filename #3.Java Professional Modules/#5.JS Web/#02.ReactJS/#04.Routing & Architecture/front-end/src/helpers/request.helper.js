import {RequestMethods, RequestHeaders, AuthenticationHeaderType, ContentTypes} from "../constants/request.constants";

/*TODO: Refactor it!*/
const RequestHelper = {

    async requestJson(url) {
        return await fetch(url).then(this.transformDataToJson);
    },

    async postDataAuth(url, data, authorizationToken) {

        return await fetch(url, {
            method: RequestMethods.POST,
            credentials: 'include',
            headers: {
                [RequestHeaders.AUTHORIZATION]: `${AuthenticationHeaderType.BEARER} ${authorizationToken}`
            },
            body: JSON.stringify(data)
        }).then(this.transformDataToJson);
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