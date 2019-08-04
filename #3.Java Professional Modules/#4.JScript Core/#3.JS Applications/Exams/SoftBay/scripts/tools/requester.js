/*@ItsGosho*/
class Requester {

    constructor() {
        this._requestType = RequestType.GET;
        this._requestUrl = '';
        this._headers = {};
        this._data = {};
        this._async = true;
    }

    build(){
        return this;
    }

    type(type) {
        this._requestType = type;
        return this;
    }

    url(url) {
        this._requestUrl = url;
        return this;
    }

    header(type, value) {
        this._headers[type] = value;
        return this;
    }

    data(data) {
        this._data = data;
        return this;
    }

    async(bool) {
        this._async = bool;
        return this;
    }

    getRequestType() {
        return this._requestType;
    }

    getRequestUrl() {
        return this._requestUrl;
    }

    getHeaders() {
        return this._headers;
    }

    getData() {
        return this._data;
    }

    isAsync() {
        return this._async;
    }
}