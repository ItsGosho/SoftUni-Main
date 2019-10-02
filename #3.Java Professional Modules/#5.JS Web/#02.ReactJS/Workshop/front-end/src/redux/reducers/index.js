import registerReducer from "./register.reducer";
import loginReducer from "./login.reducer";
import authenticatedUserReducer from "./authenticated.user.reducer";
import logoutReducer from "./logout.reducer";
import bookFetchReducer from "./book.fetch.reducer";

export default {
  register: registerReducer,
  login: loginReducer,
  logout: logoutReducer,
  authenticatedUser: authenticatedUserReducer,
  bookFetch: bookFetchReducer
}
