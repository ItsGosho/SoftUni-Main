import registerReducer from "./register.reducer";
import loginReducer from "./login.reducer";
import authenticatedUserReducer from "./authenticated.user.reducer";
import logoutReducer from "./logout.reducer";
import booksReducer from "./book.reducer";

export default {
  register: registerReducer,
  login: loginReducer,
  logout: logoutReducer,
  authenticatedUser: authenticatedUserReducer,
  book: booksReducer
}
