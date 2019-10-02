import registerReducer from "./authentication/reducers/register.reducer";
import loginReducer from "./authentication/reducers/login.reducer";
import authenticatedUserReducer from "./authentication/reducers/authenticated.user.reducer";
import logoutReducer from "./authentication/reducers/logout.reducer";
import bookFetchReducer from "./book/reducers/book.fetch.reducer";
import bookCreateReducer from "./book/reducers/book.create.reducer";

export default {
  register: registerReducer,
  login: loginReducer,
  logout: logoutReducer,
  authenticatedUser: authenticatedUserReducer,
  bookFetch: bookFetchReducer,
  bookCreate: bookCreateReducer
}
