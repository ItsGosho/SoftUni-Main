import Cookies from "universal-cookie";
import DateHelper from "./date.helper";

const CookieHelper = {

    pushCookie(name, value, hours) {
        const cookies = new Cookies();

        let expirationDate = DateHelper.dateAfterHours(hours);

        cookies.set(name, value, {
            expires: expirationDate,
        });
    },

    getCookie(name) {
        const cookies = new Cookies();

        return cookies.get(name);
    },

    removeCookie(name) {
        const cookies = new Cookies();

        return cookies.remove(name);
    }
};

export default CookieHelper;