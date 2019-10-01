import registerReducer from "./register.reducer";
import loginReducer from "./login.reducer";
import authenticatedUserReducer from "./authenticated.user.reducer";

export default {
  register: registerReducer,
  login: loginReducer,
  authenticatedUser: authenticatedUserReducer,
}
