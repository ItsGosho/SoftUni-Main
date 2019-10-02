import registerReducer from "./authentcation/register.reducer";
import loginReducer from "./authentcation/login.reducer";
import authenticatedUserReducer from "./authentcation/authenticated.user.reducer";
import logoutReducer from "./authentcation/logout.reducer";
import bookFetchReducer from "./book/book.fetch.reducer";

export default {
  register: registerReducer,
  login: loginReducer,
  logout: logoutReducer,
  authenticatedUser: authenticatedUserReducer,
  bookFetch: bookFetchReducer
}
