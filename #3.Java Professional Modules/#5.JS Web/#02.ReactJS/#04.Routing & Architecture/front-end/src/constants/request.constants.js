const RequestMethods = {
    GET: 'get',
    POST: 'post',
    PUT: 'put',
    DELETE: 'delete',
};

const RequestHeaders = {
    AUTHORIZATION: 'Authorization',
    CONTENT_TYPE: 'Content-type',
};

const AuthenticationHeaderType = {
    BEARER: 'Bearer'
};

const ContentTypes = {
    JSON: 'application/json',
    URL: 'application/x-www-form-urlencoded',
};

export {
    RequestMethods,
    RequestHeaders,
    AuthenticationHeaderType,
    ContentTypes
};