import RequestHelper from "../../../helpers/request.helper";
import RestURLs from "../../../constants/rest.url.constants";
import CookieHelper from "../../../helpers/cookie.helper";
import Actions from "../../../constants/actions.constants";


let fetchAllBooksAction = () => {
    return async (dispatch) => {
        let result = await RequestHelper.requestJson(RestURLs.BOOK.ALL);

        dispatch({
            type: Actions.BOOK_FETCH_ALL,
            books: result.data
        });
    }
};

let createBookAction = (title, genres, description, image, author, price) => {
    return async (dispatch) => {
        let result = await RequestHelper.postData(RestURLs.BOOK.CREATE, {
            title,
            genres,
            description,
            image,
            author,
            price
        });

        if (result.error) {
            return dispatch({
                type: Actions.BOOK_CREATE_FAILED,
                message: result.error.msg
            });
        }

        dispatch({
            type: Actions.BOOK_CREATE_SUCCESS,
            message: result.message
        });
    }
};

export {
    fetchAllBooksAction,
    createBookAction
}