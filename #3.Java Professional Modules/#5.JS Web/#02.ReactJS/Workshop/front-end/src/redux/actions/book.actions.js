import RequestHelper from "../../helpers/request.helper";
import RestURLs from "../../constants/rest.url.constants";
import CookieHelper from "../../helpers/cookie.helper";
import Actions from "../../constants/actions.constants";


let fetchAllBooksAction = () => {
    return async (dispatch) => {
        let result = await RequestHelper.requestJson(RestURLs.BOOK.ALL);

        console.log(result);
        dispatch({
            type: Actions.BOOK_FETCH_ALL,
            books: result.data
        });
    }
};

export {
    fetchAllBooksAction
}